package domain.game;

public interface CardEffect {
    CardType getSupportedType();

    // Returns true if this card can be canceled by a NOPE chain.
    default boolean isNopeable() {
        return true;
    }

    void play(PlayContext context);
}
