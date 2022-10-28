package internetBanking_pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class AddCustomerPage {


    WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private By lnkAddNewCustomer = By.linkText("New Customer");
    private By txtCustomerName = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input");
    private By rdGender = By.name("rad1");
    private By txtdob = By.name("dob");
    private By txtaddress = By.name("addr");
    private By txtcity = By.name("city");
    private By txtstate = By.name("state");
    private By txtpinno = By.name("pinno");
    private By txttelephoneno = By.name("telephoneno");
    private By txtemailid = By.name("emailid");
    private By txtpassword = By.name("password");
    private By btnSubmit = By.name("sub");



    public void clickAddNewCustomer() {
        driver.findElement(lnkAddNewCustomer).click();

    }

    public void custName(String cname) {
        driver.findElement(txtCustomerName).sendKeys(cname);

    }

    public void custgender(String cgender) {
        driver.findElement(rdGender).click();
    }

    public void custdob(String mm,String dd,String yy) {
        driver.findElement(txtdob).sendKeys(mm);
        driver.findElement(txtdob).sendKeys(dd);
        driver.findElement(txtdob).sendKeys(yy);

    }

    public void custaddress(String caddress) {
        driver.findElement(txtaddress).sendKeys(caddress);
    }

    public void custcity(String ccity) {
        driver.findElement(txtcity).sendKeys(ccity);
    }

    public void custstate(String cstate) {
        driver.findElement(txtstate).sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        driver.findElement(txtpinno).sendKeys(String.valueOf(cpinno));
    }

    public void custtelephoneno(String ctelephoneno) {
        driver.findElement(txttelephoneno).sendKeys(ctelephoneno);
    }

    public void custemailid(String cemailid) {
        driver.findElement(txtemailid).sendKeys(cemailid);
    }

    public void custpassword(String cpassword) {
        driver.findElement(txtpassword).sendKeys(cpassword);
    }

    public void custsubmit() {
        driver.findElement(btnSubmit).click();
    }






}
