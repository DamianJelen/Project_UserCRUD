package pl.damjel.usercrud.servlets;

import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hiddenAddBtn", "hidden");
        int userId = Integer.valueOf(request.getParameter("userId"));
        UserDao userDao = new UserDao();
        User user = userDao.readUser(userId);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
