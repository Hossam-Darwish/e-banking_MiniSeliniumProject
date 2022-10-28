package internetBanking_testCases;

import internetBanking_pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserNameField(userName);
        logger.info("username has been entered");
        loginPage.setPasswordField(password);
        logger.info("password has been entered");
        loginPage.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else{
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }

}
