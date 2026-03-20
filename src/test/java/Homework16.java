import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 {

    @Test
    public void registrationNavigation() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://qa.koel.app/");

            WebElement registrationLink = driver.findElement(By.xpath("//a[@href='registration']"));
            registrationLink.click();

            String expectedUrl = "https://qa.koel.app/registration";
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

            driver.quit();
    }
}