package com.petroff.mixin;

import com.petroff.Config;
import eu.pb4.placeholders.api.PlaceholderContext;
import eu.pb4.placeholders.api.Placeholders;
import eu.pb4.placeholders.api.TextParserUtils;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    void doAfterPlayerJoin(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
        PlaceholderContext placeholderPlayerContext = PlaceholderContext.of(player);

        Text msgTextStyled = TextParserUtils.formatText(Config.joinMessage);
        Text msgTextFinal = Placeholders.parseText(msgTextStyled, placeholderPlayerContext, Placeholders.PREDEFINED_PLACEHOLDER_PATTERN);

        player.sendMessage(msgTextFinal);
    }
}
