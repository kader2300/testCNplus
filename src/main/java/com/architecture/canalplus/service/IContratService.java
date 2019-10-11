package com.architecture.canalplus.service;

import com.architecture.canalplus.model.Abonne;
import com.architecture.canalplus.model.Contrat;

import java.util.List;

public interface IContratService {
    public List<Contrat> modifierAdressDansTousContrat(Abonne abonne,String newAdresse);
}
