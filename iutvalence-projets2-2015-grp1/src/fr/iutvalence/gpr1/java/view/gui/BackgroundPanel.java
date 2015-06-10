package fr.iutvalence.gpr1.java.view.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Image of the calendar.
	 */
	private Image img;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			this.img = ImageIO.read(new File("fond.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
