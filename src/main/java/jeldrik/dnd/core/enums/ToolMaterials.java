package jeldrik.dnd.core.enums;

import jeldrik.dnd.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;

public enum ToolMaterials implements IItemTier{
	WATER(2.0f, 5.0f, 15, 5, 521, ItemInit.WATER_INGOT),
	FIRE(5.0f, 12.0f, 25, 6, 5210, ItemInit.FIRE_INGOT);
	
	private float attackDamage, efficiency;
	private int enchantability, harvestLevel, maxUses;
	private RegistryObject<Item> repairMaterial;
	
	private ToolMaterials(float attackDamage, float efficiency, int enchantability, int harvestLevel, int maxUses,
			RegistryObject<Item> repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial.get());
	}
}
