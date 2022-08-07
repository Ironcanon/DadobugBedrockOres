package no.dadobug.forge;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;
import no.dadobug.BiomeSelectors;

import java.util.function.Predicate;

public class BiomeSelectorsImpl {

    public static Predicate<BiomeModifications.BiomeContext> gensInOverworld() {
        return biomeContext -> BiomeDictionary.hasType(RegistryKey.of(Registry.BIOME_KEY, biomeContext.getKey()), BiomeDictionary.Type.OVERWORLD) || BiomeSelectors.gensInSource(BiomeSelectors.overworld).test(biomeContext);
    }

    public static Predicate<BiomeModifications.BiomeContext> gensInNether() {
        return biomeContext -> BiomeDictionary.hasType(RegistryKey.of(Registry.BIOME_KEY, biomeContext.getKey()), BiomeDictionary.Type.NETHER) || BiomeSelectors.gensInSource(BiomeSelectors.nether).test(biomeContext);
    }

    public static Predicate<BiomeModifications.BiomeContext> gensInEnd() {
        return  biomeContext -> BiomeDictionary.hasType(RegistryKey.of(Registry.BIOME_KEY, biomeContext.getKey()), BiomeDictionary.Type.END) || BiomeSelectors.gensInSource(BiomeSelectors.end).test(biomeContext);
    }

    public static Predicate<BiomeModifications.BiomeContext> gensInBiome(String identifier) {
        Biome biome = ForgeRegistries.BIOMES.getValue(new Identifier(identifier));
        return context -> biome.equals(ForgeRegistries.BIOMES.getValue(context.getKey()));
    }
}
