package cn.dc.servlet;

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

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.getGraphics();//获取画笔
        Color c=new Color(200,150,255);//颜色
        g.setColor(c);
        g.fillRect(0, 0, 68, 22);//框

        char[] ch="QWERTYUIOPASDFGHJKLZXCVBNM123456789".toCharArray();
        //获取四个字符
        Random r=new Random();
        int len=ch.length,index;//设置范围
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <4; i++) {
            index=r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));//有字符后放在颜色上
            g.drawString(ch[index]+"",(i*15)+3,18);//字符转字符串  画字符
            sb.append(ch[index]);
        }//循环四次保存四次
        request.getSession().setAttribute("piccode", sb.toString());///字符保存到session里，要进行验证
        ImageIO.write(bi, "JPG",response.getOutputStream());

    }
}
