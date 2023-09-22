package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/testing.properties"
})

public interface BrowserLocalConfig extends Config {
    @Key("browser.local.type")
    String getBrowserLocalType();

    @Key("browser.local.version")
    String getBrowserLocalVersion();

    @Key("browser.local.size")
    String getBrowserLocalSize();

}