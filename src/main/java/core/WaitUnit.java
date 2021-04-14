package core;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Create object "wait" of type WebDriverWait to be reusable in other classes in the project
 */
public class WaitUnit extends Browser {

    public static WebDriverWait wait = new WebDriverWait(driver, 10);
}
