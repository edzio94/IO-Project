package pl.edu.pwr.carrierrental.film.model.entity;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;


/**
 * Created by lukasz on 12/7/16.
 */
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Film {
    @Id
    private int id;
    @Field
    private String tytul;
    @Field
    private Date dataProdukcji;
    @Field
    private String rezyser;
    @Field
    private String gatunek;

}
