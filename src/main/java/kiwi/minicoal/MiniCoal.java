package kiwi.minicoal;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiniCoal implements ModInitializer {

    public static final String MOD_ID = "minicoal";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("MiniCoal initializing...");
        ModItems.initialize();
        LOGGER.info("MiniCoal initialized!");
    }
}
