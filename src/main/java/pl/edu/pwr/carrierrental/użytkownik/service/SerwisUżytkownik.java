package pl.edu.pwr.carrierrental.użytkownik.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carrierrental.użytkownik.model.entity.Uzytkownik;
import pl.edu.pwr.carrierrental.użytkownik.repository.UserRepository;

/**
 * Created by lukasz on 12/8/16.
 */
@Service
public class SerwisUżytkownik {

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public Uzytkownik dodajUzytkownika(Uzytkownik uzytkownik) {
        Uzytkownik save = userRepository.save(uzytkownik);
        return save;
    }
    public void usunUzytkownika(Uzytkownik uzytkownik) {
        userRepository.delete(uzytkownik);
    }
    public Uzytkownik znajdzUzytkownika(Uzytkownik uzytkownik) {
        return userRepository.findOne(uzytkownik.getId());
    }
    public boolean sprawdzCzyUzytkownikIstnieje(Uzytkownik uzytkownik) {
        return znajdzUzytkownika(uzytkownik) == null ? false : true;
    }
    public Uzytkownik dodajNosnikDoUzytkownika(Uzytkownik uzytkownik) {
        return userRepository.save(uzytkownik);
    }
}
