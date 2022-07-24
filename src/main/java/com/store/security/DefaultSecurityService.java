package com.store.security;

import com.store.role.Role;
import com.store.role.RoleRepository;
import com.store.user.User;
import com.store.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultSecurityService implements SecurityService {

//    @Value("${jwt.token.time}")
    long time = 600 * 1000;

    private final Map<Token, User> tokenUserMap = new ConcurrentHashMap<>();
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Token addToStorageToken(User user) {
        Token token = new Token(time);
        tokenUserMap.put(token, user);
        log.info("Adding role {} to user {}", token, user.getUsername());
        return token;
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getNickname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<Token> getToken(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User dbUserDto = optionalUser.get();
            String dbPassword = dbUserDto.getPassword();

            if (passwordEncoder.matches(dbPassword, password + dbUserDto.getHashedSalt())) {
                return Optional.of(createToken(dbUserDto));
            }
        }
        return Optional.of(new Token(time));
    }


    @Override
    public boolean isGranted(Token token, String resource) {
        return isExpired(token) && tokenUserMap.containsKey(token);
    }

    @Override
    public boolean isExpired(Token token) {
        return token.getExpiredTime().isAfter((LocalDateTime.now()));
    }

    private Token createToken(User userDb) {
        Token token = new Token(time);
        tokenUserMap.put(token, userDb);
        return token;
    }

    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username).orElseThrow();
        Role role = roleRepository.findByName(roleName).orElseThrow();
        user.getRoles().add(role);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
// register -> login, password -> hashedPassword =
// MD5(password + HASHED_SALT) -> save(new User(login, hashedPassword))

// login -> password -> user -> findByLogin(login)
// ->  MD5(password).equals(user.getPassword()) -> generateToken();

//value   MD5            SHA 256
//secret  MD5(secret)    SHA 256(secret)
//select * from rainbowTable where md5 == password or sha256 == password