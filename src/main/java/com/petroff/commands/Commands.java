package com.petroff.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class Commands {
    public static final ReloadCommand reloadCommand = new ReloadCommand();
    public static final EnableCommand enableCommand = new EnableCommand();
    public static final DisableCommand disableCommand = new DisableCommand();

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("event-notifiers").requires((source) -> {
            return source.hasPermissionLevel(4);
        })
                .then(CommandManager.literal("reload").executes(reloadCommand))
                .then(CommandManager.literal("enable").executes(enableCommand))
                .then(CommandManager.literal("disable").executes(disableCommand))
        );


    }
}
