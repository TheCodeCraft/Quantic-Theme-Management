package org.quantic.themeManagment.themes;

import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.quantic.themeManagment.Theme;
import org.quantic.utils.GLSLSandboxShader;
import org.quantic.utils.RenderUtils;
import org.quantic.utils.RoundedUtils;

import java.awt.*;
import java.io.IOException;

public class QuanticTheme extends Theme {

    public QuanticTheme() {
        super("Quantic");
    }

    @Override
    public void renderButton(String displayString, int x, int y, int width, int height, int mouseX, int mouseY, boolean hover, boolean enabled, boolean visible) {
        if (!visible) return;

        Color color = new Color(0, 20, 109, hover & enabled ? 100 : 50);

        if (!enabled) {
            color = new Color(0, 23, 109, 50);
        }

        RenderUtils.drawRect(x, y, x + width, y + height, color.getRGB());

        //TOP
        RenderUtils.drawLine(x, y, x + width, y, Color.WHITE, 1.5F);
        //BOTTOM
        RenderUtils.drawLine(x, y + height, x + width, y + height, Color.WHITE, 1.5F);
        //LEFT
        RenderUtils.drawLine(x, y, x, y + height, Color.WHITE, 1.5F);
        //RIGHT
        RenderUtils.drawLine(x + width, y, x + width, y + height, Color.WHITE, 1.5F);


        RenderUtils.drawCenteredString(displayString, x + width / 2, y + (height - 8) / 2, enabled ? Color.WHITE.getRGB() : Color.WHITE.darker().darker().getRGB());
    }

    private GLSLSandboxShader shader;
    private long bgShaderInitTime = System.currentTimeMillis();

    @Override
    public void renderBackground(int screenWidth, int screenHeight, int mouseX, int mouseY) {
        this.shader.useShader(screenWidth, screenHeight, mouseX, mouseY, (System.currentTimeMillis() - bgShaderInitTime) / 1000f);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(-1f, -1f);
        GL11.glVertex2f(-1f, 1f);
        GL11.glVertex2f(1f, 1f);
        GL11.glVertex2f(1f, -1f);
        GL11.glEnd();
        // Unbind shader
        GL20.glUseProgram(0);
    }

    @Override
    public void init() {
        bgShaderInitTime = System.currentTimeMillis();
        try {
            shader = new GLSLSandboxShader("/quanticShader.fsh");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guiClosed() {

    }
}
