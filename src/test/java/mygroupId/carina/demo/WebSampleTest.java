package mygroupId.carina.demo;

import mygroupId.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;


public class WebSampleTest implements IAbstractTest {

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
