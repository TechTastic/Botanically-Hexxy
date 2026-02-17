package io.github.techtastic.botanically_hexxy.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import io.github.techtastic.botanically_hexxy.networking.BotanicallyHexxyNetworking
import io.github.techtastic.botanically_hexxy.networking.handler.applyOnClient
import io.github.techtastic.botanically_hexxy.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface BotanicallyHexxyMessage

sealed interface BotanicallyHexxyMessageC2S : BotanicallyHexxyMessage {
    fun sendToServer() {
        BotanicallyHexxyNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface BotanicallyHexxyMessageS2C : BotanicallyHexxyMessage {
    fun sendToPlayer(player: ServerPlayer) {
        BotanicallyHexxyNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        BotanicallyHexxyNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface BotanicallyHexxyMessageCompanion<T : BotanicallyHexxyMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                BotanicallyHexxy.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is BotanicallyHexxyMessageC2S -> msg.applyOnServer(ctx)
                    else -> BotanicallyHexxy.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                BotanicallyHexxy.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is BotanicallyHexxyMessageS2C -> msg.applyOnClient(ctx)
                    else -> BotanicallyHexxy.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
