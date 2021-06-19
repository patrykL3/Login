package pl.patryklubik.loginsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import pl.patryklubik.loginsecurityjpa.model.MyUserDetails;
import pl.patryklubik.loginsecurityjpa.model.User;

import java.util.Optional;


/**
 * Create by Patryk Łubik on 15.06.2021.
 */

//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    UserRepository userRepository;
//
//    public MyUserDetailsService() {
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUserName(userName);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
//
//        return user.map(MyUserDetails::new).get();
//    }
//}
