package pl.patryklubik.loginsecurityjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import pl.patryklubik.loginsecurityjpa.model.User;
import pl.patryklubik.loginsecurityjpa.logic.MyUserService;

import javax.validation.Valid;

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
    public String createAccount(@ModelAttribute("user") @Valid User toCreate,
    BindingResult bindingResult,
    Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Fill in all fields");
            return "registration";
        }

        try {
            myUserService.save(toCreate);
            return "login";
        } catch (ResponseStatusException e) {
            model.addAttribute("message", e.getReason());
            return "registration";
        }
    }
}
