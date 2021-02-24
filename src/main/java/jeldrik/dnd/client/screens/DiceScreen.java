package jeldrik.dnd.client.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import jeldrik.dnd.DnD;
import jeldrik.dnd.client.event.ModClientEvents;
import net.minecraft.client.gui.advancements.AdvancementTabGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DiceScreen extends Screen {

	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(DnD.MOD_ID,
			"textures/guis/dice_screen.png");
	private static final ITextComponent GUI_LABEL = new TranslationTextComponent("jeldriks_dnd_mod.dice_screen");

	public DiceScreen() {
		super(GUI_LABEL);
	}

	public void render(MatrixStack matrixStack, int mouseX, int mouseY, final float partialTicks) {
		int i = (this.width - 176) / 2;
		int j = (this.height - 82) / 2;
		this.renderBackground(matrixStack);
		this.renderWindow(matrixStack, i, j);
	}

	public void renderWindow(MatrixStack matrixStack, int offsetX, int offsetY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.enableBlend();
		this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		this.blit(matrixStack, offsetX, offsetY, 0, 0, 176, 82);
		this.font.func_243248_b(matrixStack, GUI_LABEL, (float) (offsetX + 8), (float) (offsetY + 6), 4210752);
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		if (ModClientEvents.openDiceScreen.matchesKey(keyCode, scanCode)) {
			this.minecraft.displayGuiScreen((Screen) null);
			this.minecraft.mouseHelper.grabMouse();
			return true;
		} else {
			return super.keyPressed(keyCode, scanCode, modifiers);
		}
	}
	
	@Override
	public boolean isPauseScreen() {
		return false;
	}
}