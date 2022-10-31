package pl.damjel.usercrud.servlets;

import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/upd")
public class UserEdit extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hiddenAddBtn", "hidden");
        int userId = Integer.valueOf(request.getParameter("userId"));
        User user = userDao.readUser(userId);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        user.setFirst_name(request.getParameter("firstName"));
        user.setLast_name(request.getParameter("lastName"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setZipCode(request.getParameter("zipCode"));
        user.setCity(request.getParameter("city"));
        user.setStreet(request.getParameter("street"));
        user.setStreetNumber(request.getParameter("streetNumber"));
        userDao.updateUser(user);
        response.sendRedirect("/user/list");
    }
}
