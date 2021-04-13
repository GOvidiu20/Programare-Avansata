import java.util.*;

public class Solution extends Thread{

    Player player;
    int board[][];
    Map<Player,Integer> clasament=new HashMap<>();
    Thread t;
    public static int rand;
    public static int nrPlayers;
    public static long time1;
    public static long time2;
    Solution (Player player,int board[][],boolean daemon){
        this.board=board;
        this.player=player;
        nrPlayers++;
        t = new Thread(this);
        t.setDaemon(daemon);
        t.start();
    }

    @Override
    public synchronized void run() {
        if(Thread.currentThread().isDaemon()) {
            System.out.println("daemon thread");
            time1=System.currentTimeMillis();
        }
        else
            System.out.println("user thread");
        Scanner scanner=new Scanner(System.in);
        int n = board.length;
        int ok;
        if(!Thread.currentThread().isDaemon()) {
            while (this.empty() == true) { //cat timp mai sunt token uri pe tabla
                while (player.getId() != rand) { //cat timp nu este randul lui,asteapta
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ok = 1;
                while (ok != 0) {//alege tipul de tactica
                    int first = 0, second = 0;
                    if (player.getTactic().equals("random")) {
                        first = (int) ((Math.random() * 10 + n) % n);
                        second = (int) ((Math.random() * 10 % +n) % n);
                    } else {
                        System.out.println(player.getName() + " alege numerele: ");
                        first = Integer.parseInt(scanner.nextLine());
                        second = Integer.parseInt(scanner.nextLine());
                    }
                    int value = board[first][second];
                    if (value != 0) { //daca numerele alese mai sunt pe tabla de joc
                        player.addToken(new Token(first, second, value));
                        board[first][second] = 0;
                        ok = 0;
                        System.out.println(player.getName() + " a ales :" + first + " " + second);
                    }
                }
                rand++;
                if (rand == nrPlayers) {
                    rand = 0;
                    time2 = System.currentTimeMillis();
                    System.out.println(time2 - time1);
                }
                time2 = System.currentTimeMillis();
                System.out.println((time2 - time1)/1000 +" secunde");
                if((time2-time1)/1000>60)
                    System.exit(1);
                notifyAll(); //notifica ceilalti jucatori
            }
            player.setScore(calculateScore());
        }
}
    public int calculateScore(){
        int var=0;
        for(Token token : player.getTokens())
            var+=token.getValue();
        return var;
    }
    public boolean empty(){
        int i,j;
        for(i=0;i<board.length;i++)
            for(j=0;j< board.length;j++)
                if(board[i][j]!=0)
                    return true;
        return false;
    }
}

