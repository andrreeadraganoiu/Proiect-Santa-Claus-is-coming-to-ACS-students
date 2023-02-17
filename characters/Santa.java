package characters;

import enums.Category;
import input.AnnualChanges;
import input.Child;
import input.ChildUpdate;
import input.Gift;
import input.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static common.Constants.MAX_SCORE;
import static common.Constants.P_100;

public final class Santa {

    private Santa() {
    }

    /**
     * Returneaza cadourile unui copil. Cadourile sunt sortate dupa pret pentru
     * a fi gasit primul cadou din categoria dorita, cel care are pretul cel mai
     * mic. Cadourile se iau in ordinea categoriilor specificate in limita bugetului
     * alocat.
     *
     * @param santaGiftList cadourile disponibile
     * @param child
     * @return o lista cu cadouri
     */
    public static List<Gift> giveGift(final List<Gift> santaGiftList, final Child child) {
        List<Gift> gifts = new ArrayList<>();
        Double childBudget = child.getAssignedBudget();
        Collections.sort(santaGiftList, Gift.getAscPrice());
        for (Category category : child.getGiftsPreferences()) {
            for (int i = 0; i < santaGiftList.size(); i++) {
                if (category.equals(santaGiftList.get(i).getCategory())
                        && childBudget >= santaGiftList.get(i).getPrice()) {

                    if (santaGiftList.get(i).getQuantity() > 0) {
                        gifts.add(santaGiftList.get(i));
                        childBudget -= santaGiftList.get(i).getPrice();
                        santaGiftList.get(i).setQuantity(santaGiftList.get(i).getQuantity() - 1);
                        break;
                    }
                }
            }
        }
        return gifts;
    }

    /**
     * Reordoneaza lista de preferinte a unui copill.
     *
     * @param child
     * @param childUpdate
     */
    public static void sortGiftsPreferences(final Child child, final ChildUpdate childUpdate) {
        List<Category> list = new ArrayList<>();
        list.addAll(childUpdate.getGiftsPreferences());
        list.addAll(child.getGiftsPreferences());
        child.getGiftsPreferences().clear();
        child.getGiftsPreferences().addAll(list);

        Set<Category> set = new LinkedHashSet<>();
        set.addAll(child.getGiftsPreferences());
        child.getGiftsPreferences().clear();
        child.getGiftsPreferences().addAll(set);
    }

    /**
     * Adauga noii copii la lista, pastreaza nota in history. Adauga noile cadouri
     * disponibile din fiecare an.
     * Se completeaza lista cu scorurile de cumintenie din history. Se actualizeaza
     * lista de preferinte a unui copil, preferintele din urma devenind cele mai
     * importante.
     *
     * @param children
     * @param santaGiftsList cadourile disponibile
     * @param annualChanges  o lista cu schimbarile anuale
     */
    public static void updateData(final List<Child> children,
                                  final List<Gift> santaGiftsList,
                                  final AnnualChanges annualChanges) {

        children.addAll(annualChanges.getNewChildren());
        for (Child newChild : annualChanges.getNewChildren()) {
            newChild.getNiceScoreHistory().add(newChild.getNiceScore());
        }
        santaGiftsList.addAll(annualChanges.getNewGifts());

        for (ChildUpdate childUpdate : annualChanges.getChildrenUpdates()) {
            for (int i = 0; i < children.size(); i++) {
                if (childUpdate.getId() == children.get(i).getId()) {
                    sortGiftsPreferences(children.get(i), childUpdate);
                    if (childUpdate.getNiceScore() != null) {
                        children.get(i).getNiceScoreHistory().add(childUpdate.getNiceScore());
                    }
                    children.get(i).setElf(childUpdate.getElf());
                }
            }
        }
    }

    /**
     * Adauga bonus unui copil.
     *
     * @param child
     */
    public static void giveBonus(final Child child) {
        Double childAverageScore = child.getAverageScore();
        childAverageScore += childAverageScore * child.getNiceScoreBonus() / P_100;
        child.setAverageScore(childAverageScore);

        if (childAverageScore > MAX_SCORE) {
            child.setAverageScore(MAX_SCORE);
        }
    }

    /**
     * Imparte bugetul alocat copiilor.
     *
     * @param children
     * @param input
     * @return
     */
    public static Double calculateBudgetUnit(final List<Child> children, final Input input) {
        Double totalScore = 0.0;
        for (Child child : children) {
            totalScore += child.getAverageScore();
        }
        Double budgetUnit = input.getSantaBudget() / totalScore;
        return budgetUnit;
    }
}
