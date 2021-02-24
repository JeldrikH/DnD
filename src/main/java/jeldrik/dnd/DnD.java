package jeldrik.dnd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jeldrik.dnd.core.init.BlockInit;
import jeldrik.dnd.core.init.ItemInit;
import jeldrik.dnd.core.init.ModTileEntityTypes;
import jeldrik.dnd.world.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DnD.MOD_ID)
public class DnD {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "jeldriks_dnd_mod";
	public static final String NAME = "dnd";
	public static final String VERSION = "1.0";
	public static final ItemGroup DND_GROUP = new DnDGroup(NAME);
	
	public DnD() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); //Variable für bus um Elemente zu registrieren
		bus.addListener(this::setup);
		
		ItemInit.ITEMS.register(bus); //registriert Itemregister
		BlockInit.BLOCKS.register(bus); //registriert Blockregister
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
	}

	
	private void setup(final FMLCommonSetupEvent event) {
		
	}
	
	public static class DnDGroup extends ItemGroup {
		public DnDGroup(String label) {
			super(label);
		}
		
		@Override
		public ItemStack createIcon() {
			return ItemInit.D20.get().getDefaultInstance();
		}
		
	}
	
}
