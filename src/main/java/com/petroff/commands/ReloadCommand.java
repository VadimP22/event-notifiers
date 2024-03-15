package com.petroff.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.petroff.EventNotifiers;
import net.minecraft.server.command.ServerCommandSource;

public class ReloadCommand implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext context) throws CommandSyntaxException {
        EventNotifiers.reload();
        return 0;
    }

//    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
//        dispatcher.register(CommandManager.literal("event-notifiers").requires((source) -> {
//            return source.hasPermissionLevel(3);
//        }).then(CommandManager.literal("reload").executes(this)));
//    }
}
