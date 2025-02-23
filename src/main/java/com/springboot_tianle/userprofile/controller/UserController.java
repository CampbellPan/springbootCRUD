package com.springboot_tianle.userprofile.controller;

import com.springboot_tianle.userprofile.pojo.DTO.UserDTO;
import com.springboot_tianle.userprofile.pojo.ResponseMessage;
import com.springboot_tianle.userprofile.pojo.User;
import com.springboot_tianle.userprofile.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@RestController可以让接口方法返回对象 转成json文本
//@RequestMapping
@RestController
@RequestMapping("/user") //localhost:80800/user
public class UserController {

    @Autowired
    IUserService userService;

    //add
    @PostMapping //localhost:8080/user  method:POST
    public ResponseMessage<User> add(@Validated @RequestBody UserDTO user){
        //*传进来的参数，由于规范的关系，一般需要新建一个UserDTO类。因为传入的参数不一定是User类的全部属性。
        //*如果你使用了spring-boot-starter-validator的注解，你需要加上@Validated来让限制生效
        //@Requestbody代表传进来的会是一个json文本，这个注解会自动帮我们转成对象
        User userNew = userService.addUser(user);
        System.out.println("New user ID: " + userNew.getUserId()); // 检查 ID 是否生成
        return ResponseMessage.success(userNew);
    }
    //!注意：8080是Tomcat（HTTP 服务器）的常用端口，所以你应该访问localhost:8080/user


    //query
    @GetMapping("/{userId}") //localhost:8080/user/1 method:GET
    public ResponseMessage<User> add(@PathVariable Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }
    //modify
    @PutMapping
    public ResponseMessage edit(@Validated @RequestBody UserDTO user){
        User userNew = userService.editUser(user);
        return ResponseMessage.success(userNew);
    }
    //delete
    @DeleteMapping ("/{userId}")
    public ResponseMessage<User> delete(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMessage.success();
    }
}
