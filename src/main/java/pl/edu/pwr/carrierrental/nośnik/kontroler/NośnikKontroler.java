package pl.edu.pwr.carrierrental.nośnik.kontroler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;
import pl.edu.pwr.carrierrental.nośnik.service.SerwisNośnik;

/**
 * Created by lukasz on 1/13/17.
 */
@RestController
@RequestMapping("/nosnik")
public class NośnikKontroler {

    @Autowired
    private SerwisNośnik serwisNośnik;

    @RequestMapping("/dodajNosnik")
    public Nośnik dodajNośnik(@RequestBody Nośnik nośnik) {
        return serwisNośnik.dodajNośnik(nośnik);
    }
    @RequestMapping("usunNosnik")
    public boolean usunNośnik(@RequestBody Nośnik nośnik) {
        return serwisNośnik.usuńNośnik(nośnik);
    }
}
