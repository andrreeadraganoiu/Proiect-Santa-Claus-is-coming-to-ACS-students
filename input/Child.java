package input;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Child extends ChildUpdate {
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double averageScore;
    private List<Double> niceScoreHistory = new ArrayList<>();
    private Double assignedBudget;
    private List<Gift> receivedGifts = new ArrayList<>();
    private Double niceScoreBonus;

    public Child() {
    }

    public static class ChildBuilder {
        private int id;
        private String lastName;
        private String firstName;
        private int age;
        private Cities city;
        private Double niceScore;
        private List<Category> giftsPreferences;
        private Double averageScore;
        private List<Double> niceScoreHistory;
        private Double assignedBudget;
        private List<Gift> receivedGifts;
        private ElvesType elf;
        private Double niceScoreBonus;

        public ChildBuilder(final int id, final String lastName, final String firstName,
                            final int age, final Cities city, final Double niceScore,
                            final List<Category> giftsPreferences, final Double averageScore,
                            final List<Double> niceScoreHistory, final Double assignedBudget,
                            final List<Gift> receivedGifts, final ElvesType elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.city = city;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.averageScore = averageScore;
            this.niceScoreHistory = niceScoreHistory;
            this.assignedBudget = assignedBudget;
            this.receivedGifts = receivedGifts;
            this.elf = elf;
        }
        /**
         * @param niceScoreBonus
         * @return
         */
        public ChildBuilder niceScoreBonus(final Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }
        /**
         * @return
         */
        public Child build() {
            return new Child(this, id, niceScore, giftsPreferences, elf);
        }
    }

    private Child(final ChildBuilder childBuilder, final int id,
                  final Double niceScore, final List<Category> giftsPreferences,
                  final ElvesType elf) {
        super(id, niceScore, giftsPreferences, elf);
        this.lastName = childBuilder.lastName;
        this.firstName = childBuilder.firstName;
        this.age = childBuilder.age;
        this.city = childBuilder.city;
        this.averageScore = childBuilder.averageScore;
        this.niceScoreHistory = childBuilder.niceScoreHistory;
        this.assignedBudget = childBuilder.assignedBudget;
        this.receivedGifts = childBuilder.receivedGifts;
        this.niceScoreBonus = childBuilder.niceScoreBonus;
    }

    private static Comparator<Child> ascId = (o1, o2) -> {
        int child1 = o1.getId();
        int child2 = o2.getId();
        return Integer.compare(child1, child2);
    };

    private static Comparator<Child> descAverageScore = (o1, o2) -> {
        Double child1 = o1.getAverageScore();
        Double child2 = o2.getAverageScore();
        return Double.compare(child2, child1);
    };
    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age
     */
    public void setAge(final int age) {
        this.age = age;
    }
    /**
     * @return
     */
    public Cities getCity() {
        return city;
    }
    /**
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }
    /**
     * @return
     */
    public Double getAverageScore() {
        return averageScore;
    }
    /**
     * @param averageScore
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }
    /**
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }
    /**
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }
    /**
     * @return
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }
    /**
     * @param assignedBudget
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }
    /**
     * @return
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }
    /**
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
    /**
     * @return
     */
    public static Comparator<Child> getAscId() {
        return ascId;
    }
    /**
     * @return
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }
    /**
     * @param niceScoreBonus
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }
    /**
     * @return
     */
    public static Comparator<Child> getDescAverageScore() {
        return descAverageScore;
    }

}
