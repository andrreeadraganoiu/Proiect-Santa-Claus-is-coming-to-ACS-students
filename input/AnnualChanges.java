package input;

import enums.CityStrategyEnum;

import java.util.List;

public class AnnualChanges {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<Child> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private CityStrategyEnum strategy;

    public AnnualChanges() {
    }

    public AnnualChanges(final Double newSantaBudget, final List<Gift> newGifts,
                         final List<Child> newChildren,
                         final List<ChildUpdate> childrenUpdates,
                         final CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategy = strategy;
    }
    /**
     * @return
     */
    public Double getNewSantaBudget() {
        return newSantaBudget;
    }
    /**
     * @return
     */
    public List<Gift> getNewGifts() {
        return newGifts;
    }
    /**
     * @return
     */
    public List<Child> getNewChildren() {
        return newChildren;
    }
    /**
     * @return
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }
    /**
     * @return
     */
    public CityStrategyEnum getStrategy() {
        return strategy;
    }
}
