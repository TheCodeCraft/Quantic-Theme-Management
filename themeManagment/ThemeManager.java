package org.quantic.themeManagment;

import lombok.Getter;
import lombok.Setter;
import org.quantic.themeManagment.themes.DarkTheme;
import org.quantic.themeManagment.themes.LightTheme;
import org.quantic.themeManagment.themes.QuanticTheme;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ThemeManager {

    private final List<Theme> themes = new ArrayList<>();

    private Theme currentTheme;

    private final GuiThemeManager guiThemeManager = new GuiThemeManager();

    public ThemeManager() {
        loadThemes();
    }

    private void loadThemes() {
        this.setCurrentTheme(new QuanticTheme());
        this.currentTheme.isCurrent = true;
        this.themes.add(this.currentTheme);
        this.themes.add(new LightTheme());
        this.themes.add(new DarkTheme());
    }

    public Theme getTheme(String themeName) {
        return themes.stream().filter(theme -> theme.getThemeName().equalsIgnoreCase(themeName)).findFirst().orElse(null);
    }

}
