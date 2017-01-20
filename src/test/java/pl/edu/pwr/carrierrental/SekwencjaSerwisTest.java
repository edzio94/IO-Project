package pl.edu.pwr.carrierrental;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.film.service.SerwisFilm;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;
import pl.edu.pwr.carrierrental.nośnik.service.SerwisNośnik;
import pl.edu.pwr.carrierrental.użytkownik.model.entity.Uzytkownik;
import pl.edu.pwr.carrierrental.użytkownik.service.SerwisUżytkownik;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by lukasz on 1/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SekwencjaSerwisTest {

    @Autowired
            private SerwisFilm serwisFilm;
    @Autowired
            private SerwisNośnik serwisNośnik;
    @Autowired
            private SerwisUżytkownik serwisUżytkownik;

    Film film  = Film.builder()
            .tytul("test")
            .dataProdukcji(new Date())
            .rezyser("Ja")
            .gatunek("Akcja")
            .build();
    Uzytkownik uzytkownik = Uzytkownik.builder()
            .adres("Adres taki jakis")
            .czyAdmin(false)
            .imie("lukasz")
            .nazwisko("nowacki")
            .login("Edmundo")
            .password("Password")
            .build();
    Nośnik nośnik = Nośnik.builder()
            .film(film)
            .typNosnika("VHS")
            .build();

    @Test
    public void wypozyczFilmUzytkownikowi() {
        Film film = serwisFilm.dodajFilm(this.film);
        Nośnik nośnik = serwisNośnik.dodajNośnik(this.nośnik);
        assertThat(nośnik,equalTo(this.nośnik));
        Uzytkownik uzytkownik = serwisUżytkownik.dodajUzytkownika(this.uzytkownik);
        uzytkownik.setNosniki(Arrays.asList(nośnik));
        assertThat(serwisUżytkownik.sprawdzCzyUzytkownikIstnieje(uzytkownik), equalTo(true));
        serwisUżytkownik.dodajNosnikDoUzytkownika(uzytkownik);
    }
}
