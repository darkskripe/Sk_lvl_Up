package com.darkskripe.mod_core.sword_smith_lvl.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Map;

public class AspectsCodecMap {
    private final String key; // "sk_lvl_up"
    private final Map<String, Integer> aspects; // {"aspect1":1, "aspect2":2}

    public AspectsCodecMap(String key, Map<String, Integer> aspects) {
        this.key = key;
        this.aspects = aspects;
    }

    public String getKey() {
        return key;
    }

    public Map<String, Integer> getAspects() {
        return aspects;
    }

    // Codec that serializes only the 'aspects' field
    public static final Codec<AspectsCodecMap> CODEC = Codec.unboundedMap(Codec.STRING, Codec.INT)
            .xmap(aspects -> new AspectsCodecMap("sk_lvl_up", aspects), AspectsCodecMap::getAspects);

    // Full codec (if needed elsewhere)
    public static final Codec<AspectsCodecMap> FULL_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("key").forGetter(AspectsCodecMap::getKey),
            Codec.unboundedMap(Codec.STRING, Codec.INT).fieldOf("aspects").forGetter(AspectsCodecMap::getAspects)
    ).apply(instance, AspectsCodecMap::new));
}
