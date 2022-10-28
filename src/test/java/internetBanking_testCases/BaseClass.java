package internetBanking_testCases;

import internetBanking_utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.config.builder.api.PropertyComponentBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();
    public String baseURL = readconfig.getApplicationURL();
    public String userName = readconfig.getUsername();
    public String password = readconfig.getPassword();
    protected WebDriver driver;
    public  static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br){

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        logger = Logger.getLogger("internetBankingMiniProject");
        driver.get(baseURL);
    }

    @AfterClass
    public  void  tearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }

    public String randomestring(){
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }

    public String randomeNum(){
        String generatedNumber= RandomStringUtils.randomNumeric(5);
        return (generatedNumber);
    }

}
