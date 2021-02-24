package jeldrik.dnd.client.event;



import jeldrik.dnd.DnD;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

//greift FML Events auf, z.B. ModSetup vor Start (Alle Events die den Forge Bus benutzen (minecraftforge))
@EventBusSubscriber(modid = DnD.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
	
public final static KeyBinding openDiceScreen = new KeyBinding("key.open_dice_screen", 75, "key.categories.movement");
	@SubscribeEvent
	public static void keyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(openDiceScreen);
	}

}
