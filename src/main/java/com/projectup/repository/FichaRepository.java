package com.projectup.repository;

import com.projectup.beans.Ficha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends CrudRepository<Ficha, Integer> {

}
