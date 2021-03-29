import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Token> tokens=new ArrayList<>();

    public Player(String name) {
        this.name = name;
        this.tokens = tokens;
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
}
