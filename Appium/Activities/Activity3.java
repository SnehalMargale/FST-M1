package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 29");//Pixel 4 API 29 //AppiumClass
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void calculator() throws InterruptedException {
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.google.android.calculator:id/digit_9").click();

        driver.findElementById("com.google.android.calculator:id/eq").click();

        String result = driver.findElement(MobileBy.id("result_final")).getText();
        System.out.println("Result: " +result);

        Assert.assertEquals(result, "14");

        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[21]").click();
        driver.findElementByAccessibilityId("minus").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();

        driver.findElementById("com.google.android.calculator:id/eq").click();

        result = driver.findElement(MobileBy.id("result_final")).getText();
        System.out.println("Result: " +result);

        Assert.assertEquals(result, "5");

        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[21]").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[21]").click();

        driver.findElementById("com.google.android.calculator:id/eq").click();

        result = driver.findElement(MobileBy.id("result_final")).getText();
        System.out.println("Result: " +result);

        Assert.assertEquals(result, "500");

        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[21]").click();
        driver.findElementByAccessibilityId("divide").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();

        driver.findElementById("com.google.android.calculator:id/eq").click();

        result = driver.findElement(MobileBy.id("result_final")).getText();
        System.out.println("Result: " +result);

        Assert.assertEquals(result, "25");

    }

    @AfterClass
    public void tearDown() {
         driver.quit();
    }
}
