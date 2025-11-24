package domain.game;

public class ExplodingKittenEffect implements CardEffect {

    private final Game game;

    public ExplodingKittenEffect(Game game) {
        this.game = game;
    }

    @Override
    public CardType getSupportedType() {
        return CardType.EXPLODING_KITTEN;
    }

    // cannot be noped
    @Override
    public boolean isNopeable() {
        return false;
    }

    @Override
    public void play(PlayContext context) {
        int playerIndex = context.getActingPlayerIndex();
        GameInteractionPort io = context.getInteractionPort();

        io.showMessage("explodingKittenMessage");

        // If the player has no DEFUSE, they explode.
        if (!game.checkIfPlayerHasCard(playerIndex, CardType.DEFUSE)) {
            io.showMessage("noDefuseCardMessage");
            io.showMessage("youExplodedMessage");
            game.playExplodingKitten(playerIndex);
            return;
        }

        io.showMessage("defusedMessage");
        io.showMessage("whereToInsertMessage");

        int deckSize = game.getDeckSize();
        while (true) {
            int indexToInsert =
                    io.askForIndex("validRangeMessage", 0, deckSize);

            try {
                game.playDefuse(indexToInsert, playerIndex);
                game.getPlayerAtIndex(playerIndex).setCursed(false);
                return;
            } catch (UnsupportedOperationException e) {
                io.showMessage("invalidInputMessage");
            }
        }
    }
}
