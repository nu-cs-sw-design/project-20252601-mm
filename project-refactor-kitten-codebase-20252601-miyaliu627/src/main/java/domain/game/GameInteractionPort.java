package domain.game;

public interface GameInteractionPort {
    boolean askYesNo(String messageKey);

    int askForIndex(String messageKey, int minInclusive, int maxInclusive);

    int askForPlayer(String messageKey, int[] validPlayerIndices);

    void showMessage(String messageKey, Object... args);
}
