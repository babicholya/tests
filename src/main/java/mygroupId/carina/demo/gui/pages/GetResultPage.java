package mygroupId.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class GetResultPage extends GeneralAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//button[@class='btn result-form__btn']")
    private ExtendedWebElement downloadPDFButton;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private ExtendedWebElement emailInput;

    @FindBy(id = "respondCheckbox")
    private ExtendedWebElement respondCheckbox;

    @FindBy(xpath = "//label[@for='respondAgree']/span")
    private ExtendedWebElement respondAgreeToCollectData;

    @FindBy(xpath = "//a[@class='btn btn--dark estimator-download__btn']")
    private ExtendedWebElement getAnotherEstimationButton;

    public GetResultPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(downloadPDFButton);
    }

    public void downloadPdf() {
        downloadPDFButton.click();
    }

    public void fillOutUsernameAndEmail(String username, String email) {
        nameInput.type(username);
        emailInput.type(email);
    }

    public void agreedToCollectData() {
        respondAgreeToCollectData.click();
    }

    public boolean isAnotherEstimationButtonAppeared() {
        LOGGER.info("Waiting for the 'Get another estimation' button....");
        waitUntil(ExpectedConditions.visibilityOf(getAnotherEstimationButton.getElement()), 60);
        return getAnotherEstimationButton.isElementPresent();
    }
}
