import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import Objects.Movie;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import pachetDao.MovieDao;

public class FreeMarker {

    public static void freeMarker() throws Exception {

        Configuration cfg = new Configuration();

        cfg.setClassForTemplateLoading(FreeMarker.class, "templates");

        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Movies");

        List<Movie> systems = new ArrayList<>();
        MovieDao movieDao=new MovieDao();
        systems=movieDao.getAll();
        input.put("systems", systems);
        Template template = cfg.getTemplate("movie.ftl");
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}