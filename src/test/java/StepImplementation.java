import com.kebab.DriverSetup;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import mapping.Mapper2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;



public class StepImplementation extends DriverSetup {
    Mapper2 mapper2 = new Mapper2();

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
        wait.until(ExpectedConditions.elementToBeClickable(mapper2.getElementFromJSON(by)));
        driver.findElement(mapper2.getElementFromJSON(by)).click();
//        MobileElement element = driver.findElement(mapper.getElementFromJson(by));
//        element.click();
//        wait.until(ExpectedConditions.elementToBeClickable(mapper.getElementFromJson(by))).click();
    }

    @Step("<by> popupı ekranda görülürse kapatılır")
    public void closePopupIfThereIs(String by){
        waitSeconds(1);
        if(driver.findElement(mapper2.getElementFromJSON(by)).isDisplayed()){
            driver.findElement(mapper2.getElementFromJSON(by)).click();
        }
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

    @Step("<byList> listesinden rastgele bir elemana tıklanır")
    public void clickRandomElementFromByList(String byList) {
        List<MobileElement> elements = driver.findElements(mapper2.getElementFromJSON(byList));
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() + 1);
        WebElement element = elements.get(randomNumber);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



}
