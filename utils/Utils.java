package utils;

import enums.Category;
import enums.Cities;
import input.Child;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Utils {

    private Utils() {
    }
    /** Deep copy pentru child.getNiceScoreHistory()
     * @param list
     * @return un array care nu are referinta la cel initial
     */
    public static List<Double> deepCopyHistory(final List<Double> list) {
        List<Double> newList = new ArrayList<>(list);
        return newList;
    }
    /** Deep copy pentru child.getGiftsPreferences()
     * @param list
     * @return un array care nu are referinta la cel initial
     */
    public static List<Category> deepCopyCategory(final List<Category> list) {
        List<Category> newList = new ArrayList<>(list);
        return newList;
    }
    /**
     * Sorteaza un HashMap descrescator dupa valoare si crescator dupa cheie.
     * @param map
     * @return un HashMap sortat
     */
    public static Map<Cities, Double> sortDescByValue(final Map<Cities, Double> map) {

        List<Map.Entry<Cities, Double>> citiesList =
                new LinkedList<Map.Entry<Cities, Double>>(map.entrySet());

        Collections.sort(citiesList, new Comparator<Map.Entry<Cities, Double>>() {
            @Override
            public int compare(final Map.Entry<Cities, Double> o1,
                               final Map.Entry<Cities, Double> o2) {

                int res = o2.getValue().compareTo(o1.getValue());
                if (res == 0) {
                    return o1.getKey().toString().compareTo(o2.getKey().toString());
                }
                return res;
            }
        });

        Map<Cities, Double> aux = new LinkedHashMap<Cities, Double>();
        for (Map.Entry<Cities, Double> i : citiesList) {
            aux.put(i.getKey(), i.getValue());
        }
        return aux;
    }

    /** Construieste o lista cu caracteristicile copiilor dati din input folosind Builder.
     * @param children
     * @return
     */
    public static List<Child> buildChildren(final List<Child> children) {
        List<Child> builderChildren = new ArrayList<>();
        for (Child c : children) {
            Child newChild = new Child.ChildBuilder(c.getId(), c.getLastName(), c.getFirstName(),
                    c.getAge(), c.getCity(), c.getNiceScore(), c.getGiftsPreferences(),
                    c.getAverageScore(), c.getNiceScoreHistory(),
                    c.getAssignedBudget(), c.getReceivedGifts(),
                    c.getElf()).niceScoreBonus(c.getNiceScoreBonus()).build();
            builderChildren.add(newChild);
        }
        return builderChildren;
    }

}
