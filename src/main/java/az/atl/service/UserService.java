package az.atl.service;

import az.atl.entity.User;
import az.atl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;


    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();

    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User updateUser(Long id, User user){
    User updateUser = User.builder()
            .id(id)
            .email(user.getEmail())
            .username(user.getUsername())
            .build();

        final User savedUser = userRepository.save(updateUser);


        return User.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }
}
