package shadowedleaves.disablewoodstrip;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisableWoodStripping implements ModInitializer {
	public static final String MOD_ID = "disablewoodstrip";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Disable Wood Stripping Mod!");
	}
}