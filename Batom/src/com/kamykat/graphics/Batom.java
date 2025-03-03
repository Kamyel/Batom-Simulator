package com.kamykat.graphics;

import java.awt.Color;
import java.awt.Graphics;

import com.kamykat.main.Janela;

public class Batom {

	public static void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect((Janela.WIDTH/2)-40, (Janela.HEIGHT/2) - 30, 80, 90);
		g.fillRect((Janela.WIDTH/2)-29, (Janela.HEIGHT/2) - 90, 58, 90);
		g.setColor(Color.gray);
		g.fillRect((Janela.WIDTH/2)-40, (Janela.HEIGHT/2) - 30, 80, 5);
		
	}
	
}
