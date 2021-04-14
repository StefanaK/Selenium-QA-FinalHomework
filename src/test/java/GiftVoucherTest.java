import adminArea.AdminLogIn;
import adminArea.PageGiftVouchers;
import components.admin.NavigationMenu;
import org.testng.annotations.Test;

public class GiftVoucherTest extends BaseTest {


    @Test
    public void giftVoucherExist(){

        //LOGIN INTO ADMIN AREA AND GO TO GIFT VOUCHER SECTION

        AdminLogIn.logIn("admin30", "parola123!");

        NavigationMenu navigationMenu = new NavigationMenu();
        navigationMenu.chooseSalesSection();
        navigationMenu.chooseGiftVouchersMenu();
        navigationMenu.chooseGiftVouchers();

        // CHECK IF THE SPECIFIC GIFT VOUCHER ALREADY EXIST

        PageGiftVouchers.checkIfVoucherExistAndDelete("Stefana Kazandzhieva");

        // CREATE NEW VOUCHER

        PageGiftVouchers.createNewVoucher("Stefana Kazandzhieva", "s_vylkova@abv.bg", "Dimitar Kazandzhiev", "mitkokazandjiev@aol.com", "300");
        PageGiftVouchers.verifyNewVoucherCreateSuccessfully();
    }
}
