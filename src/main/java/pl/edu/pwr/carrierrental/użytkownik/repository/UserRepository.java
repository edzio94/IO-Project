package pl.edu.pwr.carrierrental.użytkownik.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pwr.carrierrental.użytkownik.model.entity.Uzytkownik;

/**
 * Created by lukasz on 12/8/16.
 */
public interface UserRepository extends CrudRepository<Uzytkownik,Integer> {
}
