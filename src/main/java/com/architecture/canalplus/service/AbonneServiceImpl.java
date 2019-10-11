package com.architecture.canalplus.service;

import com.architecture.canalplus.dao.IAbonneRepository;
import com.architecture.canalplus.dao.IContratRepository;
import com.architecture.canalplus.model.Abonne;
import com.architecture.canalplus.model.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AbonneServiceImpl implements IAbonneService {

    @Autowired
    IContratRepository contratRepository;
    @Autowired
    IAbonneRepository abonneRepository;
    @Override
    public Abonne ModifierAdresseAbonne(String newAdresse, String codeAbonne) {
        Optional<Abonne> abonne=this.abonneRepository.findById(codeAbonne);
        if(abonne.isPresent()){
            Abonne abonne1=abonne.get();
            abonne1.setAdresse(newAdresse);
            List<Contrat> contrats=abonne1.getContrats();

            contrats.forEach(contrat -> {
                    contrat.setAdresseAbonne(newAdresse);
                    contratRepository.save(contrat);
            });
            this.abonneRepository.save(abonne1);

        }else{
            throw new RuntimeException("Abonne Introuvable");
        }
        return abonne.get();
    }
}
