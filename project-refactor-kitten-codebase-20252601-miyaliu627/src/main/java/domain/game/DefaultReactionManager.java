package domain.game;

public class DefaultReactionManager implements ReactionManager {
    @Override
    public boolean resolveNopeReactions(ReactionContext ctx) {
        Game game = ctx.getGame();
        GameInteractionPort io = ctx.getInteractionPort();
        int actingPlayer = ctx.getActingPlayerIndex();

        boolean actionCanceled = false;
        boolean anotherNopePlayed;

        do {
            anotherNopePlayed = false;

            for (int playerIndex = 0;
                 playerIndex < game.getNumberOfPlayers();
                 playerIndex++) {

                if (playerIndex == actingPlayer) {
                    continue; // A player cannot nope their own action
                }
                if (game.checkIfPlayerDead(playerIndex)) {
                    continue;
                }
                if (!game.checkIfPlayerHasCard(playerIndex, CardType.NOPE)) {
                    continue;
                }

                io.showMessage("playerHasNopeCard", playerIndex);
                boolean playNope = io.askYesNo("wouldYouPlayNope");

                if (playNope) {
                    // remove NOPE from that player's hand
                    game.removeCardFromHand(playerIndex, CardType.NOPE);
                    io.showMessage("decidedToPlayNope", playerIndex);

                    // flip cancel flag
                    actionCanceled = !actionCanceled;
                    anotherNopePlayed = true;

                    // allow others to NOPE this NOPE in the next outer loop
                } else {
                    io.showMessage("playerDidNotPlayNope", playerIndex);
                }
            }

        } while (anotherNopePlayed);

        return actionCanceled;
    }
}
