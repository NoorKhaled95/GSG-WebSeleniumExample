import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartAndCheckoutPOM {
    public static WebElement getFirstProduct() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/a"));
    }

    public static WebElement getFirstProductDetails() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div"));
    }

    public static WebElement getAddToCartButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"addToBasket120916\"]"));
    }

    public static WebElement getItemAddToCartText() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"sideCartRail\"]/div[2]/div[2]/div/span"));
    }

    public static WebElement getCheckoutButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"sideCartRail\"]/div[3]/div/div[4]/div/button"));
    }

    public static WebElement getCartItemsNumText() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input"));
    }

    public static WebElement getSecondCheckoutButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input"));
    }

    public static WebElement getFirstNameField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
    }
}
