package io.github.techtastic.botanically_hexxy.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.techtastic.botanically_hexxy.config.BotanicallyHexxyServerConfig
import io.github.techtastic.botanically_hexxy.networking.msg.*

fun BotanicallyHexxyMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            BotanicallyHexxyServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
