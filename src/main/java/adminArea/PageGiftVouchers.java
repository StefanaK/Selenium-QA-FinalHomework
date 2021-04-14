package adminArea;

import core.Browser;
import core.WaitUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PageGiftVouchers {

    static String randomCode = RandomStringUtils.randomAlphanumeric(7, 10);

    /**
     * Create new voucher in PageGiftVouchers
     * @param senderName name of the person who will present the voucher
     * @param senderEmail e_mail of the person who will present the voucher
     * @param recipient name of the person who will receive/use the voucher
     * @param recipientEmail email of the person who will receive/use the voucher
     * @param amount amount that the recipient can use with this voucher
     */
    public static void createNewVoucher(String senderName, String senderEmail, String recipient, String recipientEmail, String amount) {

        Browser.driver.findElement(By.cssSelector("div.pull-right i.fa-plus")).click();

        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-status")));

        Browser.driver.findElement(By.id("input-code")).sendKeys(randomCode);
        Browser.driver.findElement(By.id("input-from-name")).sendKeys(senderName);
        Browser.driver.findElement(By.id("input-from-email")).sendKeys(senderEmail);
        Browser.driver.findElement(By.id("input-to-name")).sendKeys(recipient);
        Browser.driver.findElement(By.id("input-to-email")).sendKeys(recipientEmail);
        Browser.driver.findElement(By.id("input-amount")).sendKeys(amount);
        Browser.driver.findElement(By.cssSelector("button i.fa.fa-save")).click();

        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-6 text-right']")));
    }


    /**
     * This method check if the voucher that we would like to create is already existed.
     * If the voucher exist will be deleted.
     * @param senderName use the name of the sender to check if the voucher already exist
     */
    public static void checkIfVoucherExistAndDelete(String senderName) {

        WebElement tableVouchers = Browser.driver.findElement(By.cssSelector("div.table-responsive tbody"));

        if(tableVouchers.getText().contains(senderName)){
            Browser.driver.findElement(By.xpath("//tbody//tr//td[text()=\"Stefana Kazandzhieva\"]//parent::tr//td[1]")).click();
            Browser.driver.findElement(By.cssSelector("button.btn.btn-danger i.fa")).click();
            try{
                Alert alert = Browser.driver.switchTo().alert();
                alert.accept();

                Assert.assertTrue(Browser.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success"), "There is a BUG whit pop-up confirm window");

            } catch (NoAlertPresentException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Verify that the voucher is successfully create
     */
    public static void verifyNewVoucherCreateSuccessfully() {
        Assert.assertTrue(Browser.driver.findElement(By.xpath("//tbody//tr//td[text()=\"Stefana Kazandzhieva\"]//parent::tr//td[2]")).getText().contains(randomCode));
    }
}
