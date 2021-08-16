package com.projectup.Service;

import com.projectup.beans.User;
import com.projectup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository rep;

    public List<User> listAll(){
        return (List<User>) rep.findAll();
    }

    public User save(User user) {

        return rep.save(user);
    }

   /* public User get(int IdUsua) throws UserNotFoundException {
        Optional<User> result = rep.findById(IdUsua);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("No se pudo encotrar usuario por su ID" + IdUsua);
    }

    public void delete(int Id) throws UserNotFoundException {
        Long count = rep.countById(Id);
        if(count == null || count == 0){
            throw new UserNotFoundException("No se pudo encotrar usuario por su ID" + Id);
        }
        rep.deleteById(Id);

    }*/
}
