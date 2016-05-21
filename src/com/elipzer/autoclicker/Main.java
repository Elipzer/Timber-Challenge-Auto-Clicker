package com.elipzer.autoclicker;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws AWTException, InterruptedException {
		Robot r = new Robot();
		
		class Coord {
			public int x;
			public int y;

			public Coord() {
				this.x = 0;
				this.y = 0;
			}

			public Coord(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		ArrayList<Coord> coords = new ArrayList<Coord>();
		Coord offset = new Coord(290, 264);
		Coord max = new Coord(1244, 847);
		Coord diff = new Coord(max.x - offset.x, max.y - offset.y);
		int px = 40;
		int py = 45;
		int xnum = diff.x / px;
		int ynum = diff.y / py;
		for (int y = 0; y < ynum; y++) {
			for (int x = 0; x < xnum; x++) {
				coords.add(new Coord(offset.x + px * x, offset.y + py * y));
			}
		}
		System.out.println(xnum + " " + ynum);
		int it = 0;
		System.out.println(coords.size());
		while (true) {
			it += 1;
			it %= coords.size();
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Coord c = coords.get(it);
			if (c.x >= offset.x && c.x <= max.x && c.y >= offset.y && c.y <= max.y)
				r.mouseMove(c.x, c.y);
			else
				System.out.println("Invalid Mouse Loc");
			System.out.println("C: " + c.x + "," + c.y);
			System.out.println("d");
			Thread.sleep(10);
		}
	}
	
	
}
