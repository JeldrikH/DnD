package jeldrik.dnd.core.event;

import jeldrik.dnd.DnD;
import jeldrik.dnd.core.init.ItemInit;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = DnD.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

	@SubscribeEvent
	public static void onBlockBreak(final BlockEvent.BreakEvent event) {
		if (event.getState().getBlock() instanceof AnvilBlock) {
//			for (int x = -5; x < 5; x++) {
//				for (int y = -5; y < 5; y++) {
//					for (int z = -5; z < 5; z++) {
//						event.getWorld().setBlockState(event.getPos().add(1, 1, 1),
//								BlockInit.FIRE_ORE.get().getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
//					}
//				}
//			}
			event.setCanceled(true);
		}

	}

	@SubscribeEvent
	public static void onBlockPlace(final EntityPlaceEvent event) {
//		lol(event);
	}

	@SubscribeEvent
	public static void buttonPress(final RightClickBlock event) {

	}

	@SubscribeEvent
	public static void onPlayerCritMob(final CriticalHitEvent event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem().equals(ItemInit.WATER_PICKAXE.get())) {
			if (event.isVanillaCritical()) {

				event.getTarget().setInvisible(true);
			} else {
				event.setResult(Result.ALLOW);
			}
		}

	}

//	private static void lol(EntityPlaceEvent event) {
//		event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
//		BlockPos pos = event.getPos();
//		boolean lol = true;
//		lolLoop(lol, pos, event);
//	}
//	private static void lolLoop(boolean lol, BlockPos pos, EntityPlaceEvent event) {
//		if(lol) {
//			int x = (int) (Math.random() * 3);
//			int y = (int) (Math.random() * 3);
//			int z = (int) (Math.random() * 3);
//			pos = pos.add(x, y, z);
//			event.getWorld().setBlockState(pos, Blocks.BLACK_WOOL.getDefaultState(), Constants.BlockFlags.BLOCK_UPDATE);
//			if (x + y + z >= 6) {
//			}
//			else {
//				wait(lol, pos, event);
//			}
//			
//		}
//	}
//	
//	private static void wait(boolean lol, BlockPos pos, EntityPlaceEvent event) {
//		lolLoop(lol, pos, event);
//	}
}