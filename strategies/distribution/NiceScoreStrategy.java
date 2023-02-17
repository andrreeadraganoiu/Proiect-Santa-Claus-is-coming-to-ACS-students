package strategies.distribution;

import input.Child;

import java.util.Collections;
import java.util.List;

public class NiceScoreStrategy implements GiftDivisionStrategy {
    private List<Child> children;

    public NiceScoreStrategy(final List<Child> children) {
        this.children = children;
    }

    /**
     * Ordoneaza copiii dupa scorul de cumintenie, al doilea criteriu de
     * comparatie fiind id-ul.
     */
    @Override
    public void distribute() {
        Collections.sort(children, Child.getDescAverageScore()
                .thenComparing(Child.getAscId()));
    }
}
