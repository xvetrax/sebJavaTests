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

public class loansLeasingTabLinksCheck extends setup {

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






    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        this.driver.quit();
    }
}
