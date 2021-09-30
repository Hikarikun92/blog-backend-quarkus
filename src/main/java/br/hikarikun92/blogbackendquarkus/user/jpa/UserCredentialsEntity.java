package br.hikarikun92.blogbackendquarkus.user.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "UserCredentials")
@Table(name = "user_credentials")
@Data
@NamedQuery(name = "UserCredentials.findCredentialsByUsername", query = "select c from UserCredentials c join fetch c.user u left join fetch u.roles where u.username = :username")
public class UserCredentialsEntity {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false, name = "user_id")
    @MapsId
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentialsEntity that = (UserCredentialsEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
