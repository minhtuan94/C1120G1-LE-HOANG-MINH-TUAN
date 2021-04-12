package com.example.cookie.controller;

import com.example.cookie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
// được sử dụng để lưu trữ thông tin của model attribute có tên là user.
@SessionAttributes("user")
public class LoginController {

    /*nhận user trả về từ view, sau đó đưa vào session*/
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/")
    public String Index(@CookieValue(name = "setUser", defaultValue = "") String setUserValue, Model model) {
        Cookie cookie = new Cookie("setUser", setUserValue);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUserValue,
                          HttpServletResponse response, HttpServletRequest request) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
//                setUserValue = user.getEmail();

            // tạo cookie and set it in response
            Cookie cookie = new Cookie("setUser", user.getEmail());
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Đăng nhập thành công. Chào mừng ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUserValue);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Đăng nhập thất bại, thử lại.");
        }
        return "login";
    }
}