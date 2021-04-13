import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private String tactic;
    private int score;
    private List<Token> tokens=new ArrayList<>();

    public Player(String name,String tactic,int id) {
        this.id=id;
        this.name = name;
        this.tactic=tactic;
    }
    public void addToken(Token token){
        tokens.add(token);
    }
    public void showTokens(){
        if(tokens.size()!=0)
            for(Token x : tokens)
                System.out.println( name+" "+x.getFirst()+" "+x.getSecond()+" "+x.getValue());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getTactic() {
        return tactic;
    }
    public void setTactic(String tactic) {
        this.tactic = tactic;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
