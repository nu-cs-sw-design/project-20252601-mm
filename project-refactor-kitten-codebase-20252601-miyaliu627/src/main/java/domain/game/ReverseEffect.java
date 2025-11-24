package domain.game;

public class ReverseEffect implements CardEffect {
    private final Game game;

    public ReverseEffect(Game game) {
        this.game = game;
    }

    @Override
    public CardType getSupportedType() {
        return CardType.REVERSE;
    }

    @Override
    public boolean isNopeable() {
        return true; // can be noped
    }

    @Override
    public void play(PlayContext context) {
        game.playReverse();
    }
}
