package internetBanking_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;

    private By userNameField = By.name("uid");

    private By passwordField = By.name("password");

    private By loginBtn = By.name("btnLogin");

    private By lnkLogout = By.xpath("/html/body/div[3]/div/ul/li[15]/a");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserNameField(String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(loginBtn).click();
    }

    public void clickLogout()
    {
        driver.findElement(lnkLogout).click();
    }






}
