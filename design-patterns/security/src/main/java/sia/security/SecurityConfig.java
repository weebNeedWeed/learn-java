package sia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
//        List<UserDetails> userDetailsList = new ArrayList<>();
//        userDetailsList.add(new User("buzz",
//                passwordEncoder.encode("password"),
//                List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        userDetailsList.add(new User("woody",
//                passwordEncoder.encode("password"),
//                List.of(new SimpleGrantedAuthority("ROLE_USER"))));
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException("User " + username + " was not found");
            }

            return user;
        };
    }
}
