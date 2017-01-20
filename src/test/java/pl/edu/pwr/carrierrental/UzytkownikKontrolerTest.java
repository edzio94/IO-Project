package pl.edu.pwr.carrierrental;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;
import pl.edu.pwr.carrierrental.użytkownik.model.entity.Uzytkownik;
import pl.edu.pwr.carrierrental.użytkownik.service.SerwisUżytkownik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lukasz on 1/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UzytkownikKontrolerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SerwisUżytkownik serwisUżytkownik;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
    }

    @Test
    public void PowinienDodacUzytkownika() throws Exception {
        Uzytkownik uzytkownik = Uzytkownik.builder()
                .adres("Adres taki jakis")
                .czyAdmin(false)
                .imie("lukasz")
                .nazwisko("nowacki")
                .login("Edmundo")
                .password("Password")
                .zapłata(123.3)
                .nosniki(Arrays.asList(Nośnik.builder()
                        .film(Film.builder()
                                .gatunek("Komedia")
                                .id(123)
                                .rezyser("Lukasz Nowacki")
                                .dataProdukcji(new Date())
                                .tytul("JakisFilm")
                                .build())
                        .typNosnika("VHS")
                        .build()))
                .build();
        mockMvc.perform(post("/uzytkownik/wypozyczUzytkownikowi")
        .content(new ObjectMapper().writeValueAsString(uzytkownik))
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void powinienUsunacUzytkownika() {
        Uzytkownik uzytkownik = Uzytkownik.builder()
                .adres("Adres taki jakis")
                .czyAdmin(false)
                .imie("lukasz")
                .nazwisko("nowacki")
                .login("Edmundo")
                .password("Password")
                .build();
        Uzytkownik uzytkownik1 = serwisUżytkownik.dodajUzytkownika(uzytkownik);
        boolean b = serwisUżytkownik.sprawdzCzyUzytkownikIstnieje(uzytkownik);
        assertThat(b, equalTo(true));
        assertThat(uzytkownik1.getAdres(), equalToIgnoringCase(uzytkownik.getAdres()));
        serwisUżytkownik.usunUzytkownika(uzytkownik1);
        assertThat(serwisUżytkownik.sprawdzCzyUzytkownikIstnieje(uzytkownik1), equalTo(false));
    }


}
