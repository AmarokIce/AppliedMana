package club.someoneice.mana_ae;

import appeng.core.Api;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import project.studio.manametalmod.ManaMetalMod;

@Mod(modid = ManaMain.MODID, dependencies = "required-after:manametalmod;required-after:appliedenergistics2;after:Waila")
public class ManaMain {
    public static final String MODID = "mana_ae";
    public static final Block aepower = new AEPowerBlock();

    @Mod.EventHandler
    public void perInit(FMLPreInitializationEvent event) {
        new Config().init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerTileEntity(AEPowerTile.class, "ae_power_tile");
        GameRegistry.registerBlock(aepower, "ae_power_block");
        GameRegistry.addRecipe(new ItemStack(aepower), "ICI", "DGD", "ICI", 'I', ManaMetalMod.ingotManaS, 'D', Items.diamond, 'G', ManaMetalMod.BLOCKManaEnergyGenerator1, 'C', new ItemStack(Api.INSTANCE.materials().materialFluixCrystal.item(), 1, 12));
    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event) {
        if (Loader.isModLoaded("Waila")) FMLInterModComms.sendMessage("Waila", "register", "club.someoneice.LMSYSG.WailaPlayerPlugin.callbackRegister");
    }
}
