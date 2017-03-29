


	

	import java.util.Random;

	public class MinesPos 
	 {	
		private  Coordinates[]  mines;
		public static int[] XCord;
		public static int[] YCord;

		public MinesPos(int l)
		 {
			 XCord = new int[l];
			 YCord = new int[l];
			 mines= new Coordinates[l];
		 }
		
		public Coordinates [] getMinesPosition() 
		 {	
			 return mines;
		 }
		
		public void setCoordinate()
		 {
			Random number = new Random();

			for(int i=0;i<10;i++)
			 {
				int xPos = number.nextInt(9);
				int yPos = number.nextInt(9);
				mines[i] = new Coordinates(xPos, yPos);	
			 }

			int xcord [] = new int[10];
			int ycord[] = new int[10];
			for(int i=0;i<10;i++)
			 {
				xcord[i] = mines[i].getX();
				ycord[i] = mines[i].getY();
			 }
		 }

		public boolean coordComparison(int x, int y, Coordinates c) 
		 { // Method to compare two different coordinates	
			 return x == c.getX() && y == c.getY();			
		 }

		public boolean coordinateCompare(int x, int y ) 
		 {
			for(int i=0; i < mines.length; i++)
			 { 
				if(coordComparison(x, y, mines[i]))
				 {
					return true;
				 }	
			 }
			return false;	
		}

		public boolean nearbyMines( int a, int b)   
		{
			if(coordinateCompare(a+1,b)|| 
			   coordinateCompare(a-1,b)||
		       coordinateCompare(a,b+1)||
			   coordinateCompare(a,b-1)||
			   coordinateCompare(a-1,b-1)||
			   coordinateCompare(a+1,b+1)||
			   coordinateCompare(a-1,b+1)||
			   coordinateCompare(a+1,b-1))
			 
			{
				return true;
			}
			return false;
		}

		public int  nearbyMinesCounter(int  x, int y) 
		{
			int counter = 0 ;
			for (int i = x-1; i <= x+1; i++) 
			 {
				for (int j = y-1; j <= y+1; j++) 
				 {
					 if (!(i==x && j == y))
					  {
						if (coordinateCompare(i,j))
						 {
							counter++;	
						 }
					  }	
				 }
			}
			return counter;
		}
	}

