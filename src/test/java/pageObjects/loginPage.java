package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;

    By tb_username = By.id("username");
    By tb_password = By.id("password");
    By btn_login = By.id("kc-login");
    By btn_logout = By.id("logout_button");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertUsername(String username) {
        driver.findElement(tb_username).sendKeys(username);
    }

    public void insertPassword(String password) {
        driver.findElement(tb_password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login).click();
    }

    public void clickLogout() {
        driver.findElement(btn_logout).click();
    }

}
