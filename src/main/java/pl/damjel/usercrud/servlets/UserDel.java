package pl.damjel.usercrud.servlets;

import org.mindrot.jbcrypt.BCrypt;
import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDel", value = "/user/del")
public class UserDel extends HttpServlet {
    private UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hiddenAddBtn", "hidden");
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.readUser(userId);
        request.setAttribute("userEmail", user.getEmail());
        request.setAttribute("userIdToD", user.getId());
        getServletContext().getRequestDispatcher("/users/del.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.valueOf(request.getParameter("userIdToDel"));
        String pass = request.getParameter("password");
        if(userDao.checkPass(userId, pass)) {
            userDao.deleteUser(userId);
            session.removeAttribute("incorrectPass");
            response.sendRedirect("/user/list");
        } else {
            session.setAttribute("incorrectPass", "You entered incorrect user password.");
            response.sendRedirect("/user/del?userId=" + userId);
        }
    }
}
