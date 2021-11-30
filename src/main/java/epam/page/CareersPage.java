package epam.page;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import ui.BasePage;
import epam.component.Header;
import epam.constant.ProjectConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j
public class CareersPage extends BasePage {

    private final String JOB_OFFERS_LOCATOR = "li.search-result__item";
    private final String APPLY_BTN_LOCATOR = "div.search-result__item-controls";
    private final String JOB_TITLE_LOCATOR = "a.search-result__item-name";

    @FindBy(id = "new_form_job_search_1445745853_copy-keyword")
    private WebElement jobKeyword;

    @FindBy(xpath = "div[contains(@class, 'selected-params')]")
    private WebElement jobSkill;

    @FindBy(css = "recruiting-search__location")
    private WebElement jobLocation;

    @FindBy(css = "button.recruiting-search__submit")
    private WebElement findBtn;

    @FindBy(id = "id-ce1e74aa-e69b-3bd2-9f9f-41628029ec68-remote")
    private WebElement remoteCheckBox;

    @FindBy(xpath = "//li[@role='treeitem']//input")
    private List<WebElement> skillsItems;

    private Header header = new Header(driver);

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public CareersPage open() {
        driver.get(ProjectConstants.CAREERS_URL);
        return new CareersPage(driver);
    }

    public Header getHeader() {
        return header;
    }

    public void findJobs(String keyword, String skill, String location) {
        log.info(String.format("finding job with parameters: keyword - %s, skill - %s, location - %s", keyword, skill, location));
        jobKeyword.click();
        jobKeyword.sendKeys(keyword);
        jobLocation.click();
        jobLocation.sendKeys(location);
        jobSkill.click();
        skillsItems.stream().filter(item -> item.getAttribute("data-value").contains(skill)).findFirst().get().click();
        remoteCheckBox.click();
        findBtn.click();
    }

    public SoftAssert checkApplyButtons(SoftAssert softAssert) {
        List<WebElement> jobsOffers = driver.findElements(By.cssSelector(JOB_OFFERS_LOCATOR));
        softAssert.assertTrue(checkApplyButton(jobsOffers.get(0)));
        softAssert.assertTrue(checkApplyButton(jobsOffers.get(jobsOffers.size() - 1)));
        return softAssert;
    }

    private boolean checkApplyButton(WebElement jobItem) {
        String titleBefore = jobItem.findElement(By.cssSelector(JOB_TITLE_LOCATOR)).getText();
        jobItem.findElement(By.cssSelector(APPLY_BTN_LOCATOR)).click();
        DescriptionCareerPage descriptionCareerPage = new DescriptionCareerPage(driver);
        String titleAfter = descriptionCareerPage.getTitle();
        driver.navigate().back();
        return titleAfter.equals(titleBefore);
    }

}
