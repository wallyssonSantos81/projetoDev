package dio.me.claro_dev_week_2024.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import dio.me.claro_dev_week_2024.domain.model.User;
import dio.me.claro_dev_week_2024.domain.repository.UserRepository;
import dio.me.claro_dev_week_2024.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
      return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
       return userRepository.save(userToCreate);
    }

}
