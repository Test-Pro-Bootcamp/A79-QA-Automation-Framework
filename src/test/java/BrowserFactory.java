import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    // The URL of your local Selenium Grid (Standalone mode)
    private static final String GRID_URL = "http://localhost:4444/wd/hub";

    public static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        // Add any Chrome-specific options if needed, e.g.:
        // options.addArguments("--headless");
        // options.addArguments("--no-sandbox");

        try {
            return new RemoteWebDriver(new URL(GRID_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL: " + GRID_URL, e);
        }
    }
}
