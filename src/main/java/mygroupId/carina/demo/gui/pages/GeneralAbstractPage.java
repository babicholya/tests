package mygroupId.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import mygroupId.carina.demo.gui.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class GeneralAbstractPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//header[@class='container header']")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class='footer']")
    private ExtendedWebElement footer;

    @FindBy(xpath = "//button[@class='popup-policy__btn--agree']")
    private ExtendedWebElement agreeCookie;

    public GeneralAbstractPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public ExtendedWebElement getFooterMenu() {
        return footer;
    }

    public void agreeCookie() {
        agreeCookie.clickIfPresent(7);
    }
}
