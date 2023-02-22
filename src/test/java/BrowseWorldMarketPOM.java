import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowseWorldMarketPOM {
    public static WebElement getPopUpCloseIcon() {
        return BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
    }

    public static WebElement getFirstCategory() {
        return BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"home_topnav_layout_15_fillslot-3\"]/a"));
    }

    public static WebElement getFirstProduct() {
        return BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a"));
    }

    public static WebElement getFirstProductDetails() {
        return BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div"));
    }
}
