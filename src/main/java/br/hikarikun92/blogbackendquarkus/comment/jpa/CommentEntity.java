package br.hikarikun92.blogbackendquarkus.comment.jpa;

import br.hikarikun92.blogbackendquarkus.user.jpa.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Comment")
@Table(name = "comment")
@Data
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @Column(nullable = false, name = "published_date")
    private LocalDateTime publishedDate;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
