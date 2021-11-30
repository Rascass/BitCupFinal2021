package ui;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

interface DriverHelper {

    default void waitUntil(WebDriver driver, ExpectedCondition<?> condition, int timeout) {
        FluentWait wait = new FluentWait(driver).ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(500));
        try {
            wait.until(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
