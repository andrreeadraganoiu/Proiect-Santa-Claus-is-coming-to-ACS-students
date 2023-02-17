package strategies.score;

import input.Child;

public class KidScoreStrategy implements ScoreStrategy {

    private Child child;
    private int noRound;

    public KidScoreStrategy(final Child child, final int noRound) {
        this.child = child;
        this.noRound = noRound;
    }
    /**
     * Calculeaza scorul unui copil cu varsta cuprinsa intre 5 - 11 ani.
     */
    @Override
    public void calculateScore() {
        if (noRound == 0) {
            child.setAverageScore(child.getNiceScore());
            return;
        }
        Double score = 0.0;
        score = child.getNiceScoreHistory().stream()
                .reduce(0.0, (a, b) -> a + b);
        score = score / child.getNiceScoreHistory().size();
        child.setAverageScore(score);
    }
}
