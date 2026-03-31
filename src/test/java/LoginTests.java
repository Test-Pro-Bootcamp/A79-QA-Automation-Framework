import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

        
        //Navigating
        navigatingToPage();
        navigatingToPage();
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
    }


}
