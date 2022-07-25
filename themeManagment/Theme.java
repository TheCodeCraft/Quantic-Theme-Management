package org.quantic.themeManagment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;

@Getter
@RequiredArgsConstructor
public abstract class Theme {

    private final String themeName;

    public boolean isCurrent = false;

    public abstract void renderButton(String displayString, int x, int y, int width, int height, int mouseX, int mouseY, boolean hover, boolean enabled, boolean visible);

    public abstract void renderBackground(int screenWidth, int screenHeight, int mouseX, int mouseY);

    public abstract void init();
    public abstract void guiClosed();

    public Color getMainColor() {
        return new Color(0, 0, 0);
    }

}
