package com.petroff.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.petroff.EventNotifiers;
import net.minecraft.server.command.ServerCommandSource;

public class EnableCommand implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext context) throws CommandSyntaxException {
        EventNotifiers.enable();
        return 0;
    }
}
