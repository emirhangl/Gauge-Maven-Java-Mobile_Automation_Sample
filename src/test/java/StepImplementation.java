import com.kebab.DriverSetup;

import com.thoughtworks.gauge.Step;
import mapping.Mapper2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class StepImplementation extends DriverSetup {
    Mapper2 mapper2 = new Mapper2();
    WebDriverWait wait = new WebDriverWait(driver, 60);


    @Step("<Saniye> Saniyesi kadar bekle")
    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<by> butonuna tıklanır")
    public void clickElement(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).click();
    }

    @Step("<by> alanına <text> yazılır")
    public void sendKeys(String by, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).sendKeys(text);
    }

    @Step("<by> alanı silinir")
    public void deleteTextbox(String by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).clear();
    }

    @Step("<by> elementinin görülmesi beklenir")
    public void waitForTheElement(String by) {
        Assert.assertTrue(by + " elemanı sayfada görülemedi!",
                wait.until(ExpectedConditions.presenceOfElementLocated(mapper2.getElementFromJSON(by))).isDisplayed());
    }

    @Step("Herhangi bir pop up varsa kapatılır")
    public void closeThePopUps() {
        if (driver.switchTo().alert() != null) {
            driver.switchTo().alert().dismiss();
        }
    }

    @Step("Klavyeden TAB tuşuna basılır")
    public void pressTAB() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
    }

    @Step("Klavyeden ENTER tuşuna basılır")
    public void pressENTER() {
        driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
    }



}
