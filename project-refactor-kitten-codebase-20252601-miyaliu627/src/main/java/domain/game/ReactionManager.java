package domain.game;

public interface ReactionManager {
    // Resolves all NOPE reactions for the current action and return true if current action is canceled by NOPE
    boolean resolveNopeReactions(ReactionContext context);
}
