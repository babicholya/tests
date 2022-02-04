package mygroupId.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mygroupId.carina.demo.gui.components.HeaderMenu;


public class HomePage extends GeneralAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='header-logo']")
    private ExtendedWebElement headerLogo;

    @FindBy(xpath = "//section[@class='partners']")
    private ExtendedWebElement partnersSection;

    @FindBy(xpath = "//section[@class='contact-us']")
    private ExtendedWebElement contactUsSection;

    @FindBy(xpath = "//div[@class='footer']")
    private ExtendedWebElement footer;

    @FindBy(xpath = "//section[@class='engagement-models']")
    private ExtendedWebElement engagementModels;

    @FindBy(xpath = "//section[@class='how-we-work']")
    private List<ExtendedWebElement> nowWeWork;

    @FindBy(id = "begin")
    private List<ExtendedWebElement> whatWeOffer;


    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(headerLogo);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }
}
