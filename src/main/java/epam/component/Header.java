package epam.component;

import constant.TimeConstants;
import epam.page.HomePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePage;
import epam.enums.Language;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j
public class Header extends BasePage {

    private final String LANGUAGES_LOCATOR = "//li[@class='location-selector__item']/a";

    @FindBy(css = "button.location-selector__button")
    private WebElement languageBtn;

    @FindBy(xpath = LANGUAGES_LOCATOR)
    private List<WebElement> languages;

    public Header(WebDriver driver) {
        super(driver);
    }

    public HomePage switchLanguage(Language language) {
        log.info("Switching language...");
        waitUntil(driver, ExpectedConditions.elementToBeClickable(languageBtn), TimeConstants.PAGE_LOAD_TIMEOUT);
        languageBtn.click();
        waitUntil(driver, ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(LANGUAGES_LOCATOR), 0), TimeConstants.PAGE_LOAD_TIMEOUT);
        WebElement languageLink = languages.stream().filter(item -> item.getText().trim().contains(language.getLanguage()))
                .findFirst().get();
        languageLink.click();
        return new HomePage(driver);
    }
}
