package epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;

public class DescriptionCareerPage extends BasePage {

    @FindBy(xpath = "//header[@class='recruiting-page__header']/h1")
    private WebElement title;


    public DescriptionCareerPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }
}
