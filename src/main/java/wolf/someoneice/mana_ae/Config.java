package wolf.someoneice.mana_ae;

import club.someoneice.pineapplepsychic.config.ConfigBean;
import club.someoneice.pineapplepsychic.config.IPineappleConfig;

public class Config implements IPineappleConfig {
    public static int ae_power = 200;
    public static int mana_count = 100;

    @Override
    public void init() {
        ConfigBean config = new ConfigBean("mana_ae_config", this);
        ae_power = config.getInt("ae_power", ae_power);
        mana_count = config.getInt("ae_power", mana_count);
        config.build();
    }
}
