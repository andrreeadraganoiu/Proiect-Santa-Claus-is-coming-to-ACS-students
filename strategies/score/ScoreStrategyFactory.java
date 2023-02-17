package strategies.score;

import input.Child;

import static common.Constants.MAX_BABY;
import static common.Constants.MAX_KID;
import static common.Constants.MAX_TEEN;

public final class ScoreStrategyFactory {
    private static ScoreStrategyFactory instance = null;

    private ScoreStrategyFactory() {
    }
    /** Creeaza o strategie de calculare a scorului in functie de varsta copilului.
     * @param child
     * @param noRound numarul rundei, se calculeaza diferit pentru runda initiala
     * @return strategia corespunzatoare varstei
     */
    public ScoreStrategy chooseScoreStrategy(final Child child, final int noRound) {

        if (child.getAge() <= MAX_BABY) {
            return new BabyScoreStrategy(child);
        } else if (child.getAge() > MAX_BABY && child.getAge() <= MAX_KID) {
            return new KidScoreStrategy(child, noRound);
        } else if (child.getAge() > MAX_KID && child.getAge() <= MAX_TEEN) {
            return new TeenScoreStrategy(child, noRound);
        }
        return null;
    }
    /**
     * @return o instanta a strategiei
     */
    public static ScoreStrategyFactory getChildStrategyFactoryInstance() {
        if (instance == null) {
            instance = new ScoreStrategyFactory();
        }
        return instance;
    }
}
