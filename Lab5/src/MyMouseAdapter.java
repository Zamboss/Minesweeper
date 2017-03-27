import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
			
			//TODO: WORK IT
		case 2:
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame) d;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
			Insets myInsets1 = myFrame1.getInsets();
			int x2 = myInsets1.left;
			int y2 = myInsets1.top;
			e.translatePoint(-x2, -y2);
			int r = e.getX();
			int t = e.getY();
			myPanel1.x = r;
			myPanel1.y = t;
			myPanel1.mouseDownGridX = myPanel1.getGridX(r, t);
			myPanel1.mouseDownGridY = myPanel1.getGridY(r, t);
			myPanel1.repaint();
			break;
			
			
			
		case 3:	
			
			
			
			//Right mouse button
			//Do nothing
			//TODO: flags by right click
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == -1) || (gridY == -1)) {
							//On the left column and on the top row... do nothing
						 }else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							//TODO: find how to return the value of Color
							
							switch (generator.nextInt(1)) {
							case 0:
								newColor = Color.GRAY;
								break;
							
						
								
							}
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 2: 
			
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
			JFrame myFrame1 = (JFrame)d;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets1 = myFrame1.getInsets();
			int x2 = myInsets1.left;
			int y2 = myInsets1.top;
			e.translatePoint(-x2, -y2);
			int r = e.getX();
			int t = e.getY();
			myPanel1.x = r;
			myPanel1.y = t;
			int gridX1 = myPanel1.getGridX(r, t);
			int gridY1 = myPanel1.getGridY(r, t);
			if ((myPanel1.mouseDownGridX == -1) || (myPanel1.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX1 == -1) || (gridY1 == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel1.mouseDownGridX != gridX1) || (myPanel1.mouseDownGridY != gridY1)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX1 == -1) || (gridY1 == -1)) {
							//On the left column and on the top row... do nothing
						 }else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							//TODO: find how to return the value of Color
							
							switch (generator.nextInt(1)) {
							case 0:
								newColor = Color.RED;
								break;
							
						
								
							}
							myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = newColor;
							myPanel1.repaint();
						}
					}
				}
			}
			myPanel1.repaint();
			break;
			}
		case 3:		//Right mouse button
			//Do nothing
			break;
		//default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
		//	break;
		}
	}
	
}