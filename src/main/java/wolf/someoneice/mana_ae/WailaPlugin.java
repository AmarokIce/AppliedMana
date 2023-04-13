package wolf.someoneice.mana_ae;

import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class WailaPlugin implements IWailaFMPProvider {
    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> list, IWailaFMPAccessor iWailaFMPAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> list, IWailaFMPAccessor iWailaFMPAccessor, IWailaConfigHandler iWailaConfigHandler) {
        return list;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> list, IWailaFMPAccessor accessor, IWailaConfigHandler iWailaConfigHandler) {
        if (accessor.getTileEntity() instanceof AEPowerTile) {
            AEPowerTile tile = (AEPowerTile) accessor.getTileEntity();
            list.add("魔法能剩余：" + tile.energy.Energy + "/" + tile.maxMana);
        }
        return list;
    }


    public static void callbackRegister(IWailaRegistrar registrar) {
        WailaPlugin plugin = new WailaPlugin();
        registrar.registerTailProvider((IWailaDataProvider) plugin, EntityPlayer.class);
    }
}
