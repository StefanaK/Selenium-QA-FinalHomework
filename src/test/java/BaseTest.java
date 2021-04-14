import core.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void setUp(){ Browser.setUp();}

    @AfterMethod
    public void quit(){ Browser.quit();}


}
