import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileNewNameTest extends BaseTest {

    @Test
    public void ProfileNewNameTest() throws InterruptedException {
        navigatingToPage();
        provideEmail("andrey.klimov@testpro.io");
        providePassword("W*836553466485uh");
        clickOnLoginButton();
        Thread.sleep(5000);

        clickOnAvatarIcon();
        Thread.sleep(2000);

        currentPass("W*836553466485uh");
        provideNewProfileName("Jose Rumbos");
        Thread.sleep(5000);

        clickSaveButton();
        Thread.sleep(5000);

        WebElement actualProfileName = driver.findElement(By.xpath("//span[@class='name']"));
        Assert.assertEquals(actualProfileName.getText(), "Jose Rumbos");
    }

    private void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.xpath("//button[@class='btn-submit']"));
        saveButton.click();
    }

    private void provideNewProfileName(String newName) {
        WebElement namefield = driver.findElement(By.xpath("//input[@id='inputProfileName']"));
        namefield.click();
        namefield.clear();
        namefield.sendKeys(newName);

    }

    private void currentPass(String pass) {
        WebElement currentPassfield = driver.findElement(By.xpath("//input[@id='inputProfileCurrentPassword']"));
        currentPassfield.clear();
        currentPassfield.sendKeys(pass);
    }

    private void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.xpath("//img[@class='avatar']"));
        avatarIcon.click();
    }
}
