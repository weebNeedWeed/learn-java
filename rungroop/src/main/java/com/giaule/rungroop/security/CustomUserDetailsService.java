package com.giaule.rungroop.security;

import com.giaule.rungroop.models.UserEntity;
import com.giaule.rungroop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        if(userEntity == null) {
            throw new UsernameNotFoundException("User with given username was not found: " + username);
        }

        List<SimpleGrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .toList();

        User user = new User(username,
                userEntity.getPassword(),
                authorities);

        return user;
    }

}
