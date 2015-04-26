package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {

    private List<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList<>();
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public Matcher build() {
        And query = new And(matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return query;
    }

}
