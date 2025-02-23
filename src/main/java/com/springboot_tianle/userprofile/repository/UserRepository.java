package com.springboot_tianle.userprofile.repository;

import com.springboot_tianle.userprofile.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    //对应的增删改查方法是不需要自己去实现的，所以数据访问层的这些类应该是接口
    //CrudRepository的泛型有两个，第一个是我们要去操作哪个pojo类（那就是User)，第二个是主键Id是什么类型（Integer）

    /*
    TIP: CrudRepository 是 Spring Data JPA 提供的一个通用接口，
    它可以让你无需手写 SQL 或数据库操作代码，就可以直接执行 增、删、改、查 操作。

    save(S entity)	    保存（新增或更新）数据	userRepository.save(new User("Alice", "alice@email.com"));
    findById(ID id)	    按 ID 查找数据	    Optional<User> user = userRepository.findById(1);
    existsById(ID id)	检查 ID 是否存在	    boolean exists = userRepository.existsById(1);
    findAll()	        查询所有记录	        List<User> users = (List<User>) userRepository.findAll();
    count()	            获取数据表总记录数	    long count = userRepository.count();
    deleteById(ID id)	按 ID 删除	        userRepository.deleteById(1);
    delete(T entity)	删除一个对象	        userRepository.delete(user);
    deleteAll()	        删除所有数据	        userRepository.deleteAll();

     JpaRepository 继承自 CrudRepository，并额外提供了 分页、批量操作.
     它支持 findAll(Pageable pageable)，可以分页查询：Page<User> users = userRepository.findAll(PageRequest.of(0, 10));
    它支持 flush()，可以批量操作：
    userRepository.saveAll(users);
    userRepository.flush();

    除了 CrudRepository 提供的方法，你还可以自定义查询方法：

    public interface UserRepository extends JpaRepository<User, Integer> {
        // 根据用户名查找
        List<User> findByUserName(String userName);

        // 查询邮箱包含某个关键字的用户
        List<User> findByEmailContaining(String keyword);
    }
    然后你就可以直接用：

    List<User> users = userRepository.findByUserName("Alice");
    List<User> filteredUsers = userRepository.findByEmailContaining("@gmail.com");
    Spring Data JPA 会自动解析方法名 并生成 SQL，不用写 @Query 语句，非常方便！
     */
}
