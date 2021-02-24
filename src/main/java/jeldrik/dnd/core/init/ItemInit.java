package jeldrik.dnd.core.init;

import jeldrik.dnd.DnD;
import jeldrik.dnd.common.items.SpecialItem;
import jeldrik.dnd.common.items.Dice;
import jeldrik.dnd.core.enums.ArmorMaterials;
import jeldrik.dnd.core.enums.ToolMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	// Items

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DnD.MOD_ID); // Register
																													// für
																													// Itemplätze

	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
			() -> new Item(new Item.Properties().group(DnD.DND_GROUP)));

	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
			() -> new SpecialItem(new Item.Properties().group(DnD.DND_GROUP))); // Item mit Spezialeffekten

	public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
			() -> new Item(new Item.Properties().group(DnD.DND_GROUP)
					.food(new Food.Builder().effect(() -> new EffectInstance(Effects.CONDUIT_POWER, 2000, 10), 1.0f)
							.fastToEat().hunger(20).saturation(20.0f).setAlwaysEdible().meat().build()))); // Beispiel
																											// Essen
																											// (op)
	public static final RegistryObject<Item> WATER_INGOT = ITEMS.register("water_ingot",
			() -> new Item(new Item.Properties().group(DnD.DND_GROUP))); // Wasserbarren

	public static final RegistryObject<Item> FIRE_INGOT = ITEMS.register("fire_ingot",
			() -> new Item(new Item.Properties().group(DnD.DND_GROUP))); // Feuerbarren
	
	public static final RegistryObject<Dice> DICE = ITEMS.register("dice",
			() -> new Dice(new Item.Properties().group(DnD.DND_GROUP)));

	// Tools

	public static final RegistryObject<PickaxeItem> WATER_PICKAXE = ITEMS.register("water_pickaxe",
			() -> new PickaxeItem(ToolMaterials.WATER, -1, 0,
					(new Item.Properties()).group(ItemGroup.TOOLS).group(DnD.DND_GROUP))); // Wasserpickaxe

	public static final RegistryObject<SwordItem> FIRE_SWORD = ITEMS.register("fire_sword",
			() -> new SwordItem(ToolMaterials.FIRE, 15, -2.0f,
					(new Item.Properties()).group(ItemGroup.COMBAT).group(DnD.DND_GROUP))); // Feuerpickaxe

	// Armor

	public static final RegistryObject<ArmorItem> WATER_HELMET = ITEMS.register("water_helmet",
			() -> new ArmorItem(ArmorMaterials.WATER, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ItemGroup.COMBAT).group(DnD.DND_GROUP))); // Wasserhelm

	public static final RegistryObject<ArmorItem> WATER_CHESTPLATE = ITEMS.register("water_chestplate",
			() -> new ArmorItem(ArmorMaterials.WATER, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ItemGroup.COMBAT).group(DnD.DND_GROUP))); // Wasserbrustplatte

	public static final RegistryObject<ArmorItem> WATER_LEGGINGS = ITEMS.register("water_leggings",
			() -> new ArmorItem(ArmorMaterials.WATER, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ItemGroup.COMBAT).group(DnD.DND_GROUP))); // Wasserhose

	public static final RegistryObject<ArmorItem> WATER_BOOTS = ITEMS.register("water_boots",
			() -> new ArmorItem(ArmorMaterials.WATER, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ItemGroup.COMBAT).group(DnD.DND_GROUP))); // Wasserstiefel

	// Block Items

	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK = ITEMS.register("example_block",
			() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().group(DnD.DND_GROUP))); // Erzeugt
																												// Beispiel-Blockitem

	public static final RegistryObject<BlockItem> D20 = ITEMS.register("d20",
			() -> new BlockItem(BlockInit.D20.get(), new Item.Properties().group(DnD.DND_GROUP))); // ist eigentlich ein
																									// d6

	public static final RegistryObject<BlockItem> WATER_ORE = ITEMS.register("water_ore",
			() -> new BlockItem(BlockInit.WATER_ORE.get(), new Item.Properties().group(DnD.DND_GROUP))); // Erzeugt
																											// Wassererz

	public static final RegistryObject<BlockItem> FIRE_ORE = ITEMS.register("fire_ore",
			() -> new BlockItem(BlockInit.FIRE_ORE.get(), new Item.Properties().group(DnD.DND_GROUP))); // Erzeugt
																										// Feuererz

	public static final RegistryObject<BlockItem> QUARRY = ITEMS.register("quarry",
			() -> new BlockItem(BlockInit.QUARRY.get(), new Item.Properties().group(DnD.DND_GROUP))); // Erzeugt
																										// Quarry

}
