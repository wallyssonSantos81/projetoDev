package dio.me.claro_dev_week_2024.service;

import dio.me.claro_dev_week_2024.domain.model.User;

public interface UserService {

    User findById(Long id);
    
    User create(User userToCreate);

}
