package committee.nova.mods.avaritia.compat;

import com.moandjiezana.toml.Toml;

import java.io.File;

public class NTPCompat {
    private static final File CONFIG_FILE = new File("config/no_tree_punching.toml");

    public static boolean isNTPBlockDropEnabled() {
        if (!CONFIG_FILE.exists()) return true; // default true if missing

        Toml config = new Toml().read(CONFIG_FILE);
        return config.getBoolean("common.doBlocksDropWithoutCorrectTool", true);
    }

    public static boolean isNTPToolBreakEnabled() {
        if (!CONFIG_FILE.exists()) return true;

        Toml config = new Toml().read(CONFIG_FILE);
        return config.getBoolean("common.doBlocksMineWithoutCorrectTool", true);
    }
}
