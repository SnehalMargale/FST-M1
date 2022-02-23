package appiumProject;

import io.appium.java_client.MobileBy;
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
import java.util.List;

public class googleTasks {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumClass");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void GoggleTasks() throws InterruptedException {

        driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(300);
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        Thread.sleep(300);
        String ActivityName = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        Assert.assertEquals(ActivityName,"Complete Activity with Google Tasks");

        driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(300);
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        Thread.sleep(300);
        ActivityName = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        Assert.assertEquals(ActivityName,"Complete Activity with Google Keep");

        driver.findElementByAccessibilityId("Create new task").click();
        Thread.sleep(300);
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the Second Activity with Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        Thread.sleep(300);
        ActivityName = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
        Assert.assertEquals(ActivityName,"Complete the Second Activity with Google Keep");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
