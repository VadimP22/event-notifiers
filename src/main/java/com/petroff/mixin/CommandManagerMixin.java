package com.petroff.mixin;

import com.mojang.brigadier.CommandDispatcher;
import com.petroff.EventNotifiers;
import com.petroff.commands.Commands;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public class CommandManagerMixin {
    @Shadow
    private CommandDispatcher<ServerCommandSource> dispatcher;

    @Inject(at = @At("TAIL"), method = "<init>*")
    void afterCtor(CallbackInfo info) {
        Commands.register(dispatcher);
    }
}
