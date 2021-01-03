package pages.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ABTestPage {

    private WebDriver driver;

    public ABTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3")
    private WebElement title;

    @FindBy(xpath = "//div[@id='content']/div/p")
    private WebElement content;


    public String getTitleText() {
        return title.getText();
    }

    public String getContentText() {
        return content.getText();
    }
}
