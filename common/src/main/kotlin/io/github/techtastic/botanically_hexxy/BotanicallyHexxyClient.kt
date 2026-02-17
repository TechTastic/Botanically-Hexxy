package io.github.techtastic.botanically_hexxy

import io.github.techtastic.botanically_hexxy.config.BotanicallyHexxyClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object BotanicallyHexxyClient {
    fun init() {
        BotanicallyHexxyClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(BotanicallyHexxyClientConfig.GlobalConfig::class.java, parent).get()
    }
}
