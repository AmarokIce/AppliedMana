package club.someoneice.mana_ae;

import club.someoneice.pineapplepsychic.api.IPineappleConfig;
import club.someoneice.pineapplepsychic.config.ConfigBeanV2;

public class Config extends ConfigBeanV2 implements IPineappleConfig {
    public static int ae_power = 200;
    public static int mana_count = 100;

    public Config() {
        super("mana_ae_config");
        this.init();
    }

    @Override
    public void init() {
        ae_power    = this.getInteger("ae_power", ae_power);
        mana_count  = this.getInteger("ae_power", mana_count);
        this.build();
    }
}
