package output;

import java.util.ArrayList;
import java.util.List;
/**
 * Clasa care retine copiii corespunzatori unei runde.
 */
public class ChildrenList {

    private List<OutChild> children = new ArrayList<>();

    public ChildrenList() {
    }
    /**
     * @return
     */
    public List<OutChild> getChildren() {
        return children;
    }
    /**
     * @param children
     */
    public void setChildren(final List<OutChild> children) {
        this.children = children;
    }
}
