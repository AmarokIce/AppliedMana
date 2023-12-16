package club.someoneice.mana_ae;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AEPowerBlock extends BlockContainer {
    protected AEPowerBlock() {
        super(Material.rock);
        this.blockHardness = 0.6F;
        this.setBlockName("ae_power_block");
        this.setBlockTextureName(ManaMain.MODID + ":ae_power_block");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new AEPowerTile();
    }
}
