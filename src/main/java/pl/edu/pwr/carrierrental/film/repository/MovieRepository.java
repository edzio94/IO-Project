package pl.edu.pwr.carrierrental.film.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.carrierrental.film.model.entity.Film;

/**
 * Created by lukasz on 12/8/16.
 */
@Repository
public interface MovieRepository extends CrudRepository<Film,Integer> {
//    @View(viewName = "byTitle",designDocument = "dev_movie")
    Film findByTytul(String tytul);
}
