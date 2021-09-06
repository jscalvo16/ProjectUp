package com.projectup.repository;

import com.projectup.beans.Fase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRepository extends CrudRepository<Fase,Integer> {
}
