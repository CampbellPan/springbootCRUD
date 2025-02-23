package com.springboot_tianle.userprofile.service;

import com.springboot_tianle.userprofile.pojo.DTO.UserDTO;
import com.springboot_tianle.userprofile.pojo.User;

public interface IUserService {
    //通常，一个业务逻辑类都需要新建一个接口，这样可维护性更强。

    /**
     * insert user
     * @param user
     */
    User add(UserDTO user);

    /**
     * search user
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * modify user
     * @param user
     * @return
     */
    User editUser(UserDTO user);

    /**
     * delete user
     * @param userId
     * @return
     */
    void deleteUser(Integer userId);
}
