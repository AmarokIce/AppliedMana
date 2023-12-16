package club.someoneice.mana_ae;

import appeng.api.config.Actionable;
import appeng.tile.networking.TileEnergyCell;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import project.studio.manametalmod.magicenergy.IMagicEnergyUse;
import project.studio.manametalmod.magicenergy.MagicEnergy;

public class AEPowerTile extends TileEntity implements IMagicEnergyUse {
    public MagicEnergy energy;
    public final int maxMana = 50000;

    public AEPowerTile() {
        energy = new MagicEnergy(0);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        this.energy.readFromNBT(nbt);
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        this.energy.writeToNBT(nbt);
        super.writeToNBT(nbt);
    }

    @Override
    public void updateEntity() {
        if (this.energy.Energy < Config.mana_count) return;
        TileEntity tile1 = this.worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord);
        TileEntity tile2 = this.worldObj.getTileEntity(this.xCoord, this.yCoord - 1, this.zCoord);
        if (tile1 instanceof TileEnergyCell) {
            TileEnergyCell tile = (TileEnergyCell) tile1;
            if (tile.getAECurrentPower() < tile.getAEMaxPower()) {
                tile.injectAEPower(Config.ae_power, Actionable.MODULATE);
                energy.removeEnergy(Config.mana_count);
            }
        }

        if (tile2 instanceof TileEnergyCell) {
            TileEnergyCell tile = (TileEnergyCell) tile2;
            if (tile.getAECurrentPower() < tile.getAEMaxPower()) {
                tile.injectAEPower(Config.ae_power, Actionable.MODULATE);
                energy.removeEnergy(Config.mana_count);
            }
        }
    }

    @Override
    public boolean needEnergy() {
        return energy.Energy < maxMana;
    }

    @Override
    public void onImportEnergy() {}

    @Override
    public void addEnergy(MagicEnergy magicEnergy) {
        this.energy.addEnergy(magicEnergy.Energy);
    }

    @Override
    public int getMaxEnergy() {
        return this.maxMana;
    }

    @Override
    public MagicEnergy getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canImport() {
        return this.needEnergy();
    }
}
