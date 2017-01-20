package pl.edu.pwr.carrierrental.użytkownik.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.carrierrental.użytkownik.model.entity.Uzytkownik;
import pl.edu.pwr.carrierrental.użytkownik.service.SerwisUżytkownik;

/**
 * Created by lukasz on 1/13/17.
 */
@RequestMapping("/uzytkownik")
@RestController
public class UżytkownikKontroler {
    @Autowired
    private SerwisUżytkownik serwisUżytkownik;

    @RequestMapping("/wypozyczUzytkownikowi")
    public Uzytkownik uzytkownik(@RequestBody Uzytkownik uzytkownik) {
        return serwisUżytkownik.dodajUzytkownika(uzytkownik);
    }
}
