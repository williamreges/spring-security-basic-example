package com.example.springsecurityexample.sts.service;

import com.example.springsecurityexample.sts.repository.Roles;
import com.example.springsecurityexample.sts.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserNameService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usersRepository.findByUserName(username);

        return Optional.ofNullable(user)
                .map(users -> new User(users.getUserName(), users.getPassword(), getGrantyAuthorization(users.getRoles())))
                .orElse(null);

    }

    private Collection<? extends GrantedAuthority> getGrantyAuthorization(List<Roles> roles) {
        return roles.stream()
                .map(roles1 -> new SimpleGrantedAuthority(roles1.getDescRole()))
                .collect(Collectors.toSet());
    }
}
