package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {

    public static WebDriver driver;

    /**
     * Open new browser and maximize it
     */
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Quit the browser
     */
    public static void quit(){
        driver.quit();
    }
}
