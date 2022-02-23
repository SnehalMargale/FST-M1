package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumClass");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sendMsg() throws InterruptedException {

        Thread.sleep(500);
        driver.findElementByAccessibilityId("Start chat").click();

        Thread.sleep(500);
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("1234512345");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(800);
        driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("hello from Appium");
        driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.messaging:id/message_content")));

        Thread.sleep(500);
        String msg = driver.findElementById("com.google.android.apps.messaging:id/message_text").getText();
        System.out.println("Msg: "+msg);
        Assert.assertEquals(msg, "hello from Appium");

    }

    @AfterClass
    public void tearDown() {
         driver.quit();
    }
}
