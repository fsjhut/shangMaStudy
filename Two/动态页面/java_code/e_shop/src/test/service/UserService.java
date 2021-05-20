package test.service;

import test.entity.User;

import java.util.List;

public interface UserService {

    Integer insertUser(User insertUser);
    User login(User loginUser);
    List<User> getAllUser();
    boolean existsUsername(String username);

}
