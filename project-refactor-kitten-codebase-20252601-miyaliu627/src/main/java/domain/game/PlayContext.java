package domain.game;

public class PlayContext {

    private final Game game;
    private final int actingPlayerIndex;
    private final GameInteractionPort interactionPort;

    public PlayContext(Game game, int actingPlayerIndex,
                       GameInteractionPort interactionPort) {
        this.game = game;
        this.actingPlayerIndex = actingPlayerIndex;
        this.interactionPort = interactionPort;
    }

    public Game getGame() {
        return game;
    }

    public int getActingPlayerIndex() {
        return actingPlayerIndex;
    }

    public GameInteractionPort getInteractionPort() {
        return interactionPort;
    }
}
