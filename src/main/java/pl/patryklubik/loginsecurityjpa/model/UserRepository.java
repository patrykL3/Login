package pl.patryklubik.loginsecurityjpa.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryklubik.loginsecurityjpa.model.User;

import java.util.Optional;


/**
 * Create by Patryk Łubik on 15.06.2021.
 */

public interface UserRepository {
    Optional<User> findByUsername(String username);

}
