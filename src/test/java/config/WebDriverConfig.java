package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/testing.properties"
})

public interface WebDriverConfig extends Config {
    @Key("webdriver.baseUrl")
    String getWebDriverBaseUrl();
}