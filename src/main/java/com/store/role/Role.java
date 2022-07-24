package com.store.role;

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
    private Long roleId;
    @Column(name = "name")
    private String name;

    public Role(Long roleId, String name) {
        this.name = name;
        this.roleId = roleId;
    }
}
