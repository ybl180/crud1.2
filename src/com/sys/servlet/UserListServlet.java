package com.sys.servlet;

import com.sys.entity.PageBean;
import com.sys.entity.User;
import com.sys.service.UserService;
import org.springframework.util.StringUtils;

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
@WebServlet("/sys/list")
public class UserListServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        PageBean pageBean = new PageBean();
        //获取查询的账号名
        String account = req.getParameter("account");
        account = StringUtils.isEmpty(account) ? "" : account;

        //总记录数
        pageBean.setCount(userService.count(account));

        //总页数
//        Integer pageTotal = count % pageBean.getPageSize() == 0 ? count / pageBean.getPageSize() : count / pageBean.getPageSize() + 1;

        //获取当前页
        String page = req.getParameter("page");
        if (!StringUtils.isEmpty(page)) {
            pageBean.setPage(Integer.valueOf(page));
        }

        List<User> users = userService.findAll(account, pageBean);

        req.setAttribute("users", users);
        req.setAttribute("pageBean", pageBean);
        req.setAttribute("account", account);

        req.getRequestDispatcher("/listUser.jsp").forward(req, resp);
    }
}
