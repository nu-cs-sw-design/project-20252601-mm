package domain.game;

public class ShuffleEffect implements CardEffect {
    private final Game game;

    public ShuffleEffect(Game game) {
        this.game = game;
    }

    @Override
    public CardType getSupportedType() {
        return CardType.SHUFFLE;
    }

    @Override
    public boolean isNopeable() {
        return true; // can be noped
    }

    @Override
    public void play(PlayContext context) {
        GameInteractionPort io = context.getInteractionPort();

        io.showMessage("decidedShuffle");

        final int maxNumberOfShuffles = 100;
        int numberOfShuffle;

        while (true) {
            numberOfShuffle = io.askForIndex("enterShuffleTimes", 1, maxNumberOfShuffles);
            if (numberOfShuffle > 0 && numberOfShuffle <= maxNumberOfShuffles) {
                break;
            }
            io.showMessage("enterPositiveInteger");
        }

        game.playShuffle(numberOfShuffle);
    }
}
