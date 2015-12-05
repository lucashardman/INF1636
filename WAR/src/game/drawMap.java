package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Mapa;

@SuppressWarnings("serial")
public class drawMap extends Mapa{
	
	private BufferedImage image;
	
	public drawMap(){
		try {                
			image = ImageIO.read(new File("src/img/Mapas/war_tabuleiro_com_nomes.png"));
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}

	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,1024, 768, null);      
       
    }
}