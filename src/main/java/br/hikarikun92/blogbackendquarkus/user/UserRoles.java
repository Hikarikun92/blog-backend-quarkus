package br.hikarikun92.blogbackendquarkus.user;

public final class UserRoles {
    private UserRoles() {
        throw new AssertionError();
    }

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
}
