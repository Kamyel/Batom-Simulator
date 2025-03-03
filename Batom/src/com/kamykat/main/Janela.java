package com.kamykat.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.kamykat.graphics.Batom;
import com.kamykat.graphics.GrowBottom;
import com.kamykat.graphics.LipBatom;
import com.kamykat.main.Janela;

public class Janela extends Canvas implements MouseListener, MouseMotionListener, Runnable{

	private static final long serialVersionUID = 1L;
	private static Thread thread;
	public Janela janela;
	public static boolean isRunning = true;
	public JFrame frame;
	public static BufferedImage image;
	public static int WIDTH = 720, HEIGHT = 480;
	public GrowBottom growbottom;
	public LipBatom lipbatom;
	public static boolean isPressed = false;
	public int mX, mY;

	public Janela() {
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		initFrame();
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	}
	public void initFrame() {
		frame = new JFrame("batom simulator");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Janela janela = new Janela();
		janela.start();
	}
	
	public void tick() {}
	
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = image.getGraphics();
		g.setColor(new Color(255,182,193));
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial" , Font.BOLD, 40));
		g.drawString("Simulador de batom", 180, 60);
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0,WIDTH,HEIGHT,null);
		
		GrowBottom.render(g);
		LipBatom.render(g);
		Batom.render(g);

		bs.show();
	}
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while(isRunning){
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000){
				System.out.println("FPS: "+ frames);
				frames = 0;
				timer+=1000;
			}
			
		}
		
		stop();
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			mY = e.getY();
			mX = e.getX();
			
			if(mX >= GrowBottom.x && mX < (GrowBottom.x + GrowBottom.width)) {
			   if(mY >= GrowBottom.y && mY < (GrowBottom.y + GrowBottom.height)) {
				isPressed = true;
			   }
			}
			if(isPressed = true) {
				LipBatom.y = LipBatom.y - 2;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
		isPressed = false;
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}
}
