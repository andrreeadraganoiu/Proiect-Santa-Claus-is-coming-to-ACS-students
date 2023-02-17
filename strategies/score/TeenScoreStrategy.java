package strategies.score;

import input.Child;

public class TeenScoreStrategy implements ScoreStrategy {

    private Child child;
    private int noRound;

    public TeenScoreStrategy(final Child child, final int noRound) {
        this.child = child;
        this.noRound = noRound;
    }
    /**
     * Calculeaza scorul unui copil cu varsta cuprinsa intre 12 - 18 ani.
     */
    @Override
    public void calculateScore() {
        if (noRound == 0) {
            child.setAverageScore(child.getNiceScore());
            return;
        }
        Double score = 0.0;
        for (int i = 1; i <= child.getNiceScoreHistory().size(); i++) {
            score = score + child.getNiceScoreHistory().get(i - 1) * i;
        }
        score = score / ((child.getNiceScoreHistory().size()
                * (child.getNiceScoreHistory().size() + 1) / 2));
        child.setAverageScore(score);
    }
}
