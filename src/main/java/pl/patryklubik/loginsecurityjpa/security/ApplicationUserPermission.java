package pl.patryklubik.loginsecurityjpa.security;

/**
 * Create by Patryk Łubik on 19.06.2021.
 */

public enum ApplicationUserPermission {
    MENU_PAGE("menu_page"),
    VIP_PAGE("vip_page"),
    ADMIN_PAGE("admin_page");
    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}