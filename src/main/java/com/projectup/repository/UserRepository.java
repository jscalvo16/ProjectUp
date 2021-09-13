package com.projectup.repository;

import com.projectup.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsuario(String user);

    @Query("select u from User u where u.corrUsua= :name")
    public User searchByName(@Param("name") String corrUsua);
}
