package main;

import input.AnnualChanges;
import input.Child;
import input.Gift;
import input.InitialData;
import input.Input;
import output.AnnualChildren;
import output.ChildrenList;
import output.OutChild;
import output.OutGift;
import strategies.score.ScoreStrategyFactory;
import strategies.distribution.StrategyFactory;
import characters.Elves;
import characters.Santa;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static common.Constants.MAX_TEEN;

public final class Simulation {
    private static Simulation instance = null;

    private Simulation() {
    }

    /**
     * Executa toate etapele necesare pentru desfasurarea rundelor. Se actualizeaza
     * datele copiilor pentru fiecare runda. Datele de output ale unui copil vor fi
     * copiate in OutChild.
     *
     * @param input         fisierul din care incepe maparea datelor
     * @param initialData   datele initiale din input
     * @param children      o lista cu copiii initiali
     * @param annualChanges o lista de schimbari anule
     * @return clasa cu listele de copii din toate rundele
     */
    public AnnualChildren run(final Input input, final InitialData initialData,
                              final List<Child> children,
                              final List<AnnualChanges> annualChanges) {

        AnnualChildren annualChildren = new AnnualChildren();
        children.forEach(child -> child.getNiceScoreHistory().add(child.getNiceScore()));

        for (int noRound = 0; noRound <= input.getNumberOfYears(); noRound++) {
            children.removeIf((child) -> child.getAge() > MAX_TEEN);
            ScoreStrategyFactory childStrategyFactory =
                    ScoreStrategyFactory.getChildStrategyFactoryInstance();
            for (Child child : children) {
                childStrategyFactory.chooseScoreStrategy(child, noRound).calculateScore();
                Santa.giveBonus(child);
            }
            children.forEach(child -> child.setAssignedBudget(child.getAverageScore()
                    * Santa.calculateBudgetUnit(children, input)));
            children.forEach(child -> Elves.applyElf(child.getElf(), child));

            StrategyFactory strategyFactory = StrategyFactory.getStrategyFactoryInstance();
            if (noRound != 0) {
                strategyFactory.chooseStrategy(annualChanges.get(noRound - 1).getStrategy(),
                        children).distribute();
            }
            children.forEach(child ->
                    child.setReceivedGifts(Santa.giveGift(initialData.getSantaGiftsList(), child)));

            children.forEach(child -> Elves.applyYellowElf(child, initialData.getSantaGiftsList()));
            Collections.sort(children, Child.getAscId());

            ChildrenList childrenList = createOutChildList(children);
            annualChildren.getAnnualChildren().add(childrenList);
            children.forEach((child) -> child.setAge(child.getAge() + 1));
            if (noRound != input.getNumberOfYears()) {
                input.setSantaBudget(annualChanges.get(noRound).getNewSantaBudget());
                Santa.updateData(children,
                        initialData.getSantaGiftsList(),
                        annualChanges.get(noRound));
            }
        }
        return annualChildren;
    }

    /**
     * Construieste o clasa care contine o lista cu copiii corespunzatori unei singure
     * runde.
     *
     * @param children copiii din input
     * @return clasa careia i se actualizeaza lista de copii.
     */
    public ChildrenList createOutChildList(final List<Child> children) {
        ChildrenList childrenList = new ChildrenList();
        for (Child c : children) {
            List<OutGift> outGiftsList = createOutGifts(c.getReceivedGifts());
            OutChild o = new OutChild(c.getId(), c.getLastName(), c.getFirstName(),
                    c.getCity(), c.getAge(), Utils.deepCopyCategory(c.getGiftsPreferences()),
                    c.getAverageScore(), Utils.deepCopyHistory(c.getNiceScoreHistory()),
                    c.getAssignedBudget(), outGiftsList);
            childrenList.getChildren().add(o);
        }
        return childrenList;
    }

    /**
     * Construieste o lista de cadouri care contin doar campurile necesare afisarii.
     *
     * @param gifts
     * @return
     */
    public List<OutGift> createOutGifts(final List<Gift> gifts) {
        List<OutGift> outGifts = new ArrayList<>();
        for (Gift g : gifts) {
            OutGift o = new OutGift(g.getProductName(), g.getPrice(), g.getCategory());
            outGifts.add(o);
        }
        return outGifts;
    }

    /**
     * @return o instanta a simularii
     */
    public static Simulation getSimulationInstance() {
        if (instance == null) {
            instance = new Simulation();
        }
        return instance;
    }
}
