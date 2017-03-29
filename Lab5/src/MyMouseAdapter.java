import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	
	
	int counter = 11;
	public static MinesPos mines = new MinesPos(10);

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
			
			
		
			
			
			
			
		case 3:	
			
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
			if(gridX >= 0 && gridX <= 8 && gridY >= 0 && gridY <= 8)
			 {
				if(mines.nearbyMines(gridX, gridY))
				 {
					
					int counter = mines.nearbyMinesCounter(gridX, gridY);

					Color newColor = Color.GRAY;
					MyPanel.colorArray[gridX][gridY] = newColor;
					myPanel.nearbyMines[gridX][gridY] = counter;
					myPanel.counter++;
					myPanel.repaint();
				} 

				
				
				else if(!mines.coordinateCompare(gridX, gridY))
				 {
					 myPanel.nextToBlockDisplay(gridX, gridY);

				 }
				
			

				if(mines.coordinateCompare(gridX, gridY))
				 {
					Color newColor = Color.BLACK;
					MyPanel.colorArray[gridX][gridY] = newColor;
					myPanel.repaint();
					///
					JOptionPane.showMessageDialog(myFrame,
							"You stepped on a mine, You lose!",
							"You lose!",
							JOptionPane.ERROR_MESSAGE);
					myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					System.exit(0);

				}
				if (myPanel.counter >=53) 
				 {
					 JOptionPane.showMessageDialog(null, "You won. Big Deal.");
					 System.exit(0);
				 }

			}
			
break;
		
		case 3:		
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
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
		myPanel1.repaint();
		
				if(gridX1 >= 0 && gridX1 <= 8 && gridY1 >= 0 && gridY1 <= 8) 
				 {
					

					if(MyPanel.colorArray[gridX1][gridY1].equals(Color.WHITE))
					 {
						if(counter>0)
						 {
							 MyPanel.colorArray[gridX1][gridY1] = Color.RED;
							 myPanel1.repaint();
							 counter--;
						 }
						
						else if(counter == 0)
						 {
							//Limits the amount of flags.
							JOptionPane.showMessageDialog(d, "Maximum amount of flags used.");
						 }
					 }

						else if(MyPanel.colorArray[gridX1][gridY1].equals(Color.BLACK) || MyPanel.colorArray[gridX1][gridY1].equals(Color.GRAY))
					     {
						// Do nothing.
					     }

				    else 
					 {
						MyPanel.colorArray[gridX1][gridY1] = Color.WHITE;
						myPanel1.repaint();
						
					    if(counter<10)
					     {	
						    counter++;	
						 }
					  
					    else 
					     {

					    	MyPanel.colorArray[gridX1][gridY1] = Color.WHITE;
					    	myPanel1.repaint();
					     }
					 }
				 }

				break;
				default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
				 
			}
		 }



		public void Mines()
		 {
			 mines.setCoordinate();
		 }
	
							
							
						
								
		
		}
	


	
