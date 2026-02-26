import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework24Test {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Obtain a Chrome session from the local Grid
        driver = BrowserFactory.createChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testKoelHomePage() {
        driver.get("https://qa.koel.app/");
        String pageSource = driver.getPageSource();
        // Simple assertion: the page should contain "Log In"
        Assert.assertTrue(pageSource.contains("Log In"), "Koel login page not loaded");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
