package org.quantic.themeManagment.themes;

import net.minecraft.client.gui.Gui;
import org.quantic.themeManagment.Theme;
import org.quantic.utils.RenderUtils;

import java.awt.*;

public class DarkTheme extends Theme {

    public DarkTheme() {
        super("Dark");
    }

    private float cut;

    @Override
    public void renderButton(String displayString, int x, int y, int width, int height, int mouseX, int mouseY, boolean hover, boolean enabled, boolean visible) {
        if (!visible) return;

        final int delta = 40;

        if (enabled && hover) {
            cut += 0.05F * delta;

            if (cut >= 4) cut = 4;

        } else {
            cut -= 0.05F * delta;

            if (cut <= 0) cut = 0;
        }

        Gui.drawRect(x + (int) this.cut, y,
                x + width - (int) this.cut, y + height,
                enabled ? new Color(this.getMainColor().darker().darker().darker().getRGB()).getRGB() :
                        new Color(0.5F, 0.5F, 0.5F, 0.5F).getRGB());

        RenderUtils.drawCenteredString(displayString, x + width / 2, y + (height - 8) / 2, enabled ? Color.WHITE.getRGB() : Color.WHITE.darker().darker().getRGB());
    }

    @Override
    public void renderBackground(int screenWidth, int screenHeight, int mouseX, int mouseY) {
        RenderUtils.drawRect(0, 0, screenWidth, screenHeight, getMainColor());
    }

    @Override
    public void init() {

    }

    @Override
    public void guiClosed() {

    }

    @Override
    public Color getMainColor() {
        return new Color(33, 33, 33);
    }
}
