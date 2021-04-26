package Charts;

import EntiyPack.Movie;
import com.jpa.Singleton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.List;

public class Charturi extends JFrame {

    public Charturi() {

        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {
        EntityManager entityMgr = Singleton.getEntityManager();
        entityMgr.getTransaction().begin();

        List<Movie> lista= (List<Movie>) entityMgr.createNamedQuery("Movie.selectAll")
                .getResultList();
        var dataset = new DefaultCategoryDataset();
        int x=0;
        for(Movie movie:lista){
            x++;
            if(x==30)
                break;
            dataset.setValue(movie.getScore(),movie.getRelease_date(),movie.getTitle());
        }
        entityMgr.clear();
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Movie score",
                "",
                "Score",
                dataset,
                PlotOrientation.HORIZONTAL,
                false, true, false);

        return barChart;
    }

}