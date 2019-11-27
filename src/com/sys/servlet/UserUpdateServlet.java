package com.sys.servlet;

import com.sys.entity.User;
import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/26 17:20
 * @desciption
 */
@WebServlet("/sys/update")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String id = req.getParameter("id");
        String birthDate = req.getParameter("birthDate");
        User user=new User();
        user.setAccount(account);
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        user.setSex(Integer.valueOf(sex));
        user.setId(Integer.valueOf(id));
        user.setBirthDate(birthDate);

        userService.updateUser(user);

        resp.sendRedirect("/sys/list");
    }
}
