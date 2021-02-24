package jeldrik.dnd.client.event;
import jeldrik.dnd.DnD;
import jeldrik.dnd.client.screens.DiceScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardKeyPressedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = DnD.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public void onKeyInput(final KeyboardKeyPressedEvent event) {
	}
}
