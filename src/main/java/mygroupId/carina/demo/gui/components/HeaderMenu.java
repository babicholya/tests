package mygroupId.carina.demo.gui.components;

import mygroupId.carina.demo.gui.pages.EstimateProjectPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import mygroupId.carina.demo.gui.pages.HomePage;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//a[@href='/contact-us']")
    private ExtendedWebElement contactUs;

    @FindBy(linkText = "Contact Us")
    private ExtendedWebElement newsLink;

    @FindBy(linkText = "Estimate Project")
    private ExtendedWebElement estimateProject;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public EstimateProjectPage toEstimateProjectPage() {
        estimateProject.click();
        return new EstimateProjectPage(getDriver());
    }
}
