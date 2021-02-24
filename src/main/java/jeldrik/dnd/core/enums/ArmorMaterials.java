package jeldrik.dnd.core.enums;

import jeldrik.dnd.DnD;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import jeldrik.dnd.core.init.ItemInit;

public enum ArmorMaterials implements IArmorMaterial {
	WATER(new int[] {8, 10, 9, 7}, 200, 15, 1.0f, 3.0f, "water", ItemInit.WATER_INGOT, "entity.generic.splash");

	private int[] max_damage_array = new int[] { 12, 15, 16, 11 };
	private int[] damageReductionAmount;
	private int durability, enchantability;
	private float knockbackResistance, toughness;
	private String name, soundEvent;
	private RegistryObject<Item> repairMaterial;

	private ArmorMaterials(int[] damageReductionAmount, int durability, int enchantability, float knockbackResistance,
			float toughness, String name, RegistryObject<Item> repairMaterial, String soundEvent) {
		this.damageReductionAmount = damageReductionAmount;
		this.durability = durability;
		this.enchantability = enchantability;
		this.knockbackResistance = knockbackResistance;
		this.toughness = toughness;
		this.name = name;
		this.repairMaterial = repairMaterial;
		this.soundEvent = soundEvent;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		return this.damageReductionAmount[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) {
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public String getName() {
		return DnD.MOD_ID + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial.get());
	}

	@Override
	public SoundEvent getSoundEvent() {
		return new SoundEvent(new ResourceLocation(soundEvent));
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

}
