package adminArea;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLogIn {


    /**
     * This method login the user in admin area
     * @param username nickname that is used (for login) when the account has been created
     * @param password password that is used (for login) when the account has been created
     */
    public static void logIn(String username, String password){

        Browser.driver.get("http://shop.pragmatic.bg/admin");

        Browser.driver.findElement(By.id("input-username")).sendKeys(username);
        Browser.driver.findElement(By.id("input-password")).sendKeys(password);
        Browser.driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        WaitUnit.wait.until(ExpectedConditions.titleContains("Dashboard"));
    }
}
