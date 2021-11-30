package epam.page;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Careers')]")
    private WebElement careersBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CareersPage openCareers() {
        careersBtn.click();
        return new CareersPage(driver);
    }
}
