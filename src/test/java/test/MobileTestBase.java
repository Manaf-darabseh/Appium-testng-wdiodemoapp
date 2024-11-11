package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import lombok.SneakyThrows;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.PageFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Properties;

public class MobileTestBase {
    protected static String projectName = "wdiodemoApp";
    protected static AppiumDriver driver;
    protected static String platform;
    protected PageFactory page;

    @SneakyThrows
    @BeforeClass
    public void setup() {
        System.getProperties().load(new FileReader("src/test/resources/"+projectName+".mobile/"+projectName+".mobile.properties"));
        platform = System.getProperty("platform");
        prepareDriver();
       page = new PageFactory((AndroidDriver) driver);
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
            stopAppiumServer();
        }
    }

    protected Properties getProperties(String name) throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(name)) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find properties file name: " + name);
                return null;
            }
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    private static AppiumDriverLocalService service;
    public static void startAppiumServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1") .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .build();
        service.start();
    }
    public static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
    @SneakyThrows
    private static void prepareDriver()  {

        URL remoteUrl = new URL("http://127.0.0.1:4723");
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:deviceName", "Pixel 6 Pro API VanillaIceCream");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:app", System.getProperty("user.dir")+"/App/android.wdio.native.app.v1.0.8.apk");
            caps.setCapability("appium:appPackage", System.getProperty("appPackage"));
            caps.setCapability("appium:appActivity", System.getProperty("appActivity"));
            caps.setCapability("appium:fullReset", true);
            caps.setCapability("mobile: swipe", true); // Enable swipe capability


//            driver = new AndroidDriver(remoteUrl, caps);
            startAppiumServer();
            // Initialize the Appium driver
//            driver = new AndroidDriver(remoteUrl, caps);
            driver = new AndroidDriver(remoteUrl, caps);

        }

            if (platform.equalsIgnoreCase("iOS")) {

        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:udid", "00008101-000C4C320E91001E");
        caps.setCapability("appium:deviceName", "");
        caps.setCapability("appium:bundleId", "");

    }
}
    }
