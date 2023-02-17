package input;

import java.util.List;

public class Input {
    private int numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private List<AnnualChanges> annualChanges;

    public Input() {
    }

    public Input(final int numberOfYears, final Double santaBudget,
                 final InitialData initialData,
                 final List<AnnualChanges> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }
    /**
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }
    /**
     * @param numberOfYears
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    /**
     * @return
     */
    public Double getSantaBudget() {
        return santaBudget;
    }
    /**
     * @param santaBudget
     */
    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }
    /**
     * @return
     */
    public InitialData getInitialData() {
        return initialData;
    }
    /**
     * @param initialData
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }
    /**
     * @return
     */
    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }
    /**
     * @param annualChanges
     */
    public void setAnnualChanges(final List<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
