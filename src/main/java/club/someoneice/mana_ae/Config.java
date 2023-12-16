package club.someoneice.mana_ae;

import club.someoneice.pineapplepsychic.config.ConfigBeanJson;

public class Config {
    public static int ae_power = 200;
    public static int mana_count = 100;

    public void init() {
        ConfigBeanJson config = new ConfigBeanJson("mana_ae_config", null);
        ae_power = config.getInteger("ae_power", ae_power);
        mana_count = config.getInteger("ae_power", mana_count);
        config.build();
    }
}
