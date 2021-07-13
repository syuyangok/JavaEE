package checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 400;
        int height = 50;

        //create object, use object to store image in memory
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //revise image
        Graphics g = image.getGraphics(); // get 画笔 object
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);//set image background color

        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width, height);// draw blue frame

        String str = "abcdefghijklmnop";
        Random ran = new Random();
        for (int i = 1; i <=3; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index); // gt random char
            g.drawString(ch+"", width/4*i, 25);// draw string
        }

        g.setColor(Color.GREEN);
        for (int i = 0; i < 8 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            g.drawLine(x1, y1, x2, y2);//random draw line
        }




        //output image to browser
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
