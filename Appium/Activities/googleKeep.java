package appiumProject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class googleKeep {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumClass");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void GoggleKeep() throws InterruptedException {
        driver.findElementByAccessibilityId("New text note").click();
        Thread.sleep(300);
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("NoteTitle1");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("NoteDesc1");
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        Thread.sleep(300);
        String NoteTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
        Assert.assertEquals(NoteTitle,"NoteTitle1");
        String NoteDesc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
        Assert.assertEquals(NoteDesc,"NoteDesc1");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
