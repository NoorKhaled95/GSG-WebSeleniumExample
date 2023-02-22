import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPOM {

    public static WebElement getEmailField() {
        return SignInTest.driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
    }

    public static WebElement getPasswordField() {
        return SignInTest.driver.findElement(By.xpath("//*[@id=\"loginPassword\"]"));
    }

    public static WebElement getSignInButton() {
        return SignInTest.driver.findElement(By.xpath("//*[@id=\"checkoutLoginButton\"]"));
    }

    public static WebElement getSearchField() {
        return SignInTest.driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
    }
}
