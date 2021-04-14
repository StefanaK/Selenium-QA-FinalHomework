package adminArea;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PageReviews {
    /**
     * Find the specific new review, open to edit it, change the status to be Enable and save the changes
     */
    public static void editReviewToEnable(){

        Browser.driver.findElement(By.xpath("//tbody//tr//td[text()=\"StefanaK\"]//parent::tr//td[7]//i")).click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-status")));

        Select dropDown = new Select(Browser.driver.findElement(By.id("input-status")));
        dropDown.selectByValue("1");

        Browser.driver.findElement(By.cssSelector("button.btn i.fa.fa-save")).click();
    }
}
