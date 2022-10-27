package pl.damjel.usercrud.servlets;

import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hiddenAddBtn", "hidden");
        HttpSession session = request.getSession();
        User user = null;
        if(session.getAttribute("addUser") != null) {
            System.out.println("Odc att addUser");
            user = (User) session.getAttribute("addUser");
            System.out.println(user.getFirst_name());
            request.setAttribute("user", user);
            session.removeAttribute("addUser");
        }
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserDao userDao = new UserDao();
        user.setFirst_name(request.getParameter("firstName"));
        user.setLast_name(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setZipCode(request.getParameter("zipCode"));
        user.setCity(request.getParameter("city"));
        user.setStreet(request.getParameter("street"));
        user.setStreetNumber(request.getParameter("streetNumber"));
        user.setPass(request.getParameter("password"));
        boolean condition = request.getParameter("password").equals(request.getParameter("repeatPassword"));
        if(condition) {
            userDao.createUser(user);
            response.sendRedirect("/user/list");
        } else {
            HttpSession session = request.getSession();
            System.out.println("Utw att addUser");
            session.setAttribute("addUser", user);
            response.sendRedirect("/user/add");
        }
    }
}
