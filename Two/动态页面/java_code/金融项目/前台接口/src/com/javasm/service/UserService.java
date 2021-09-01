package com.javasm.service;

import com.javasm.entity.Suggestion;
import com.javasm.entity.User;

/**
 * @author:sunhang
 * @className: UserService
 * @description:
 * @date: 2021-06-02 10:05
 * @version:0.1
 * @since: 1.8
 */
public interface UserService {
    User queryOneById(String uid);

    int updateUser(User user);

    int userIdea(Suggestion suggestion);
}
