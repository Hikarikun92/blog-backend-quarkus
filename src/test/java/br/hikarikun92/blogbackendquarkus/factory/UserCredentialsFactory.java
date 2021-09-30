package br.hikarikun92.blogbackendquarkus.factory;

import br.hikarikun92.blogbackendquarkus.user.UserCredentials;

import java.util.Set;

import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.*;
import static br.hikarikun92.blogbackendquarkus.user.UserRoles.ROLE_ADMIN;
import static br.hikarikun92.blogbackendquarkus.user.UserRoles.ROLE_USER;

public final class UserCredentialsFactory {
    private UserCredentialsFactory() {
        throw new AssertionError();
    }

    public static final UserCredentials USER_CREDENTIALS_1 = new UserCredentials(USER_1, "$2a$10$2KOuXO8SUQGSsWhbDrAQoet9Ts8yJ4y853WYVHF0C3Y2Lv1YNacHS", Set.of(ROLE_ADMIN, ROLE_USER));
    public static final UserCredentials USER_CREDENTIALS_2 = new UserCredentials(USER_2, "$2a$10$bS.HuGI.l5pFEjfjDIjB2.3t9h62kRSi3exUTBhbs6vqrJouNTDh2", Set.of(ROLE_USER));
    public static final UserCredentials USER_CREDENTIALS_3 = new UserCredentials(USER_3, "$2a$10$0K6JAr2YTe82YWid8dPNKeNQ3q73HVH4viQbAq.j.Z6pv3XItAO46", Set.of());
}
