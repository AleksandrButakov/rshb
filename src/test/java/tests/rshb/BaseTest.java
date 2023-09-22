package tests.rshb;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserLocalConfig;
import config.BrowserRemoteConfig;
import config.RemoteDriverConfig;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sessionId;

import static helpers.AllureAttachments.*;
import static java.lang.System.*;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        BrowserLocalConfig browserLocalConfig = ConfigFactory.create(BrowserLocalConfig.class, getProperties());
        BrowserRemoteConfig browserRemoteConfig = ConfigFactory.create(BrowserRemoteConfig.class, getProperties());
        RemoteDriverConfig remoteDriverConfig = ConfigFactory.create(RemoteDriverConfig.class, getProperties());
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, getProperties());

        baseUrl = webDriverConfig.getWebDriverBaseUrl();

        if (remoteDriverConfig.isRemoteDriver()) {
            // starting the remote driver
            browser = browserRemoteConfig.getBrowserRemoteType();
            browserVersion = browserRemoteConfig.getBrowserRemoteVersion();
            browserSize = browserRemoteConfig.getBrowserRemoteSize();
            System.setProperty("threads", remoteDriverConfig.getRemoteThreadsDriver());

            remote = remoteDriverConfig.getRemoteDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
                /* How to add test badge */
                put("name", "My tests https://smartdeal.pro");

                /* How to set session timeout */
                put("sessionTimeout", "15m");

                /* How to set timezone */
                put("env", new ArrayList<String>() {{
                    add("TZ=UTC");
                }});

                put("console", true);

                /* How to enableVNC */
                put("enableVNC", true);

                /* How to enable video recording */
                put("enableVideo", true);

            }});
            browserCapabilities = capabilities;

        } else {
            // starting the local driver
            browser = browserLocalConfig.getBrowserLocalType();
            browserVersion = browserLocalConfig.getBrowserLocalVersion();
            browserSize = browserLocalConfig.getBrowserLocalSize();
        }
    }

    @AfterEach
    public void afterEach() {
        RemoteDriverConfig remoteDriverConfig = ConfigFactory.create(RemoteDriverConfig.class, getProperties());
        if (remoteDriverConfig.isRemoteDriver()) {
            // starting the remote driver
            String sessionId = sessionId().toString(); //getSessionId();
            attachScreenshot("Last screenshot");
            attachPageSource();
            closeWebDriver();
            attachVideo(sessionId);
        } else {
            // starting the local driver
            closeWebDriver();
        }
    }

}