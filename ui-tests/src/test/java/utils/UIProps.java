package utils;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config.properties"
})
public interface UIProps extends Config {

    @Key("BASE_URL")
    String baseUrl();
}
