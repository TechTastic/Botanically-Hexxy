package io.github.techtastic.botanically_hexxy.forge

import io.github.techtastic.botanically_hexxy.BotanicallyHexxyClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeBotanicallyHexxyClient {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLClientSetupEvent) {
        BotanicallyHexxyClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> BotanicallyHexxyClient.getConfigScreen(parent) }
        }
    }
}
