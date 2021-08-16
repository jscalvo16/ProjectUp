package com.projectup.repository;

import com.projectup.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    //public Long countById(int Id);
}
