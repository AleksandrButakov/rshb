package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/testing.properties"
})

public interface RemoteDriverConfig extends Config {
    @Key("isRemote.driver")
    Boolean isRemoteDriver();

    @Key("remote.driver")
    String getRemoteDriver();

    @Key("remote.threads.driver")
    String getRemoteThreadsDriver();

}