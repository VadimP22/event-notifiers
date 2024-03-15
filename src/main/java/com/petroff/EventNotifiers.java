package com.petroff;

import com.petroff.commands.ReloadCommand;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventNotifiers implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("event-notifiers");
	public static boolean enabled = true;

	@Override
	public void onInitialize() {
		Config.load();
		LOGGER.info("EventNotifiers initialization finished!");
	}

	public static void enable() {}
	public static void disable() {}

	public static void reload() {
		Config.load();
		EventNotifiers.LOGGER.info("Config reloaded!");
	}
}