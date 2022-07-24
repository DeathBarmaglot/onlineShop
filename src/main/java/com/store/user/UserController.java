package com.store.user;

import com.store.role.Role;
import com.store.role.RoleDto;
import com.store.security.DefaultSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class UserController {

    private final DefaultSecurityService securityService;

//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> getByUsername(
//            @PathVariable(value = "id") Long id) {
//        String token = securityService.getToken(id);
//        if(token == null){
//            redirect("/login");
//        }
//        return;
//    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getByUsers() {

        return ResponseEntity.ok().body(securityService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(securityService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(securityService.saveRole(role));
    }

    @PostMapping("/role/add")
    public ResponseEntity<?> addRole(@RequestBody RoleDto form) {
        securityService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}
