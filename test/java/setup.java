import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class setup {
    //Declare a Webdriver variable
    public WebDriver driver;


    public void initDriver(){
        System.setProperty("webdriver.gecko.driver","/home/andrius/IdeaProjects/geckodriver");
        //Create a new Firefox
        driver = new FirefoxDriver();




    }

    public void testSleep(Integer seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            Assert.assertTrue(false, "failed to sleep the test");
        }
    }
}
