package strategies.score;

import input.Child;
import static common.Constants.MAX_SCORE;

public class BabyScoreStrategy implements ScoreStrategy {
    private Child child;

    public BabyScoreStrategy(final Child child) {
        this.child = child;
    }
    /**
     * Calculeaza scorul unui copil mai mic de 5 ani.
     */
    @Override
    public void calculateScore() {
        child.setAverageScore(MAX_SCORE);
    }
}
