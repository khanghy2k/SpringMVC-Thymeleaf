package com.example.Session12.model;



import javax.validation.constraints.NotEmpty;

/**
 * @NotNull - Kiểm tra giá trị null
 * @NotEmpty - Kiểm tra chuỗi không được trống
 * @Size - Kiểm tra độ dài max , min
 * @Min - Kiểm tra giá trị tối thiểu
 * @Max - Kiểm tra giá trị tối đa
 * @Email - Kiểm tra định dạng email
 * @NotBlank - Kiểm tra không null hoặc khoảng trắng

 */

public class LoginModel {
   @NotEmpty(message = "Tài Khoản Không được để trống")
    private String username;
  @NotEmpty(message = "Mật khẩu không được bỏ trống")
    private String password;

    public LoginModel() {
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
