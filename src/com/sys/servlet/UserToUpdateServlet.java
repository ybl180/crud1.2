package com.sys.servlet;

import com.sys.entity.User;
import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/26 17:20
 * @desciption
 */
@WebServlet("/sys/toUpdate")
public class UserToUpdateServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        User user = userService.getUserById(Integer.valueOf(id));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/toUpdateUser.jsp").forward(req,resp);
    }
}
