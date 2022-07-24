package com.store.user;

import com.store.review.Review;
import com.store.role.Role;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long uuId;
    @Nullable
    @Column(name = "username")
    private String username;
    @Nullable
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "hashed_salt")
    private int hashedSalt;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<Role> roles = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Review> reviews;

    public User(Long id, String username, String nickname, String email, String password, Collection<Role> roles) {
        this.uuId = id;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.hashedSalt = UUID.randomUUID().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return !(user.getUuId() == null || this.getUuId() == null)
                && Objects.equals(this.getUuId(), user.getUuId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getUuId());
    }
}
