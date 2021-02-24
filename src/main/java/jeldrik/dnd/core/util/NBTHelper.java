package jeldrik.dnd.core.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import jeldrik.dnd.client.render.tileentity.QuarryTileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class NBTHelper {

	public static CompoundNBT toNBT(Object object) {
		if (object instanceof ItemStack) {
			return writeItemStack((ItemStack) object);
		}
		if (object instanceof QuarryTileEntity) {
			return writeQuarry((QuarryTileEntity) object);
		}
		return null;
	}

	private static CompoundNBT writeItemStack(ItemStack itemStack) {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("count", itemStack.getCount());
		nbt.putString("item", itemStack.getItem().getRegistryName().toString());
		nbt.putByte("type", (byte) 0);
		return nbt;

	}

	private static CompoundNBT writeQuarry(QuarryTileEntity object) {
		CompoundNBT compound = new CompoundNBT();
		compound.putInt("x", object.x);
		compound.putInt("y", object.y);
		compound.putInt("z", object.z);
		return compound;
	}
	
	@Nullable
	public static Object fromNBT(@Nonnull CompoundNBT compound) {
		switch(compound.getByte("type")) {
		case 0:
			return readItemStack(compound);
		default:
			return null;
		}
		
	}
	private static ItemStack readItemStack(CompoundNBT compound) {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("item")));
		int count = compound.getInt("count");
		return new ItemStack(item, count);
	}
}
