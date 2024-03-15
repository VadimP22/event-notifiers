package com.petroff;

import net.fabricmc.loader.api.FabricLoader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Config {
    private final static File configFile = FabricLoader.getInstance().getConfigDir().resolve("event-notifiers.json").toFile();

    public static String joinMessage = "Welcome, ${player:name}";

    static String getConfigEntry(JSONObject jsonObject, String field) {
       try {
           var value = jsonObject.get("join_message");

           if (value != null) {
               return (String) value;
           } else {
               EventNotifiers.LOGGER.warn("Field <" + field + "> not found. Using default value.");
           }

       } catch (Exception e) {
           EventNotifiers.LOGGER.warn("Error while parsing field <" + field + ">. Using default value");
           EventNotifiers.LOGGER.warn(e.toString());
       }

       return null;
    }

    public static void load() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(configFile)) {
            JSONObject file = (JSONObject) parser.parse(reader);

            var confJoinMessage = getConfigEntry(file, "join_message");
            if (confJoinMessage != null)
                joinMessage = confJoinMessage;

        }
        catch (Exception e) {
            EventNotifiers.LOGGER.error("Error while parsing config (config/event-notifiers.json)");
            EventNotifiers.LOGGER.error(e.toString());
        }
    }
}
