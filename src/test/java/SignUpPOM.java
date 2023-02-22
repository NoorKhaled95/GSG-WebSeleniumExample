import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPOM {
    public static WebElement getSignUpPopUp() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]"));
    }

    public static WebElement getSignUpPopUpEmailField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"EMAIL_ADDRESS_\"]"));
    }

    public static WebElement getPopUpSignUpButton() {
        return SignUpTest.driver.findElement(By.cssSelector("[onclick=\"return validateForm();\"]"));
    }

    public static WebElement getPopUpSuccessImage() {
        return SignUpTest.driver.findElement(By.xpath(" //*[@id=\"formsg\"]/div[2]/h1/img[2]"));
    }

    public static WebElement getPopUpJoinNowButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"gotoCreate\"]"));
    }

    public static WebElement getJoinTabButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/main/div/div/div/div/div[2]/ul/li[2]/a"));
    }

    public static WebElement getFirstNameField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"create_firstName\"]"));
    }

    public static WebElement getLastNameField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"create_lastName\"]"));
    }

    public static WebElement getPasswordField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"userPasswordCreate\"]"));
    }

    public static WebElement getIdField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"memberIdInputCreateAccount\"]"));
    }

    public static WebElement getZipCodeField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"postalCodeCreate\"]"));
    }

    public static WebElement getAcceptCheckBox() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"label_create_tc\"]/span"));
    }

    public static WebElement getCreateAccountButton() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"createAccountButton\"]"));
    }

    public static WebElement getSearchField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
    }
}
