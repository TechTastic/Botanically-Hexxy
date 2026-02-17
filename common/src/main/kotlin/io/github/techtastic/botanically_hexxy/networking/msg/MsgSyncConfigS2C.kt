package io.github.techtastic.botanically_hexxy.networking.msg

import io.github.techtastic.botanically_hexxy.config.BotanicallyHexxyServerConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: BotanicallyHexxyServerConfig.ServerConfig) : BotanicallyHexxyMessageS2C {
    companion object : BotanicallyHexxyMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = BotanicallyHexxyServerConfig.ServerConfig().decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
