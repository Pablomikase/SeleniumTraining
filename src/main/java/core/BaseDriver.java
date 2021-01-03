package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.mainPage.MainPage;

public class BaseDriver {

    private final String KEY_DRIVER = "webdriver.chrome.driver";
    private final String DRIVER_LOCATION = "src/main/resources/chromedriver";
    private final String BASE_URL = "https://the-internet.herokuapp.com/";
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUp(){
        System.setProperty(KEY_DRIVER, DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
