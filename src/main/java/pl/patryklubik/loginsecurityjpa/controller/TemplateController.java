package pl.patryklubik.loginsecurityjpa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by Patryk Łubik on 15.06.2021.
 */

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("")
    public String redirect() {
        return "menu";
    }

    @GetMapping("login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("menu")
    public String getMenu() {
        return "menu";
    }

    @GetMapping("vip")
    @PreAuthorize("hasAuthority('vip_page')")
    public String getVip() {
        return "vip";
    }

    @GetMapping("admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String getAdmin() {
        return "admin";
    }
}