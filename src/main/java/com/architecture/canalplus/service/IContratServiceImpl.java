package com.architecture.canalplus.service;

import com.architecture.canalplus.dao.IContratRepository;
import com.architecture.canalplus.model.Abonne;
import com.architecture.canalplus.model.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IContratServiceImpl implements IContratService {
    @Autowired
    IContratRepository iContratRepository;
    @Override
    public List<Contrat> modifierAdressDansTousContrat(Abonne abonne,String newAdresse) {
        abonne.getContrats().forEach(contrat -> {
            contrat.setAdresseAbonne(newAdresse);
            iContratRepository.save(contrat);
        });
        return abonne.getContrats();
    }
}
