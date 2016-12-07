package game3;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * Klassen Girl skapar ett objekt av girl
 * @author Lykke Levin & Amin Harirchian
 *
 */
public class Girl implements Icon {
	private ImageIcon image;
    private int x;
    private int y;

    public Girl(ImageIcon image) {
        this.image = image;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
