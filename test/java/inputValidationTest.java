import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*****************************************************************************
 * Author:      Andrius Vetrenka
 * Description: This is the first Selenium TestNG test.
 *              It opens swtestacademy homepage and prints and checks its title.
*******************************************************************************/

public class inputValidationTest extends setup {

    //-----------------------------------Global Variables-----------------------------------

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setup (){

        //Declare a test URL variable
         String testURL = "https://www.seb.lt/eng/private/calculator-leasing";


        this.initDriver();

        //Go to www.swtestacademy.com
        this.driver.navigate().to(testURL);
    }

    //-----------------------------------Tests-----------------------------------
    @Test
    public void inputValidation () {
        this.driver.switchTo().frame(this.driver.findElement(By.cssSelector("iframe.calculator-frame")));

        this.testSleep(1000);

        //Clear "Property price" input
        this.driver.findElement(By.cssSelector("#price")).sendKeys(Keys.BACK_SPACE);
        this.driver.findElement(By.cssSelector("#price")).clear();
        //Assert "Property price" input validation error
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(2) span.error"))
                .getText(), "Enter value from 5000");
        this.testSleep(5000);

        //Clear "Contract fee" input
        this.driver.findElement(By.cssSelector("#contractFee")).sendKeys(Keys.BACK_SPACE);
        this.driver.findElement(By.cssSelector("#contractFee")).clear();

        //Assert "Contract fee" input validation error
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(3) span.error"))
                .getText(), "Enter value from 86,89");
        this.testSleep(5000);

        //Clear "Downpayment" input
        this.driver.findElement(By.cssSelector("#downpayment")).sendKeys(Keys.BACK_SPACE);
        this.driver.findElement(By.cssSelector("#downpayment")).clear();

        //Assert "Downpayment" input validation error
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(4) span.error"))
                .getText(), "Enter value from 5 to 99");
        //Clear "Interest rate" input
        this.driver.findElement(By.cssSelector("#interestRate")).sendKeys(Keys.BACK_SPACE);
        this.driver.findElement(By.cssSelector("#interestRate")).clear();

        //Assert "Interest rate" input validation error
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#leaseForm div.span6:nth-of-type(3) > div.control-group span.error"))
                .getText(), "Enter correct interest rate");
        //Clear "Residual value" input
        this.driver.findElement(By.cssSelector("#residualValue")).sendKeys(Keys.BACK_SPACE);
        this.driver.findElement(By.cssSelector("#residualValue")).clear();

        //Assert "Residual value" input validation error
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#leaseForm div.span6:nth-of-type(3) #operatingCol2b span.help-block"))
                .getText(), "Enter value from 0 to 99");
        //Click Calculate button
        this.driver.findElement(By.cssSelector("#getSchedule")).click();
        //Assert ErrorMessage show
        Assert.assertEquals(this.driver.findElement(
                By.cssSelector("#alertError"))
                .getText(), "According to the data you have provided, we are unfortunately unable to issue you a leasing..");

        //Type correct value in all inputs

        //Type "Property price"
        this.driver.findElement(By.cssSelector("#price")).sendKeys("5000");
        this.testSleep(5000);

        //Assert validation error not visible
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(2) span.error")).isDisplayed());

        //Type "Contract fee"
        this.driver.findElement(By.cssSelector("#contractFee")).sendKeys("350");
        //Assert validation error not visible
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(3) span.error")).isDisplayed());

        //Type "Downpayment"
        this.driver.findElement(By.cssSelector("#downpayment")).sendKeys("10");
        //Assert validation error not visible
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#leaseForm div.span6 > div.control-group:nth-of-type(4) span.error")).isDisplayed());

        //Type "Interest rate"
        this.driver.findElement(By.cssSelector("#interestRate")).sendKeys("3");
        //Assert validation error not visible
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#leaseForm div.span6:nth-of-type(3) > div.control-group span.error")).isDisplayed());

        //Type "Residual value"
        this.driver.findElement(By.cssSelector("#residualValue")).sendKeys("0");
        //Assert validation error not visible
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#leaseForm div.span6:nth-of-type(3) #operatingCol2b span.help-block")).isDisplayed());

        //Click Calculate button
        this.driver.findElement(By.cssSelector("#getSchedule")).click();
        //Assert ErrorMessage missing
        Assert.assertFalse(this.driver.findElement(By.cssSelector("#alertError")).isDisplayed());





    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        this.driver.quit();
    }
}
