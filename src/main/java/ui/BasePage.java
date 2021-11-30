package ui;

import constant.TimeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage implements DriverHelper {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TimeConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
