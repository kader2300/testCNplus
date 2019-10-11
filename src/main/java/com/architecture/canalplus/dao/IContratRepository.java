package com.architecture.canalplus.dao;

import com.architecture.canalplus.model.Contrat;
import org.springframework.data.repository.CrudRepository;

public interface IContratRepository extends CrudRepository<Contrat, String> {
}
