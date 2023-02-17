package strategies.distribution;

import enums.Cities;
import input.Child;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityStrategy implements GiftDivisionStrategy {
    private List<Child> children;

    public CityStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Distribuie copiii descrescator in functie de media oraselor
     * in care se afla, al doilea criteriu fiind id-ul.
     */
    @Override
    public void distribute() {
        Collections.sort(children, Child.getAscId());
        Map<Cities, Double> cities = completeCityMap();
        List<Child> sortedChildren = new ArrayList<>();
        for (Cities city : cities.keySet()) {
            for (Child child : children) {
                if (child.getCity().equals(city)) {
                    sortedChildren.add(child);
                }
            }
        }
        children.clear();
        children.addAll(sortedChildren);
    }

    /**
     * Calculeaza scorul unui oras.
     *
     * @param city
     * @return
     */
    public Double calculateCityScore(final Cities city) {
        Double score = 0.0;
        int nrCities = 0;
        for (Child child : children) {
            if (child.getCity().equals(city)) {
                score += child.getAverageScore();
                nrCities++;
            }
        }
        score = score / nrCities;
        return score;
    }

    /**
     * Construieste o mapa sortata descrescator dupa scor si crescator dupa cheie
     * cu toate orasele in care se afla copii.
     *
     * @return
     */
    public Map<Cities, Double> completeCityMap() {
        Map<Cities, Double> cities = new HashMap<>();
        for (Child child : children) {
            cities.put(child.getCity(), 0.0);
        }
        for (Cities city : cities.keySet()) {
            cities.put(city, calculateCityScore(city));
        }
        cities = Utils.sortDescByValue(cities);
        return cities;
    }
}
