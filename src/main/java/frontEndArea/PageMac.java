package frontEndArea;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * You can view PageMac and choose some element in this page
 */
public class PageMac {
    /**
     * Choose iMac element in PageMac and go to PageIMac
     */
    public static void iMac(){
        Browser.driver.findElement(By.xpath("//div[@class=\"caption\"]//a")).click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.nav.nav-tabs li:nth-of-type(2) a")));
    }
}
