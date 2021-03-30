import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution extends Thread{

    Player player;
    CopyOnWriteArrayList<Token> board;
    Map<Player,Integer> clasament=new HashMap<>();
    Thread t;
    public boolean running=true;
    Solution (Player player,CopyOnWriteArrayList<Token> board){
        this.board=board;
        this.player=player;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (this.board) {
            for(Token token:board){
                player.addToken(token);
                board.remove(token);
            }
        }
    }
    public void Describe(){
        player.showTokens();
    }
    public int calculateScore(){
        int var=0;
        for(Token token : player.getTokens())
            var+=token.getValue();
        return var;
    }
}

