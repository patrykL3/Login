package pl.patryklubik.loginsecurityjpa.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.patryklubik.loginsecurityjpa.model.UserRepository;
import pl.patryklubik.loginsecurityjpa.model.MyUserDetails;
import pl.patryklubik.loginsecurityjpa.model.User;

import java.util.Optional;


/**
 * Create by Patryk Łubik on 20.06.2021.
 */

@Service
public class MyUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
