package io.github.techtastic.botanically_hexxy.forge

import dev.architectury.platform.forge.EventBuses
import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import io.github.techtastic.botanically_hexxy.forge.datagen.ForgeBotanicallyHexxyDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(BotanicallyHexxy.MODID)
class ForgeBotanicallyHexxy {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(BotanicallyHexxy.MODID, this)
            addListener(ForgeBotanicallyHexxyClient::init)
            addListener(ForgeBotanicallyHexxyDatagen::init)
            addListener(ForgeBotanicallyHexxyServer::init)
        }
        BotanicallyHexxy.init()
    }
}
