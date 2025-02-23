package com.springboot_tianle.userprofile.pojo.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserDTO {
    private Integer userId;
    //使用spring-boot-starter-validation的依赖来验证用户上传的参数，比如判断是否为空
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12)
    private String password;
    @Email(message = "邮箱格式不正确")
    private String email;


    /**
     * 注解	        适用于	        能否为 null	    能否是空字符串 ""	    能否是空集合 []
     * @NotNull     任何对象类型      ❌ 不能为 null	✅ 可以是 "" 空字符串	✅ 可以是 [] 空集合
     * @NotEmpty    字符串、集合、数组	❌ 不能为 null	❌ 不能是 "" 空字符串	❌ 不能是 [] 空集合
     * @NotBlank    仅限 String	    ❌ 不能为 null	❌ 不能是 "" 空字符串	✅ 不适用于集合
     *
     * 其他常见校验注解
     * 注解	            作用	示例
     * @Min(value)      最小值                     @Min(18) private Integer age;
     * @Max(value)      最大值                     @Max(60) private Integer age;
     * @Size(min, max)	字符串、集合、数组的长度范围	@Size(min = 3, max = 10) private String userName;
     * @Pattern(regexp) 字符串正则校验             @Pattern(regexp = "^[a-zA-Z0-9]+$") private String userName;
     * @Email           必须是合法邮箱             @Email private String email;
     * @Positive        必须是正数                   @Positive private Integer quantity;
     * @Negative        必须是负数                @Negative private Integer balance;
     * @Future          必须是未来时间             @Future private LocalDate appointmentDate;
     * @Past            必须是过去时间             @Past private LocalDate birthday;
     *
     * password 属性除了 @Length（@Size）以外，还可以使用 多个约束 来增强密码的安全性
     * 比如：@Pattern(regexp)	自定义密码规则（必须包含字母+数字+特殊字符）	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
     * @return
     */


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
