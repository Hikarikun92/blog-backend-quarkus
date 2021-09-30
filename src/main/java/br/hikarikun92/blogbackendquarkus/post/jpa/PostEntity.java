package br.hikarikun92.blogbackendquarkus.post.jpa;

import br.hikarikun92.blogbackendquarkus.comment.jpa.CommentEntity;
import br.hikarikun92.blogbackendquarkus.user.jpa.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Post")
@Table(name = "post")
@Data
@NamedQuery(name = "Post.findById", query = "select p from Post p join fetch p.user u left join fetch p.comments c left join fetch c.user where p.id = :id order by c.id")
@NamedQuery(name = "Post.findByUserId", query = "select p from Post p join fetch p.user u where u.id = :userId")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

    @OneToMany
    @JoinColumn(name = "post_id", nullable = false)
    private Set<CommentEntity> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
