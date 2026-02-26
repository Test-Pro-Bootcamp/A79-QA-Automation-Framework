import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LambdaTestFactory {

    private static final String LT_USERNAME = "calvinqnguyen07";
    private static final String LT_ACCESS_KEY = "LT_9sQQrOBpUUVZ5uKOcp9JqEDmEPqt7a7tohDX614uv6CpCuo";
    private static final String LT_HUB_URL = "https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

    public static WebDriver createDriver(String browserName, String browserVersion, String platformName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browserName);
        caps.setCapability("browserVersion", browserVersion);
        caps.setCapability("platformName", platformName);

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("build", "Homework 25");
        ltOptions.put("name", "Parallel Test");
        ltOptions.put("selenium_version", "4.0.0");
        caps.setCapability("LT:Options", ltOptions);

        try {
            return new RemoteWebDriver(new URL(LT_HUB_URL), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid LambdaTest URL", e);
        }
    }
}
