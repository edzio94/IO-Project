package pl.edu.pwr.carrierrental;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;
import pl.edu.pwr.carrierrental.nośnik.service.SerwisNośnik;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Every.everyItem;
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
public class NośnikKontrollerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SerwisNośnik serwisNośnik;
    private MockMvc mockMvc;

    @Rule
    private OutputCapture outputCapture = new OutputCapture();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
    }

    @Test
    public void powinienDodaćNośnik() throws Exception {
        Nośnik nośnik = Nośnik.builder()
                .film(Film.builder()
                        .gatunek("Komedia")
                        .id(123)
                        .rezyser("Lukasz Nowacki")
                        .dataProdukcji(new Date())
                        .tytul("JakisFilm")
                        .build())
                .typNosnika("VHS")
                .build();
        mockMvc.perform(post("/nosnik/dodajNosnik")
        .content(new ObjectMapper().writeValueAsString(nośnik))
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void powinienUsunacNośnik() throws Exception {
        Nośnik nośnik = Nośnik.builder()
                .film(Film.builder()
                        .gatunek("Komedia")
                        .id(123)
                        .rezyser("Lukasz Nowacki")
                        .dataProdukcji(new Date())
                        .tytul("JakisFilm")
                        .build())
                .typNosnika("VHS")
                .build();
        mockMvc.perform(post("/nosnik/dodajNosnik")
                .content(new ObjectMapper().writeValueAsString(nośnik))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/nosnik/usunNosnik")
        .content(new ObjectMapper().writeValueAsString(nośnik))
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void powinienzmodyfikowaćnośnik(){
        String typ="DVD";
        Nośnik nośnik = Nośnik.builder()
                .film(Film.builder()
                        .gatunek("Komedia")
                        .id(123)
                        .rezyser("Lukasz Nowacki")
                        .dataProdukcji(new Date())
                        .tytul("JakisFilm")
                        .build())
                .typNosnika("VHS")
                .build();
        nośnik = serwisNośnik.dodajNośnik(nośnik);
        nośnik.setTypNosnika(typ);
        assertThat(serwisNośnik.dodajNośnik(nośnik).getTypNosnika(), equalToIgnoringCase(typ));

    }

    @Test
    public void containsNumbersInAnyOrder() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));
    }
    @Test
    public void testOutput(){
        System.out.println("Hello World!");
        assertThat(outputCapture.toString(), containsString("World"));

    }

}
