import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map{
	/** The width in grid cells of our map */
	private static final int WIDTH = 20;
	/** The height in grid cells of our map */
	private static final int HEIGHT = 20;

	/** The rendered size of the tile (in pixels) */
	public static final int TILE_SIZE = 20;

	 Image gora;
	 Image trava;

	int[][] data = new int[][]{
	      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	      {1,2,1,2,1,2,2,2,1,2,2,1,2,2,2,2,2,2,2,1},
	      {1,2,2,2,1,2,1,2,1,2,2,1,2,1,2,1,1,2,2,1},
	      {1,2,2,2,1,2,1,2,1,2,1,2,1,1,1,1,1,1,2,1},
	      {1,1,1,2,1,2,2,2,1,2,1,2,2,2,2,2,2,2,2,1},
	      {1,2,1,2,2,2,1,2,1,2,2,2,2,1,2,1,2,1,1,1},
	      {1,2,2,1,1,1,1,2,1,2,1,1,1,1,2,1,2,2,2,1},
	      {1,2,2,2,2,2,1,2,1,2,2,2,2,1,2,1,1,1,2,1},
	      {1,2,1,1,2,2,1,2,1,1,1,1,2,1,2,2,2,2,2,1},
	      {1,2,1,2,2,2,1,2,2,2,2,2,2,1,2,1,1,1,1,1},
	      {1,2,1,1,1,1,1,1,1,2,2,1,1,1,2,1,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,1,2,2,2,1,2,1,2,1},
	      {1,2,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1,2,1},
	      {1,2,2,2,2,2,1,2,2,2,1,2,2,2,2,2,2,2,2,1},
	      {1,1,1,2,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1},
	      {1,2,2,2,1,2,2,2,1,2,1,2,1,2,1,2,2,2,2,1},
	      {1,2,1,1,1,2,1,2,1,1,1,2,2,2,1,2,2,1,2,1},
	      {1,2,2,2,2,2,1,2,2,1,2,2,1,2,2,2,1,2,2,1},
	      {1,2,1,1,1,2,1,1,2,2,2,1,1,2,1,1,1,1,2,1},
	      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	    };

	    public void paintMap(Graphics g) {
	    	ImageIcon i1 = new ImageIcon(getClass().getResource("img/gora.png"));
	         gora = i1.getImage();
	        ImageIcon i2 = new ImageIcon(getClass().getResource("img/trava.jpg"));
	         trava = i2.getImage();

			for (int x=0;x<data.length;x++) {
				System.out.println(data[0].length);
				for (int y=0;y<data.length;y++) {
					g.setColor(Color.darkGray);
					if (data[x][y] == 1) {
						//g.setColor(Color.gray);
						g.drawImage(gora, y*TILE_SIZE,x*TILE_SIZE,TILE_SIZE,TILE_SIZE, null);
					}else{
					g.drawImage(trava, y*TILE_SIZE,x*TILE_SIZE,TILE_SIZE,TILE_SIZE, null);
					}

				}
			}
		}
}
