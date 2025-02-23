package com.springboot_tianle.userprofile.service;

import com.springboot_tianle.userprofile.pojo.DTO.UserDTO;
import com.springboot_tianle.userprofile.pojo.User;

public interface IUserService {
    //通常，一个业务逻辑类都需要新建一个接口，这样可维护性更强。

    /**
     * insert user
     * @param user 需要添加的用户对象
     * @return 添加好的用户对象
     */
    User addUser(UserDTO user);

    /**
     * search user
     * @param userId 需要查询的ID
     * @return 查到的的用户对象
     */
    User getUser(Integer userId);

    /**
     * modify user
     * @param user 需要修改的用户对象
     * @return 修改后的用户对象
     */
    User editUser(UserDTO user);

    /**
     * delete user
     * @param userId 需要删除的ID
     */
    void deleteUser(Integer userId);
}
