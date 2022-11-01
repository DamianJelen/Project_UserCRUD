package pl.damjel.usercrud.servlets;

import pl.damjel.usercrud.users.User;
import pl.damjel.usercrud.users.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserChangePass", value = "/user/chpa")
public class UserChangePass extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("hiddenAddBtn", "hidden");
        int userId = Integer.valueOf(request.getParameter("userId"));
        session.setAttribute("userId", userId);
        getServletContext().getRequestDispatcher("/users/changePass.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.valueOf(String.valueOf(session.getAttribute("userId")));
        session.removeAttribute("userId");
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String repPass = request.getParameter("repPass");

        if (oldPass.equals(newPass)) {
            session.setAttribute("incorrectPass","You cannot save a new password like you had before");
            response.sendRedirect("/user/chpa?userId=" + userId);
        } else if (!newPass.equals(repPass)) {
            session.setAttribute("incorrectPass","The new password is different from the repeated");
            response.sendRedirect("/user/chpa?userId=" + userId);
        } else if(!userDao.updateUserPass(userId, oldPass, newPass)) {
            session.setAttribute("incorrectPass", "The old password is incorrect");
            response.sendRedirect("/user/chpa?userId=" + userId);
        } else {
            session.removeAttribute("incorrectPass");
            response.sendRedirect("/user/list");
        }
    }
}
