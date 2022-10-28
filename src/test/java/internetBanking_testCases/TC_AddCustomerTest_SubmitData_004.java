package internetBanking_testCases;

// checking Add Customer Page using a direct URL.

import internetBanking_pageObjects.AddCustomerPage;
import internetBanking_pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_SubmitData_004 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserNameField(userName);
        logger.info("User name is provided");

        lp.setPasswordField(password);
        logger.info("Passsword is provided");

        lp.clickSubmit();
        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);
        driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        Thread.sleep(3000);
        logger.info("providing customer details....");

        addcust.custName("Hossam");
        addcust.custgender("male");
        addcust.custdob("10","15","1985");

        Thread.sleep(5000);

        addcust.custaddress("Egypt");
        addcust.custcity("Alex");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.custtelephoneno("987890091");

        String email=randomestring()+"@gmail.com";

        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }

    }

    public String randomestring(){
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }


}
