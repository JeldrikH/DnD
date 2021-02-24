package jeldrik.dnd.common.items;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import jeldrik.dnd.client.screens.DiceScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Dice extends Item{

	public Dice(Properties properties) {
			super(properties);
		}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
			tooltip.add(new TranslationTextComponent("tooltip.special_item.advanced_tooltip"));
		} else {
			tooltip.add(new TranslationTextComponent("tooltip.special_item.hold_shift"));
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!playerIn.getCooldownTracker().hasCooldown(this)) {
			Minecraft.getInstance().displayGuiScreen(new DiceScreen());
			return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
		}
		return ActionResult.resultFail(playerIn.getHeldItem(handIn));
	}
}
