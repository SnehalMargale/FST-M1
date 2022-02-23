package appiumProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class googleChrome {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumClass");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void googleChromeToDoList() throws InterruptedException {

        Thread.sleep(700);

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(6).scrollIntoView(new UiSelector().text(\"To-Do List \uF0AE Elements get added at run time\"))")).click();
        System.out.println("Clicked");
        Thread.sleep(2500);

        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button").click();
        Thread.sleep(200);
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button").click();
        Thread.sleep(200);
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.Button").click();
        Thread.sleep(200);

        System.out.println("Before Strike out");
        MobileElement elementTask = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));  //.childSelector(new UiSelector().className(\"android.view.View\"))"));
        List<MobileElement> tasks=elementTask.findElements(MobileBy.AndroidUIAutomator("childSelector(new UiSelector().className(\"android.view.View\"))"));// findElementsByClassName("//android.view.View");
        //List<MobileElement> tasks= driver.findElements(MobileBy.AndroidUIAutomator("elementTask.childSelector(new UiSelector().className(\"android.view.View\"))"));
        System.out.println("Before Strike out Size: "+(tasks.size()-1));

        Assert.assertEquals(tasks.size()-1,3);
        for(int i=1;i<=3;i++){
            tasks.get(i).click();
          }

        System.out.println("After Strike out");
        elementTask = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));  //.childSelector(new UiSelector().className(\"android.view.View\"))"));
        tasks=elementTask.findElements(MobileBy.AndroidUIAutomator("childSelector(new UiSelector().className(\"android.view.View\"))"));// findElementsByClassName("//android.view.View");
        System.out.println("After Strike out Size: "+(tasks.size()-1));
        Assert.assertEquals(tasks.size()-1,3);

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]").click();
        wait.until(ExpectedConditions.invisibilityOf(elementTask));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(elementTask)),"All Tasks are Deleted");
    }

    @Test
    public void googleChromeLoginFormPos() throws InterruptedException {

        Thread.sleep(2000);
        MobileElement txtSelenium = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]");
        String txt = txtSelenium.getText();
        System.out.println("txtSelenium: "+ txt);
        wait.until(ExpectedConditions.visibilityOf(txtSelenium));

        System.out.println("Clicking");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(7).scrollIntoView(new UiSelector().text(\"Login Form \uF21B Please sign in.\"))")).click();

        /*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".flingForward().scrollTextIntoView(\"Login Form \uF21B Please sign in.\")")).click();*/

        /*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(3).getChildByText((new UiSelector().text(\"Login Form \uF21B Please sign in.\")),\"Login Form \uF21B Please sign in.\")")).click();*/

        System.out.println("Clicked");
        Thread.sleep(2500);

        driver.findElementById("username").sendKeys("admin");
        driver.findElementById("password").sendKeys("password");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button").click();

        Thread.sleep(700);
        String msg=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
        Assert.assertEquals(msg,"Welcome Back, admin");
    }

    @Test
    public void googleChromeLoginFormNeg() throws InterruptedException {

        Thread.sleep(700);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(6).scrollIntoView(new UiSelector().text(\"Login Form \uF21B Please sign in.\"))")).click();
        System.out.println("Clicked");
        Thread.sleep(2500);

        driver.findElementById("username").sendKeys("admin1");
        driver.findElementById("password").sendKeys("password1");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button").click();

        Thread.sleep(700);
        String msg=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
        Assert.assertEquals(msg,"Invalid Credentials");
    }

    @Test
    public void googleChromePopUpsPos() throws InterruptedException {

        Thread.sleep(700);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(4).scrollTextIntoView(\"Popups \uF35D Tooltips and Modals\")")).click();
        System.out.println("Clicked");
        Thread.sleep(2500);
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
        System.out.println("Clicked");
        Thread.sleep(700);

        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

        Thread.sleep(700);
        String msg=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
        Assert.assertEquals(msg,"Welcome Back, admin");
    }

    @Test
    public void googleChromePopUpsNeg() throws InterruptedException {

        Thread.sleep(700);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollForward(4).scrollTextIntoView(\"Popups \uF35D Tooltips and Modals\")")).click();
        System.out.println("Clicked");
        Thread.sleep(2500);
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();;

        Thread.sleep(700);
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin1");
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.widget.Button").click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();;
        Thread.sleep(700);

        String msg=driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
        Assert.assertEquals(msg,"Invalid Credentials");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
