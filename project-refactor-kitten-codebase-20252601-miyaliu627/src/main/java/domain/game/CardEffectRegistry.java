package domain.game;

import java.util.HashMap;
import java.util.Map;

public class CardEffectRegistry {
    private final Map<CardType, CardEffect> effects = new HashMap<>();

    public void register(CardEffect effect) {
        effects.put(effect.getSupportedType(), effect);
    }

    public CardEffect get(CardType type) {
        return effects.get(type);
    }
}
