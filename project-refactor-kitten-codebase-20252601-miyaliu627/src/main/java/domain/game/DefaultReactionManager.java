package domain.game;

public class DefaultReactionManager implements ReactionManager {
    @Override
    public boolean resolveNopeReactions(ReactionContext context) {
        // TODO: actually resolve nope, just a placeholder for now
        return false;
    }
}
