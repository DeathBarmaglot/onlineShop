package com.store.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "name")
    private String name;
    @Column(name = "token")
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User user;

}
