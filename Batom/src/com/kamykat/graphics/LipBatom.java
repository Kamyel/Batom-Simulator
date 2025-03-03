package com.kamykat.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class LipBatom {
	
	public static int x = 336;
    public static int y = 240;

	public static void render(Graphics g) {
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(x, y - 90, 48, 110);
		g.fillArc(x - 49, (y - 90) - 30, 97, 70, 10, 80);
		g.setColor(new Color(255, 40, 40));
		g.fillRect(x, (y-90) - 29, 10, 139);
		g.setColor(new Color(255, 80, 80));
		g.fillRect(x+3, (y-90)-29, 3, 139);
	}
	
}
