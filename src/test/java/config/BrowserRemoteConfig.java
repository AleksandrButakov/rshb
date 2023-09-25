package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/testing.properties"
})

public interface BrowserRemoteConfig extends Config {
    @Key("browser.remote.type")
    String getBrowserRemoteType();

    @Key("browser.remote.version")
    String getBrowserRemoteVersion();

    @Key("browser.remote.size")
    String getBrowserRemoteSize();

}