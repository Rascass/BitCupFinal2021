package epam;

import epam.enums.Language;
import epam.page.CareersPage;
import epam.page.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EpamTest extends BaseTest {

    @Test
    public void epamTest() {
        SoftAssert sa = new SoftAssert();
        CareersPage careersPage = new CareersPage(driver);
        careersPage.open();
        HomePage homePage = careersPage.getHeader().switchLanguage(Language.GLOBAL_ENGLISH);
        careersPage = homePage.openCareers();
        careersPage.findJobs("Jenkins", "Software Test Engineering", "Belarus, Minsk");
        careersPage.checkApplyButtons(sa);
        sa.assertAll();
    }
}
