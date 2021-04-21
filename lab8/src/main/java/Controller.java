import Objects.Movie;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pachetDao.MovieDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;

public class Controller {
    public static LocalDate date(String data){
        data=data.substring(0,4);
        LocalDate date=null;
        String x=data+"-01"+"-01";
        date=LocalDate.parse(x);
        return date;
    }
    public static void read() throws IOException {
        File excelFile = new File("C:\\Users\\Ovidiu Gabor\\Desktop\\IMDb-movies.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIt = sheet.iterator();
        int x=0;
        Row row = rowIt.next();
        while(rowIt.hasNext() && x<3) {
            row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            int i=0;
            Movie movie =new Movie();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (i) {
                    case 1: {
                        movie.setTitle(cell.toString());
                        break;
                    }
                    case 3: {
                        movie.setRelease_date(date(cell.toString()));
                        break;
                    }
                    case 6: {
                        movie.setDuration((int)Double.parseDouble(cell.toString()));
                        break;
                    }
                    case 14: {
                        if(cell.toString().length()>=4)
                            movie.setScore(5);
                        else
                            movie.setScore((int)Double.parseDouble(cell.toString()));
                        break;
                    }
                }
                i++;
            }
            MovieDao movieDao = new MovieDao();
            try {
                movieDao.insert(movie);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            x++;
        }

        fis.close();
    }
}