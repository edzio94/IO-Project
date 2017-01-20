package pl.edu.pwr.carrierrental.nośnik.model.entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import pl.edu.pwr.carrierrental.film.model.entity.Film;

/**
 * Created by lukasz on 12/8/16.
 */
@Document
@Getter
@Setter
@Builder
public class Nośnik {
    @Id
    private int id;
    @Field
    private String typNosnika;
    @Field
    private Film film;

    public Nośnik() {
    }

    public Nośnik(int id, String typNosnika, Film film) {
        this.id = id;
        this.typNosnika = typNosnika;
        this.film = film;
    }
}
