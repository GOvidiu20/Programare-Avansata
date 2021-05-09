package JGraphT;

import SocialNetwork.Retea;
import Users.User;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;


public final class Graph {
    Retea retea;
    public Graph(Retea retea){
        this.retea=retea;
    }
    public void GraphGenerator() throws Exception {

        DefaultDirectedGraph<String, DefaultEdge> g =
                new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

        List<User> users=retea.getUsers();

        for(User user:users) {
            g.addVertex(user.getName());
        }
        for(User user :users)
            for(String name:user.getFriends()){
                g.addEdge(user.getName(),name);
            }
        JGraphXAdapter<String, DefaultEdge> graphAdapter =
                new JGraphXAdapter<String, DefaultEdge>(g);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\labl10\\graph.png");
        ImageIO.write(image, "PNG", imgFile);

    }
}