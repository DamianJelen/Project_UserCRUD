package pl.damjel.usercrud.servlets;

import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersList", value = "/user/list")
public class UsersList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> users = userDao.readUsers();
        request.setAttribute("users", users);
//        User user = userDao.readUser(100);
//        request.setAttribute("user", user);
        request.getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
