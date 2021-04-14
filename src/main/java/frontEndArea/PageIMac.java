package frontEndArea;

import core.Browser;
import core.WaitUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * You can view PageIMac and all elements in it
 */
public class PageIMac {
    /**
     * Find "Reviews" element, open it and see all the reviews
     */
    public static void chooseReviews(){
        Browser.driver.findElement(By.cssSelector("ul.nav.nav-tabs li:nth-of-type(2) a")).click();
    }

    /**
     * After "Reviews" element is opened, you can write a new review
     * @param name name of the person who write the review
     * @param reviewText your review
     * This method also check if all of rating radio buttons are enable and click it.
     * Rating of the product is randomly selected.
     */
    public static void createNewReview(String name, String reviewText){
        Browser.driver.findElement(By.id("input-name")).sendKeys(name);
        Browser.driver.findElement(By.id("input-review")).sendKeys(reviewText);

        List<WebElement> allRatingRadioButtons = new ArrayList<>();
        allRatingRadioButtons.add(Browser.driver.findElement(By.xpath("//div[4]//input[contains(@value,1)]")));
        allRatingRadioButtons.add(Browser.driver.findElement(By.xpath("//div[4]//input[contains(@value,2)]")));
        allRatingRadioButtons.add(Browser.driver.findElement(By.xpath("//div[4]//input[contains(@value,3)]")));
        allRatingRadioButtons.add(Browser.driver.findElement(By.xpath("//div[4]//input[contains(@value,4)]")));
        allRatingRadioButtons.add(Browser.driver.findElement(By.xpath("//div[4]//input[contains(@value,5)]")));

        for (WebElement allOptions: allRatingRadioButtons){
            allOptions.isEnabled();
            allOptions.click();
        }
        Random but = new Random();
        int randomIndex = but.nextInt(5);
        allRatingRadioButtons.get(randomIndex).click();

        Browser. driver.findElement(By.id("button-review")).click();

        WaitUnit.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")));
    }

    /**
     * Check if the new review is submit successfully
     * @param expectedMessage that appear when we submit the review successfully
     */
    public static void verifySuccessfulCreateReview(String expectedMessage) {
        Assert.assertTrue(Browser.driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText().contains(expectedMessage));
    }

    /**
     * Check if the new review is visible in "Reviews" element
     * @param username of the user who has written the review
     */
    public static void verifyNewReviewIsVisible(String username) {
        Assert.assertTrue(Browser.driver.findElement(By.id("review")).getText().contains(username), "The new review is not shown in reviews");
    }
}
