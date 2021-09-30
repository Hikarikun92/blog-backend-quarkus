package br.hikarikun92.blogbackendquarkus.factory;

import br.hikarikun92.blogbackendquarkus.user.User;

public final class UserFactory {
    private UserFactory() {
        throw new AssertionError();
    }

    public static final User USER_1 = new User(1, "Administrator");
    public static final User USER_2 = new User(2, "John Doe");
    public static final User USER_3 = new User(3, "Mary Doe");
}
