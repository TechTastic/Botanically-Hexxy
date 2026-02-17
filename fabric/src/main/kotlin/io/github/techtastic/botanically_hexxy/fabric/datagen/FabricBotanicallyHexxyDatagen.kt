package io.github.techtastic.botanically_hexxy.fabric.datagen

import io.github.techtastic.botanically_hexxy.datagen.BotanicallyHexxyActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricBotanicallyHexxyDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::BotanicallyHexxyActionTags)
    }
}
