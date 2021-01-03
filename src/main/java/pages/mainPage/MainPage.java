package pages.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.testPages.ABTestPage;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Title section
    @FindBy(className = "heading")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }

    //Subtitle Section
    @FindBy(xpath = "//h2")
    private WebElement subtitle;

    public WebElement getSubtitle() {
        return subtitle;
    }

    //ABTesting section
    @FindBy(linkText = "A/B Testing")
    private WebElement abTest;

    public ABTestPage clickABTest(){
        abTest.click();
        return new ABTestPage(driver);
    }



}
