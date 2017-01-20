package pl.edu.pwr.carrierrental.film.service;

import com.couchbase.client.java.CouchbaseBucket;
import com.couchbase.client.java.query.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.film.repository.MovieRepository;

/**
 * Created by lukasz on 12/8/16.
 */
@Service
public class SerwisFilm {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CouchbaseBucket couchbaseBucket;

    private ModelMapper modelMapper = new ModelMapper();

    public pl.edu.pwr.carrierrental.film.model.entity.Film dodajFilm(Film movieDto){
        pl.edu.pwr.carrierrental.film.model.entity.Film film = modelMapper.map(movieDto, pl.edu.pwr.carrierrental.film.model.entity.Film.class);
        pl.edu.pwr.carrierrental.film.model.entity.Film save = movieRepository.save(film);
        return save;
    }

    public Film znajdzFIlm(String tytul){

        return (movieRepository.findByTytul(tytul));
//        return null;
    }
    public Film getMovieById(int id){
        return movieRepository.findOne(id);
    }
}
