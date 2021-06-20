package pl.patryklubik.loginsecurityjpa.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.patryklubik.loginsecurityjpa.security.ApplicationUserPermission.*;


/**
 * Create by Patryk Łubik on 19.06.2021.
 */

public enum ApplicationUserRole {
    STANDARD_USER(Sets.newHashSet(MENU_PAGE)),
    VIP(Sets.newHashSet(VIP_PAGE, MENU_PAGE)),
    ADMIN(Sets.newHashSet(ADMIN_PAGE, VIP_PAGE, MENU_PAGE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    public static ApplicationUserRole getRole(String roleName) {
        ApplicationUserRole applicationUserRole;

        applicationUserRole = Stream.of(ApplicationUserRole.values())
                .filter(checkedRole -> checkedRole.name().equals(roleName))
                .findFirst().get();

        return applicationUserRole;
    }
}
