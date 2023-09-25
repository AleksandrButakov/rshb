package config;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources({
        "classpath:config/testing.properties"
})

public interface WebDriverConfig extends Config {
    @Key("webdriver.baseUrl")
    String getWebDriverBaseUrl();

}