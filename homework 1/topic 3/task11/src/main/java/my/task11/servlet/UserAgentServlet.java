package my.task11.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();

        String useragent = req.getHeader("User-Agent");
        out.println("<h1>Hello user of " + getBrowserName(useragent) + " browser</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    static String getBrowserName(String useragent) {
        final String regex = "Mozilla\\/5\\.0 \\(.*?\\) .*?\\/[0-9.]*? (\\(KHTML, like Gecko\\) (Version\\/.*? ){0,1}){0,1}(.*?)/";

        if (useragent.contains(" Edg/")) {
            return "Edge";
        }
        if (useragent.contains(" OPR/")) {
            return "Opera";
        }
        if (useragent.contains(" Vivaldi/")) {
            return "Vivaldi";
        }

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(useragent);

        if (matcher.find()) {
            return matcher.group(3);
        } else {
            return "Unknown";
        }
    }
}
