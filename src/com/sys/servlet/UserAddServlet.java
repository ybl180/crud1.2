package com.sys.servlet;

import com.sys.entity.User;
import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/26 17:20
 * @desciption
 */
@WebServlet("/sys/add")
public class UserAddServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String birthDate = req.getParameter("birthDate");

        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(date);

        User user=new User();
        user.setAccount(account);
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        user.setSex(Integer.valueOf(sex));
        user.setBirthDate(birthDate);
        user.setCreateTime(createTime);

        userService.addUser(user);
        resp.sendRedirect("/sys/list");
    }
}
