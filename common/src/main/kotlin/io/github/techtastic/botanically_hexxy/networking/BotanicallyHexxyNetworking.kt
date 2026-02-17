package io.github.techtastic.botanically_hexxy.networking

import dev.architectury.networking.NetworkChannel
import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import io.github.techtastic.botanically_hexxy.networking.msg.BotanicallyHexxyMessageCompanion

object BotanicallyHexxyNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(BotanicallyHexxy.id("networking_channel"))

    fun init() {
        for (subclass in BotanicallyHexxyMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
