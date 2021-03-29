import java.util.List;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class Solution extends Thread{

    Player player;
    List<Token> board;
    Thread t;
    Solution (Player player,List<Token> board){
        this.board=board;
        this.player=player;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < board.size(); i++) {
                player.addToken(board.get(i));
                board.remove(i);
            }
        }
    }
}

