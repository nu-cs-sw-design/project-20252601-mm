package domain.game;

public class ReactionContext {
    private final Game game;
    private final int actingPlayerIndex;
    private final Card card;
    private final GameInteractionPort interactionPort;

    public ReactionContext(Game game, int actingPlayerIndex,
                           Card card, GameInteractionPort interactionPort) {
        this.game = game;
        this.actingPlayerIndex = actingPlayerIndex;
        this.card = card;
        this.interactionPort = interactionPort;
    }

    public Game getGame() {
        return game;
    }

    public int getActingPlayerIndex() {
        return actingPlayerIndex;
    }

    public Card getCard() {
        return card;
    }

    public GameInteractionPort getInteractionPort() {
        return interactionPort;
    }
}
