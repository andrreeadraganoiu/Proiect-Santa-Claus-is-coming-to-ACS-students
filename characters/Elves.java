package characters;

import enums.Category;
import enums.ElvesType;
import input.Child;
import input.Gift;

import java.util.Collections;
import java.util.List;

import static common.Constants.P_100;
import static common.Constants.P_30;

public final class Elves {

    private Elves() {
    }

    /**
     * Aplica elful WHITE.
     */
    public static void white() {
        return;
    }

    /**
     * Aplica elful BLACK.
     *
     * @param child
     */
    public static void black(final Child child) {
        Double childBudget = child.getAssignedBudget();
        childBudget -= childBudget * P_30 / P_100;
        child.setAssignedBudget(childBudget);
    }

    /**
     * Aplica elful PINK.
     *
     * @param child
     */
    public static void pink(final Child child) {
        Double childBudget = child.getAssignedBudget();
        childBudget += childBudget * P_30 / P_100;
        child.setAssignedBudget(childBudget);
    }

    /**
     * Un copil care nu a primit niciun cadou in acest
     * an va primi cel mai ieftin cadou din prima categorie preferata de acesta
     * daca mai exista in sacul mosului.
     *
     * @param child
     * @param santaGiftList
     */
    public static void yellow(final Child child, final List<Gift> santaGiftList) {
        int ok = 0;
        Collections.sort(santaGiftList, Gift.getAscPrice());
        if (child.getReceivedGifts().size() == 0) {
            Category firstPreferredCategory = child.getGiftsPreferences().get(0);
            for (Gift gift : santaGiftList) {
                if (firstPreferredCategory.equals(gift.getCategory()) && ok == 0) {
                    if (gift.getQuantity() > 0) {
                        child.getReceivedGifts().add(gift);
                        gift.setQuantity(gift.getQuantity() - 1);
                    }
                    ok++;
                    if (ok > 0) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Aplica elful corespunzator, elful YELLOW se poate aplica la finalul actiunii.
     *
     * @param elf
     * @param child
     */
    public static void applyElf(final ElvesType elf, final Child child) {
        switch (elf) {
            case BLACK -> black(child);
            case PINK -> pink(child);
            default -> white();
        }
    }

    /**
     * Aplica elful YELLOW. Se poate aplica doar daca acel copil nu a primit
     * niciun cadou in acel an de Craciun.
     *
     * @param child
     * @param santaGiftList
     */
    public static void applyYellowElf(final Child child, final List<Gift> santaGiftList) {
        if (child.getElf().equals(ElvesType.YELLOW)) {
            yellow(child, santaGiftList);
        }
    }

}
