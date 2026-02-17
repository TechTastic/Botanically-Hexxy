package io.github.techtastic.botanically_hexxy.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.techtastic.botanically_hexxy.BotanicallyHexxyClient

object FabricBotanicallyHexxyModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(BotanicallyHexxyClient::getConfigScreen)
}
