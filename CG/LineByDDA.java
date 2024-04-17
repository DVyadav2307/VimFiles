public class LineByDDA{

	public static void main(String[] args){

		if(args.length !=4)
			throw new IllegalArgumentException("Please Provide 4 arguements");
		else
			printPoints(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	}

	public static void printPoints(int x1, int y1, int x2, int y2){

		int dx = x2 - x1;
		int dy = y2 - y1;

		int step = 0; 

		if(dx > dy)
			step = Math.abs(dx);
		else
			step = Math.abs(dy);
		
		float xInc = dx / (float)step;
		float yInc = dy / (float)step;

		float X = x1;
		float Y = y1;
		for(int i = 0; i<= step; i++){
			System.out.println("( "+Math.round(X)+" , "+Math.round(Y)+" )");

			X += xInc;
			Y += yInc;
		}

	}
}
