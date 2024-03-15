package com.petroff.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.petroff.EventNotifiers;
import net.minecraft.server.command.ServerCommandSource;

public class DisableCommand implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        EventNotifiers.disable();
        return 0;
    }
}
