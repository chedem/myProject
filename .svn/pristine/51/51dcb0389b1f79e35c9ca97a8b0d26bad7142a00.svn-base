package com.common.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class YzmImage {

	public static void main(String[] args) {
		getYzm();
	}
	public static BufferedImage getYzm(){
		int width = 100,height =30 ;
		Random ran = new Random();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(getColor(ran,0,100));
//		g.drawRect(0, 0, width, height);//绘画一矩形
		g.fillRect(1, 1, width-2, height-2);
		g.setFont(new Font("幼圆",Font.BOLD+Font.ITALIC,23));
		
		//绘画随机的4个数字
		for (int i = 0; i < 4; i++) {
			g.setColor(getColor(ran,100,255));
			int n = ran.nextInt(10);
			int dis = ran.nextBoolean()?ran.nextInt(8):-1*ran.nextInt(8);
			g.drawString(n+"", 20*i+10+dis, 25+dis);
		}
//		String s = "使肌肤大量进口的加拉地方减肥的拉萨";
//		for (int i = 0; i < 4; i++) {
//			char c = s.charAt(ran.nextInt(s.length()));
//			int dis = ran.nextBoolean()?ran.nextInt(10):-1*ran.nextInt(10);
//			g.drawString(c+"", i*20+10+dis, 20);
//		}
		//绘画15行线段
//		for (int i = 0; i < 15; i++) {
//			int j = ran.nextInt(height);
//			g.drawLine(0,j, width, j);
//		}
		//随机绘画1000个点
		g.setColor(Color.GRAY);
		for (int i = 0; i < 100; i++) {
			g.setColor(getColor(ran,0,255));
			g.drawOval(ran.nextInt(width), ran.nextInt(height), 1, 2);
		}
		try {
			ImageIO.write(image,"jpg" , new File("E:\\20170111.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static Color getColor(Random ran,int form,int to){
		int r = form + ran.nextInt(to-form);
		int g = form + ran.nextInt(to-form);
		int b = form + ran.nextInt(to-form);
		return new Color( r, g, b);
	}
}
