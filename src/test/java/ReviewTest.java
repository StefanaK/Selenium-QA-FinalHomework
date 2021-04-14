import adminArea.AdminLogIn;
import adminArea.PageReviews;
import components.admin.NavigationMenu;
import components.frontend.FrontEndNavigationHeader;
import frontEndArea.PageIMac;
import frontEndArea.PageMac;
import org.testng.annotations.Test;

public class ReviewTest extends BaseTest {

    @Test
    public void writeReview() {

        // GO TO FRONTEND AREA -> MAC REVIEWS AND CREATE NEW REVIEW

        FrontEndNavigationHeader frontEndNavigationHeader = new FrontEndNavigationHeader();
        frontEndNavigationHeader.goToHomePage();
        frontEndNavigationHeader.chooseDesktop();
        frontEndNavigationHeader.chooseMac();

        PageMac.iMac();
        PageIMac.chooseReviews();

        PageIMac.createNewReview("StefanaK", "Excellent product, worth it");
        PageIMac.verifySuccessfulCreateReview("Thank you for your review");


        //OPEN ADMIN AREA AND ENABLE THE REVIEW

        AdminLogIn.logIn("admin30", "parola123!");

        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.chooseCatalogSection();
        navigationMenu.chooseReviewsSection();

        PageReviews.editReviewToEnable();

        //GO TO FRONTEND AREA TO CHECK IF THE REVIEW EXIST

        frontEndNavigationHeader.goToHomePage();

        frontEndNavigationHeader.chooseDesktop();
        frontEndNavigationHeader.chooseMac();

        PageMac.iMac();
        PageIMac.chooseReviews();
        PageIMac.verifyNewReviewIsVisible("StefanaK");

    }
}
