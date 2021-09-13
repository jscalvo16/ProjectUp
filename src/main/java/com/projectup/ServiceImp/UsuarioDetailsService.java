package com.projectup.ServiceImp;

import java.util.HashSet;
import java.util.Set;

import com.projectup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("usuarioDetailsService")
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String CorrUsua) throws UsernameNotFoundException {
        com.projectup.beans.User user = userRepository.findByUsuario(CorrUsua);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRol().getTipoRol()));
        return new User(CorrUsua, user.getContraUsua(), authorities);
    }

}