package my.task10.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo userInfo = new UserInfo();

        userInfo.setName(req.getParameter("pname"));
        userInfo.setPhone(req.getParameter("pphone"));
        userInfo.setEmail(req.getParameter("pemail"));

        final boolean hasName = userInfo.getName().length() > 0;
        final boolean hasPhone = userInfo.getPhone().length() > 0;
        final boolean hasEmail = userInfo.getEmail().length() > 0;

        String error = "";

        if (!hasName) {
            error = "You have to enter your name! ";
        }
        if (!hasPhone && !hasEmail) {
            error += "You have to enter phone or number!";
        }

        if (error.length() > 0) {
            req.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/jsp/inputError.jsp").forward(req, resp);
        } else {
            req.setAttribute("userInfo", userInfo);
            getServletContext().getRequestDispatcher("/jsp/inputResult.jsp").forward(req, resp);
        }
    }
}
