package pl.patryklubik.loginsecurityjpa.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patryklubik.loginsecurityjpa.model.User;
import pl.patryklubik.loginsecurityjpa.model.UserRepository;


/**
 * Create by Patryk Łubik on 20.06.2021.
 */

@Repository
interface SqlUserRepository extends UserRepository, JpaRepository<User, Integer> {
}
