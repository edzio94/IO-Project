package pl.edu.pwr.carrierrental.film.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.film.service.SerwisFilm;

/**
 * Created by lukasz on 1/12/17.
 */
@RestController
@RequestMapping("/film")
public class FilmKontroler {

    @Autowired
    private SerwisFilm serwisFilm;

    @RequestMapping("/dodajFilm")
    public Film dodajFilm(@RequestBody Film film) {
        return serwisFilm.dodajFilm(film);
    }

}
