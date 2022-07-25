package org.quantic.themeManagment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import org.quantic.Quantic;
import org.quantic.utils.RenderUtils;

import java.awt.*;

public class GuiThemeList extends GuiSlot {

    public GuiThemeList(Minecraft mcIn, int width, int height, int topIn, int bottomIn, int slotHeightIn) {
        super(mcIn, width, height, topIn, bottomIn, slotHeightIn);
    }

    @Override
    protected int getSize() {
        return Quantic.getQuantic().getThemeManager().getThemes().size();
    }

    @Override
    protected void elementClicked(int slotIndex, boolean isDoubleClick, int mouseX, int mouseY) {
        ThemeManager themeManager = Quantic.getQuantic().getThemeManager();
        themeManager.getCurrentTheme().isCurrent = false;
        themeManager.getThemes().get(slotIndex).isCurrent = true;
        themeManager.setCurrentTheme(themeManager.getThemes().get(slotIndex));
    }

    @Override
    protected boolean isSelected(int slotIndex) {
        return false;
    }

    @Override
    protected void drawBackground() {

    }

    @Override
    protected void drawSlot(int entryID, int i1, int i2, int i3, int mouseXIn, int mouseYIn) {
        ThemeManager themeManager = Quantic.getQuantic().getThemeManager();
        //System.out.println(themeManager.getThemes().get(entryID).getThemeName());
        int c = themeManager.getThemes().get(entryID).isCurrent ? new Color(20, 200, 20).getRGB() : new Color(33, 33, 33).getRGB();
        RenderUtils.drawCenteredString(themeManager.getThemes().get(entryID).getThemeName(), width / 2, i2, c);
    }
}
