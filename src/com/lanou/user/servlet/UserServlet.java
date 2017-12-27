package com.lanou.user.servlet;

import com.lanou.commons.CommonUtils;
import com.lanou.user.domian.User;
import com.lanou.user.service.impl.UserServiceImpl;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserServiceImpl service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method) {
            case "regist":
                regist(request, response);
                break;
            case "login":
                login(request,response);
                break;
        }
    }


    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = CommonUtils.toBean(request.getParameterMap(), User.class);
        boolean flag = service.regist(user);
        if (flag) {
            request.setAttribute("msg", "注册成功");
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "注册失败");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = service.login(username, password);
        if (users.size() != 0) {
            HttpSession session = request.getSession();
            request.setAttribute("msg", "登录成功");
            session.setAttribute("username", username);
            request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "登录失败");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);

        }
    }
}
