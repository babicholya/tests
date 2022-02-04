package mygroupId.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import mygroupId.carina.demo.gui.pages.EstimateProjectPage;
import mygroupId.carina.demo.gui.pages.GetResultPage;
import mygroupId.carina.demo.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EstimateProjectTest implements IAbstractTest {

    @Test()
    public void estimateProjectTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();
        homePage.agreeCookie();

        EstimateProjectPage estimateProjectPage = homePage.getHeaderMenu().toEstimateProjectPage();
        estimateProjectPage.assertPageOpened();
        estimateProjectPage.letsGo();

        GetResultPage getResultPage = estimateProjectPage.answerQuestions();
        getResultPage.fillOutUsernameAndEmail("username", "username1@gmail.com");
        getResultPage.agreedToCollectData();
        getResultPage.downloadPdf();

        softAssert.assertTrue(getResultPage.isAnotherEstimationButtonAppeared(), "Button should appeared on the page!");
        softAssert.assertAll();
    }
}
