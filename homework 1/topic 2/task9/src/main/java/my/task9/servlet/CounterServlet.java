package my.task9.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private long counter = 0;

    @Override
    public void destroy() {
        super.destroy();
        saveCounterToFile(counter);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        counter = loadCounterFromFIle();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();

        counter++;

        out.println("<html><head><title>Counter Servlet</title></head>");
        out.println("<body><h1>Page visited " + counter + " times</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String getUserDir() {
        String userDir = System.getenv("USERPROFILE");
        if (userDir == null) {
            userDir = ""; // Can't find env variable, using current dir
        }
        return userDir;
    }

    /**
     * Saves counter to file
     * @param counter value
     */
    private void saveCounterToFile(long counter) {
        String path = getUserDir() + File.separator + "counter.data";
        System.out.println(path);
        try {
            Files.writeString(Paths.get(path), String.valueOf(counter));
        } catch (IOException e) {
        }
    }

    /**
     * Loads counter from file
     * @return counter read from file or 0 on error
     */
    private long loadCounterFromFIle() {
        long counterInFile = 0;
        String path = getUserDir() + File.separator + "counter.data";

        try {
            String content = Files.readString(Paths.get(path));
            counterInFile = Long.parseLong(content);
        } catch (IOException e) {
            return 0;
        }

        return counterInFile;
    }
}
