package output;

import java.util.ArrayList;
import java.util.List;
/**
 * Clasa care retine listele de copii din toti anii.
 */
public class AnnualChildren {

    private List<ChildrenList> annualChildren = new ArrayList<>();

    public AnnualChildren() {
    }
    /**
     * @return
     */
    public List<ChildrenList> getAnnualChildren() {
        return annualChildren;
    }
    /**
     * @param annualChildren
     */
    public void setAnnualChildren(final List<ChildrenList> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
