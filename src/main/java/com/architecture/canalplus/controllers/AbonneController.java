package com.architecture.canalplus.controllers;

import com.architecture.canalplus.model.Abonne;
import com.architecture.canalplus.service.IAbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Abonne")
public class AbonneController {
    @Autowired
    IAbonneService abonneService;
    @PutMapping("/ModifierAdresse")
    public ResponseEntity<Abonne> ModifierAdresse(String idAbonne,String adresse) {
        Abonne abonne=abonneService.ModifierAdresseAbonne(adresse,idAbonne);
        return new ResponseEntity<>(abonne, HttpStatus.OK);
    }
}