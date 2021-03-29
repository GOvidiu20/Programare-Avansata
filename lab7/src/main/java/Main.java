import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        int n=10;
        int m=2;
        DescribeSolution problem=new DescribeSolution();
        problem.setBoard(n);
        problem.setPlayers(m);
        int i;
        List<Player> players=problem.getPlayers();
        for(i=0;i<m;i++){
            new Solution(players.get(i),problem.getBoard());
        }
    }
}
