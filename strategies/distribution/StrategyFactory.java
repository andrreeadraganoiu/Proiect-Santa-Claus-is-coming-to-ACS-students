package strategies.distribution;

import enums.CityStrategyEnum;
import input.Child;

import java.util.List;

public final class StrategyFactory {
    private static StrategyFactory instance = null;

    private StrategyFactory() {
    }

    /**
     * Creeaza o strategie de ordonare a copiilor
     *
     * @param strategyType tipul strategiei
     * @param children     lista de copii
     * @return strategia corespunzatoare
     */
    public GiftDivisionStrategy chooseStrategy(final CityStrategyEnum strategyType,
                                               final List<Child> children) {
        return switch (strategyType) {
            case ID -> new IdStrategy(children);
            case NICE_SCORE -> new NiceScoreStrategy(children);
            case NICE_SCORE_CITY -> new CityStrategy(children);
        };
    }

    /**
     * @return o instanta a strategiei
     */
    public static StrategyFactory getStrategyFactoryInstance() {
        if (instance == null) {
            instance = new StrategyFactory();
        }
        return instance;
    }
}
