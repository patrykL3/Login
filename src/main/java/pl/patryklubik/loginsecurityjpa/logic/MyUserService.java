package pl.patryklubik.loginsecurityjpa.logic;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.patryklubik.loginsecurityjpa.model.UserRepository;
import pl.patryklubik.loginsecurityjpa.model.MyUserDetails;
import pl.patryklubik.loginsecurityjpa.model.User;

import java.util.Optional;

import static pl.patryklubik.loginsecurityjpa.security.ApplicationUserRole.STANDARD_USER;


/**
 * Create by Patryk Łubik on 20.06.2021.
 */

@Service
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MyUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }

    public User save(User toCreate) {

        if(userRepository.existsByUsername(toCreate.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is taken");
        }

        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
        toCreate.setActive(true);
        toCreate.setRole(STANDARD_USER.name());

        return userRepository.save(toCreate);
    }
}
