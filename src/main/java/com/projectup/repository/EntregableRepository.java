package com.projectup.repository;

import com.projectup.beans.Entregable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregableRepository extends CrudRepository<Entregable,Integer> {
}
