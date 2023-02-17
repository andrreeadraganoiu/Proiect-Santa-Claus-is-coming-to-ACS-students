package strategies.distribution;

import input.Child;

import java.util.Collections;
import java.util.List;

public class IdStrategy implements GiftDivisionStrategy {
    private List<Child> children;

    public IdStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Ordoneaza copiii dupa id.
     */
    @Override
    public void distribute() {
        Collections.sort(children, Child.getAscId());
    }
}
