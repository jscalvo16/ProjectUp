package com.projectup.ServiceImp;

import com.projectup.auth.LandonUserPrincipal;
import com.projectup.beans.User;
import com.projectup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class UserDetailService implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correoUsuario) throws UsernameNotFoundException {
        User user = this.userRepository.findByCorreUser(correoUsuario);
        if(null==user) {
            throw new UsernameNotFoundException("Usuario no encontrado por el correo: " + correoUsuario);
        }
        return new LandonUserPrincipal(user);
    }
}
