package mygroupId.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import mygroupId.carina.demo.utils.MyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class EstimateProjectPage extends GeneralAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@class='btn estimation__btn']")
    private ExtendedWebElement letsGoButton;

    @FindBy(xpath = "//i[@class='radio-icon']")
    private List<ExtendedWebElement> radioIcon;

    @FindBy(xpath = "//i[@class='checkbox-icon']")
    private List<ExtendedWebElement> checkboxIcon;

    @FindBy(xpath = "//span[@class='navigator__cover']")
    private List<ExtendedWebElement> navigatorLink;

    @FindBy(xpath = "//button[@class='btn nav-prev-next__btn nav-prev-next__btn--next']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//h3[@class='question-form-title__nav']")
    private ExtendedWebElement questionFormTitle;

    @FindBy(xpath = "//h2[@class='question-form-title__question']")
    private ExtendedWebElement questionTitle;

    @FindBy(xpath = "//span[@class='hours']")
    private List<ExtendedWebElement> hours;


    public EstimateProjectPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(this.letsGoButton);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()) + "/estimate");
    }

    public void letsGo() {
        letsGoButton.click();
    }

    public GetResultPage answerQuestions() {
        LOGGER.info("Answering the questions...");
        LOGGER.info("We is offered {} questions.", navigatorLink.size());
        navigatorLink.forEach(answer -> {
            LOGGER.info(questionFormTitle.getText());
            LOGGER.info(questionTitle.getText());
            List<ExtendedWebElement> result = MyUtils.joinLists(radioIcon, checkboxIcon);
            result.get(MyUtils.getRandomNumberInts(0, result.size() - 1)).click();
            nextButton.click();
            pause(3);
        });

        return new GetResultPage(getDriver());
    }
}
