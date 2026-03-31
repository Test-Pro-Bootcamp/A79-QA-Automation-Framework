import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {


        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException{
        navigatingToPage();
        provideEmail("andrey.klimov@testpro.io");
        providePassword("W*836553466485uh");
        clickOnLoginButton();
        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
    }

    @Test
    public void loginInvalidEmail() throws InterruptedException {
        navigatingToPage();
        provideEmail("invail@testpro.io");
        providePassword("W*836553466485uh");
        clickOnLoginButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }

    @Test
    public void loginInvalidPassworg() throws InterruptedException {
        navigatingToPage();
        provideEmail("invail@testpro.io");
        providePassword("invalid");
        clickOnLoginButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }

}
