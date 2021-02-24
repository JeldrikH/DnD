package jeldrik.dnd.core.init;

import jeldrik.dnd.DnD;
import jeldrik.dnd.common.blocks.D20;
import jeldrik.dnd.common.blocks.Quarry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DnD.MOD_ID); // Initialisiert
																														// Blockregister

	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
			() -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
					.hardnessAndResistance(15f, 30f).harvestTool(ToolType.HOE).harvestLevel(2).sound(SoundType.SLIME))); // Erstellt
																															// Block
																															// in
																															// Blockregister

	public static final RegistryObject<D20> D20 = BLOCKS.register("d20",
			() -> new D20(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE)
					.harvestLevel(1).sound(SoundType.WOOD).setRequiresTool().hardnessAndResistance(15f, 30f)));
	
	public static final RegistryObject<Block> WATER_ORE = BLOCKS.register("water_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE)
					.harvestLevel(2).sound(SoundType.STONE).setRequiresTool().hardnessAndResistance(15f, 30f)));
	
	public static final RegistryObject<Block> FIRE_ORE = BLOCKS.register("fire_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestTool(ToolType.PICKAXE)
					.harvestLevel(5).sound(SoundType.STONE).setRequiresTool().hardnessAndResistance(15f, 30f)));
	
	public static final RegistryObject<Quarry> QUARRY = BLOCKS.register("quarry", () -> new Quarry(AbstractBlock.Properties.create(Material.IRON)));
}
