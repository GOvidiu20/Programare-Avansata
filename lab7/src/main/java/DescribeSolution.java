import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class DescribeSolution {
    public static int tokens=0;
    private CopyOnWriteArrayList<Token> board=new CopyOnWriteArrayList<>();
    private List<Player> players =new ArrayList<>();
    public CopyOnWriteArrayList<Token> getBoard() {
        return board;
    }
    public void setBoard(int n) {
        int i;
        for(i=0;i<n;i++){
            int first=(int)(Math.random()*10);
            int second=(int)(Math.random()*10);
            int value=(int)(Math.random()*10);
            board.add(new Token(first,second,value));
        }
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(int m) {
        int i;
        for(i=0;i<m;i++) {
            Player player = new Player("player"+i);
            players.add(player);
        }
    }
}
