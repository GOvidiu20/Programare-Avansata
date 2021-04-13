import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class DescribeSolution {
    private int board[][];
    private List<Player> players =new ArrayList<>();
    public int[][] getBoard() {
        return board;
    }
    public void setBoard(int n) {
        int i;
        board=new int[n][n];
        for(i=0;i<n;i++){
            int first=(int)((Math.random()*10+n)%n);
            int second=(int)((Math.random()*10%+n)%n);
            int value=(int)((Math.random()*10+n)%n)+1;
            board[first][second]=value;
        }
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(int m) {
        int i;
        for(i=0;i<m;i++) {
            double x=Math.random();
            if(x<0.5) {
                Player player = new Player("player" + i, "manual",i);
                players.add(player);
            }
            else{
                Player player = new Player("player" + i, "random",i);
                players.add(player);
            }
        }
    }
}
