package pl.patryklubik.loginsecurityjpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patryklubik.loginsecurityjpa.model.User;
import pl.patryklubik.loginsecurityjpa.security.MyUserService;

import javax.validation.Valid;
import java.net.URI;


/**
 * Create by Patryk Łubik on 24.06.2021.
 */

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final MyUserService myUserService;

    public RegistrationController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @PostMapping
    public ResponseEntity<User> createAccount(@RequestBody @Valid User toCreate) {

        User result = myUserService.save(toCreate);

        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
