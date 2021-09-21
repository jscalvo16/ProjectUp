package com.projectup.repository;

import com.projectup.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("ALL")
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByCorreUser(String correo);
}
