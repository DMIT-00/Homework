package my.task12.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private long counter = 0;

    final String FILE_NAME = "im_counter.data";

    @Override
    public void destroy() {
        super.destroy();
        saveCounterToFile(FILE_NAME, counter);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        counter = loadCounterFromFIle(FILE_NAME);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(800, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics.setColor(Color.green);
        graphics.drawString("Page visited " + counter + " times", 100, 100);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
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
    private void saveCounterToFile(String filename, long counter) {
        String path = getUserDir() + File.separator + filename;
        System.out.println(path);
        try {
            Files.writeString(Paths.get(path), String.valueOf(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads counter from file
     * @return counter read from file or 0 on error
     */
    private long loadCounterFromFIle(String filename) {
        long counterInFile = 0;
        String path = getUserDir() + File.separator + filename;

        try {
            String content = Files.readString(Paths.get(path));
            counterInFile = Long.parseLong(content);
        } catch (IOException e) {
            return 0;
        }

        return counterInFile;
    }
}
