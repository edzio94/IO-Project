package pl.edu.pwr.carrierrental;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.carrierrental.film.model.entity.Film;
import pl.edu.pwr.carrierrental.film.service.SerwisFilm;

import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by lukasz on 1/20/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class MockBeanServiceTest {
    @MockBean
    private SerwisFilm serwisFilm;

    @Test
    public void mockExampleFIlmSerwistest()
    {
        Film w = Film.builder()
                .dataProdukcji(new Date())
                .gatunek("Nowy")
                .id(2222)
                .rezyser("Ja")
                .build();
        given(this.serwisFilm.znajdzFIlm("test")).willReturn(w);
        assertThat(this.serwisFilm.znajdzFIlm("test")).isEqualTo(w);
    }

}
