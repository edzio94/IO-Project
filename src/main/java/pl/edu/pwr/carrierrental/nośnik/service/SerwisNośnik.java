package pl.edu.pwr.carrierrental.nośnik.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.carrierrental.nośnik.model.entity.Nośnik;
import pl.edu.pwr.carrierrental.nośnik.repository.CarrierRepository;

import java.util.List;

/**
 * Created by lukasz on 12/8/16.
 */
@Service
public class SerwisNośnik {
    @Autowired
    private CarrierRepository carrierRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Nośnik dodajNośnik(Nośnik nośnik){
        return  carrierRepository.save(nośnik);
    }

    public boolean usuńNośnik(Nośnik nośnik)
    {
        carrierRepository.delete(nośnik);
        return true;
    }

}
