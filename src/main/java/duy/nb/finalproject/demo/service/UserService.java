package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.authentication.CustomUserDetails;
import duy.nb.finalproject.demo.entities.User;
import duy.nb.finalproject.demo.exception.DuplicateException;
import duy.nb.finalproject.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(user);
    }

    public User getUserInfo(int id){
        return userRepository.findById(id);
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
//    }
    public User signUp(User user){
        User findUser =userRepository.findByUsername(user.getUsername());
        if (findUser!=null){
            throw new DuplicateException("Phone number has been used!");
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

}
