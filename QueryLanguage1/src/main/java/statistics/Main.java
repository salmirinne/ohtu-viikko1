package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                  .hasAtLeast(20, "goals")
                  .hasFewerThan(35, "goals").build();

        Matcher m2 = query.playsIn("EDM")
                  .hasAtLeast(50, "points").build();

        Matcher m = query.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
