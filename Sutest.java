public class Sutest{
	public static int[][] a = new int[9][9];
	public static int globalNumber = 0;
	public static void main(String[] args){
		for(int i = 0; i < 2; i++){
			System.out.println("filling row >"+i);
			for (int j = 0; j < 9; j++){
				System.out.println("old value of a["+i+"]["+j+"]:"+a[i][j]);

				fillNextNumWithDuplicateCheckNineTimes(i, j);

				printArray();

				//look the activity inside of array
			}
		}
	}


	public static void fillNextNumWithDuplicateCheckNineTimes(int row, int col){
		//global number would go from 0 -> 10
		//will break when every possible number is checked
		//and no suitable number is found{
		globalNumber = 0;
		fillNextNumWithDuplicateCheck(row, col);
	}



	public static void fillNextNumWithDuplicateCheck(int row, int col){
		//ensure that all number are filled and checked not more than once
		globalNumber++;
		System.out.println("Checked possible values "+globalNumber+"X so far");
		if(globalNumber == 10){
			a[row][col] = 0;
			System.out.println("\n\nNo possible values found fit!,\n switching the value of a["+row+"]["+col+"] to "+ a[row][col]);

			//going to previous cell --backtrack start
			if(row > 0 && col == 0){
				row --;
				col = a[row].length - 1; //lset elemnt of that row
			}else{
				col--;
			}
			System.out.println("Switching to previous arrElement\n Altering value of a["+row+"]["+col+"]");
			fillNextNumWithDuplicateCheckNineTimes(row, col);
			return; 
		}

		//get next number
		a[row][col] = nextNum(a[row][col]);
		System.out.println("new value of a["+row+"]["+col+"]:"+a[row][col]);
		//Chek if present in row col and block
		if(isDuplicatePresent(a[row][col], row, col)){
			System.out.println("Yes is present in row/col/block");
			fillNextNumWithDuplicateCheck(row,col);

			//WARNNG: infinte loopin here
		}else{
			System.out.println("no duplicate in row/col/block\n	retaining the value");
		}
	}





	public static boolean isDuplicatePresent(int numToSearch, int row, int col){
		return (isPresentInRow(numToSearch, row, col ) || isPresentInColumn(numToSearch, row, col) || isPresentInBlock(numToSearch, row, col) );
	}









	public static boolean isPresentInBlock(int numToCheck, int row, int col){
		int rowHead = row - (row % 3);
		int colHead = col - (col % 3);
		System.out.println("row:"+ row+", rowHead:"+ rowHead);
		System.out.println("col:"+ col+", colHead:"+ colHead);

		//last col to iterate is colHead+2, same with last row to reach
		for(int i = rowHead; i < rowHead + 3; i++){
			for(int j = colHead; j < colHead + 3; j++){
				System.out.println("block checking at a["+i+"]["+j+"]");
				if(a[i][j] == numToCheck){
					if(i == row && j == col){
						//skip itself
						System.out.println("Skipped at rownumber: "+i+" and colnumber: "+j);
						continue;
					}
					//matched
					System.out.println("match Found at rownumber: "+i+" and colnumber: "+j);
					return true;
				}
			}
		}
		return false;

}				

	public static boolean isPresentInColumn(int numberToCheck, int row, int constCol){
		//check if in col
		for( int i = 0; i < 9; i++){
			System.out.println("row element "+i+" checked in col "+constCol);
			//iterative matching with array elemenst
			if(a[i][constCol] == numberToCheck){
				if(i == row){
					System.out.println("Skipped row element"+i);
					continue;
				}
				System.out.println("match found in row:"+i);
				return true;
			}
		}
		return false;
	}



	public static boolean isPresentInRow(int numberToCheck, int constRow, int col){
		//check if in row
		for(int j = 0; j < 9; j++){
			System.out.println("col element "+j+" checked in row "+constRow);
			//iterative matching with array elements
			if( a[constRow][j] == numberToCheck){
				//skip checking itself
				if(j == col){
					System.out.println("skipped col element:"+j);
					continue;
				}
				System.out.println("match found in col :"+j);
				return true;
			}
		}
		return false;
	}


	public static int nextNum(int presentNum){
		if (presentNum == 9)
			return 1;
		return presentNum + 1;
	}


	public static void printArray(){
		String outputArr = "";
		for(int i =0; i< 9; i++){
			for(int j = 0; j< 9; j++){
				outputArr += "\t"+a[i][j];
			}
			outputArr += "\n";
		}
		System.out.println(outputArr);
	}
}

