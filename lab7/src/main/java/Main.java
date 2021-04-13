import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n=5;
        int m=3;
        DescribeSolution problem=new DescribeSolution();
        problem.setBoard(n);
        problem.setPlayers(m);
        int i;
        List<Player> players=problem.getPlayers();
        new Solution(null, problem.getBoard(), true);
        for(i=0;i<m;i++){
            new Solution(players.get(i),problem.getBoard(),false);
        }

    }
}
