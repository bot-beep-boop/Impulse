package impulse.ui.settings.buttons;

import java.awt.Color;
import java.util.ArrayList;

import com.sun.swing.internal.plaf.metal.resources.metal;

import impulse.cosmetics.textureManager;
import impulse.discord.Discordrpc;
import impulse.hud.mod.HudMod;
import impulse.hud.mod.tag.ParseTags;
import impulse.ui.clickgui.ClickGUI;
import impulse.ui.clickgui.ClickGUICosmetic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class BackButton {
		
	public int x, y, w, h;
	public HudMod m;
	
	public BackButton(int x, int y, int w, int h, HudMod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
		
	}
	
	public void draw() {
		//back_arrow.png
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(textureManager.INSTANCE.clientName + "/" + textureManager.INSTANCE.backArrow));
		GlStateManager.pushMatrix();
		GlStateManager.color(255, 255, 255);
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, h + 4, h, 15F, h);
		GlStateManager.popMatrix();

	}
	
	private int getColor() {
		return this.m.getColor();
	}
	
	public void onClick(int mouseX, int mouseY, int button) {
		if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			
			if (ParseTags.parse(this.m).get("Cos") == "true") {
				Minecraft.getMinecraft().displayGuiScreen(new ClickGUICosmetic());
			} else {
				Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
			}
			
		}

	}

}
