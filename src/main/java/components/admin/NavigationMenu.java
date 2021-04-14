package components.admin;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represent component in http://shop.pragmatic.bg/admin/ (after AdminLogIn class is use in the test) which is always visible when we move between the pages in this website.
 * You shout to create new object of this class, in the test, to use all methods.
 * You can choose different elements in this component.
 */
public class NavigationMenu {


    @FindBy(how = How.CSS, using = "#menu-catalog a[href=\"#collapse1\"]")
    WebElement Catalog;

    @FindBy(how = How.CSS, using = "#collapse1 li:nth-of-type(9)")
    WebElement Reviews;

    @FindBy(how = How.CSS, using = "#menu-sale a[href=\"#collapse4\"]")
    WebElement Sales;

    @FindBy(how = How.CSS, using = "#collapse4 a[href=\"#collapse4-3\"]")
    WebElement GiftVouchersMenu;

    @FindBy(how = How.CSS, using = "#collapse4-3 li:nth-of-type(1) a")
    WebElement GiftVoucher;


    /**
     * Constructor to create new object of this class, in the test, to use all methods.
     */
    public NavigationMenu(){
        PageFactory.initElements(Browser.driver, this);
    }

    /**
     * Find "Catalog" section in navigation menu, choose it and wait until all of it child elements are visible
     */
    public void chooseCatalogSection() {
        Catalog.click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse1 li:nth-of-type(10)")));

    }

    /**
     * Find "Reviews" section in navigation menu, choose it and wait until switch to PageReviews
     * First you shout to choose "Catalog" section.
     */
    public void chooseReviewsSection () {
        Reviews.click();
        WaitUnit.wait.until(ExpectedConditions.titleContains("Reviews"));
    }

    /**
     * Find "Sales" section in navigation menu, choose it and wait until all of it child elements are visible
     */
    public void chooseSalesSection(){
        Sales.click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse4 a[href=\"#collapse4-3\"]")));
    }

    /**
     * Find "Gift Vouchers" section in navigation menu, choose it and wait until all of it child elements are visible
     * First you shout to choose "Sales" section.
     */
    public void chooseGiftVouchersMenu(){
        GiftVouchersMenu.click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapse4-3 li:nth-of-type(1) a")));
    }

    /**
     * Find "Gift Vouchers" section in navigation menu, choose it and wait until switch to PageGiftVouchers
     * First you shout to choose "Gift Vouchers" section.
     */
    public void chooseGiftVouchers(){
        GiftVoucher.click();
    }
}
