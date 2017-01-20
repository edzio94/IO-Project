package pl.edu.pwr.carrierrental.nośnik.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;

import java.util.List;

/**
 * Created by lukasz on 12/8/16.
 */
@Repository
public interface CarrierRepository extends CrudRepository<Nośnik,Integer> {
    List<Nośnik> findByTypNosnika(String typNosnika);
}
