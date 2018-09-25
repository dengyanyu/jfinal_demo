package com.bw.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgTest {
	public static void main(String[] args) throws IOException {
		BufferedImage image = new BufferedImage(800, 400,BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        
        //画图
        g.setColor(new Color(255, 255, 0));
        g.setFont(new Font(null, 1, 40));
        g.drawString("74384", 100, 200);
        
        g.setColor(new Color(100, 200, 100));
        g.drawLine(100, 0, 200, 50);
        
        
        g.dispose();
        FileOutputStream ou = new FileOutputStream(new File("download/test.jpg"));
      ImageIO.write(image, "JPEG", ou);
      // 以下关闭输入流！
      ou.flush();
      ou.close();
	}
}
