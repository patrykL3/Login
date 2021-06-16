package pl.patryklubik.loginsecurityjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryklubik.loginsecurityjpa.model.User;

import java.util.Optional;


/**
 * Create by Patryk Łubik on 15.06.2021.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
