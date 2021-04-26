package EntiyPack;

import javax.persistence.*;

@Entity
@Table(name="movies")
@NamedQueries({
        @NamedQuery(name = "Movie.selectAll",
                query = "SELECT m FROM Movie m where m.score<11 and m.score>0 order by m.score desc")
})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "duration")
    private int duration;

    @Column(name = "score")
    private int score;
    public Movie(){}
    public Movie(int id, String title, String release_date, int duration, int score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}