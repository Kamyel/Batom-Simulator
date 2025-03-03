package com.kamykat.graphics;

import java.awt.Color;
import java.awt.Graphics;

import com.kamykat.main.Janela;

public class GrowBottom {
	public static int x = 360;
	public static int y = 240;
	public static int width = 80;
	public static int height = 80;
	
	public static void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillOval(x - 40, y + 100, width, height);
		g.setColor(Color.gray);
		g.drawOval(x - 40, y + 100, width, height);
		g.setColor(Color.red);
		g.fillOval(x - 35, y + 105, width-10, height-10);
		g.setColor(new Color(255, 30, 30));
		g.fillOval(x - 30, y + 110, width-20, height-20);
		g.setColor(Color.white);
		g.fillOval(x + 10, y + 115, 10, 10);
		
		if(Janela.isPressed == true) {
			g.setColor(new Color(0,0,0,40));
			g.fillOval(x - 35, y + 105, width-10, height-10);
		}
	}

}
