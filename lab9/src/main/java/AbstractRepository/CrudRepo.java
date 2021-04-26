package AbstractRepository;

import EntiyPack.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepo extends CrudRepository<Movie, Long> {
}