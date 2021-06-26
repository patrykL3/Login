package pl.patryklubik.loginsecurityjpa.model;

import java.util.Optional;


/**
 * Create by Patryk Łubik on 15.06.2021.
 */

public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User entity);
    boolean existsByUsername(String username);
}
