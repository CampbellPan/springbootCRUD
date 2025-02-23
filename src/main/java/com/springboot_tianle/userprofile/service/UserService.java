package com.springboot_tianle.userprofile.service;

import com.springboot_tianle.userprofile.pojo.DTO.UserDTO;
import com.springboot_tianle.userprofile.pojo.User;
import com.springboot_tianle.userprofile.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    //通常，一个业务逻辑类都需要新建一个接口，这样可维护性更强。

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(UserDTO user) {
        //调用数据访问类（repository）的方法

        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo); //save()可以返回当前操作的类型“userPojo”
        //*save方法会自动判别我们传进去的user，如果有id就修改，如果没有id就新增
        //*但是我们不能直接把user作为参数传进去，因为它是UserDTO类型的，而CrudRepository指定的是操作User类型
        //*所以我们使用 BeanUtils.copyProperties方法。接受2个参数，第一个参数指定你要拷贝哪个对象，第二参数指定你要黏贴到哪个对象里去
        //*把UserDTO user的数据拷一份给User userpojo


    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(()->{
            throw new IllegalArgumentException("用户不存在");
        });
    }

    @Override
    public User editUser(UserDTO user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }


}
