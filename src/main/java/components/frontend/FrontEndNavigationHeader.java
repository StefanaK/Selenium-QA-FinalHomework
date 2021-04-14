package components.frontend;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represent component in http://shop.pragmatic.bg/ which is always visible when we move between the pages in this website.
 * You shout to create new object of this class, in the test, to use all methods.
 * You can choose different elements in this component.
 */
public class FrontEndNavigationHeader {

    @FindBy(how = How.CSS, using = "div.collapse ul.navbar-nav li:nth-of-type(1) a.dropdown-toggle")
    public static WebElement desktop;

    @FindBy(how = How.CSS, using = "li.dropdown.open ul.list-unstyled li:nth-of-type(2)")
    public static WebElement mac;

    private String url = "http://shop.pragmatic.bg/";

    /**
     * Constructor to create new object of this class, in the test, to use all methods.
     */
    public FrontEndNavigationHeader(){
        PageFactory.initElements(Browser.driver, this);
    }

    /**
     * Find "Desktop" element and choose it.
     */
    public void chooseDesktop(){
        desktop.click();
    }

    /**
     * Find "Mac(1)" element and choose it.
     * First you shout to choose "Desktop" element.
     */
    public void chooseMac(){
        mac.click();
        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]//a")));
    }

    /**
     * Open website "http://shop.pragmatic.bg/".
     */
    public void goToHomePage(){
        Browser.driver.get(this.url);
    }
}
