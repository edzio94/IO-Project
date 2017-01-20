package pl.edu.pwr.carrierrental.użytkownik.model.entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;

import java.util.List;

/**
 * Created by lukasz on 12/7/16.
 */
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Uzytkownik {
    @Id
    private int id;
    @Field
    private String login;
    @Field
    private String password;
    @Field
    private String imie;
    @Field
    private String nazwisko;
    @Field
    private String adres;
    @Field
    private boolean czyAdmin;
    @Field
    private double zapłata;
    @Field
    List<Nośnik> nosniki;

}
