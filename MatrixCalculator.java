/**
 * 
 */
package calculator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Wilbert Guo
 *
 */
public class MatrixCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create new Scanner for User Input
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Matrix #1");
		System.out.print("Enter number of rows: ");
		int numRows1 = sc.nextInt();
		System.out.print("Enter number of columns: ");
		int numColumns1 = sc.nextInt();
		sc.nextLine();
		
		int[][] matrix1 = new int[numRows1][numColumns1];
		
		for(int a = 0; a < numRows1; a++){
			String input = sc.nextLine();
			String[] line = input.split("\\s");
			
			for(int b = 0; b < line.length; b++){
				matrix1[a][b] = Integer.parseInt(line[b]);
			}
		}
		
		System.out.print("Enter operation (+/-/*): ");
		String operation = sc.nextLine();
		
		System.out.println("Matrix #2");
		System.out.print("Enter number of rows: ");
		int numRows2 = sc.nextInt();
		System.out.print("Enter number of columns: ");
		int numColumns2 = sc.nextInt();
		sc.nextLine();
		
		int[][] matrix2 = new int[numRows2][numColumns2];
		
		for(int a = 0; a < numRows2; a++){
			String input = sc.nextLine();
			String[] line = input.split("\\s");
			
			for(int b = 0; b < line.length; b++){
				matrix2[a][b] = Integer.parseInt(line[b]);
			}
		}
		
		if(operation.equals("+")){
			if((numRows1 == numRows2) && (numColumns1 == numColumns2)){
				int [][] result = add(numRows1, numColumns1, numRows2, numColumns2, 
						matrix1, matrix2);
				
				System.out.println("Your result is: ");
				
				for(int i = 0; i < result.length; i++){
					for(int j = 0; j < result[i].length; j++){
						System.out.print(result[i][j] + "    ");
					}
					System.out.println();
					System.out.println();
				}				
			}else{
				System.out.println("Invalid operation for matrix addition since matrix "
						+ "dimensions are not the same.");
			}

		}else if(operation.equals("-")){
			if((numRows1 == numRows2) && (numColumns1 == numColumns2)){
				int [][] result = subtract(numRows1, numColumns1, numRows2, numColumns2, 
						matrix1, matrix2);
				
				System.out.println("Your result is: ");
				
				for(int i = 0; i < result.length; i++){
					for(int j = 0; j < result[i].length; j++){
						System.out.print(result[i][j] + "    ");
					}
					System.out.println();
					System.out.println();
				}				
			}else{
				System.out.println("Invalid operation for matrix subtraction since matrix "
						+ "dimensions are not the same.");
			}
	
		}else if(operation.equals("*")){
			if(numColumns1 == numRows2){
				int [][] result = multiply(numRows1, numColumns1, numRows2, numColumns2, 
						matrix1, matrix2);
				
				System.out.println("Your result is: ");
				
				for(int i = 0; i < result.length; i++){
					for(int j = 0; j < result[i].length; j++){
						System.out.print(result[i][j] + "    ");
					}
					System.out.println();
					System.out.println();
				}
			}else{
				System.out.println("Invalid operation for matrix multiplication since number"
						+ "of columns in matrix 1 is not equal to number of rows in matrix 2.");
			}

		}

		
	}
	
	public static int[][] add(int row1, int column1, int row2, int column2, 
			int[][] matrix1, int[][] matrix2){
		
		int[][] arr = new int[row1][column1];
		
		//add corresponding entries in each matrix
		for(int i = 0; i < row1; i++){
			for(int j = 0; j < column1; j++){
				arr[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		return arr;
	}
	
	public static int[][] subtract(int row1, int column1, int row2, int column2, 
			int[][] matrix1, int[][] matrix2){
		
		int[][] arr = new int[row1][column1];
		
		//add corresponding entries in each matrix
		for(int i = 0; i < row1; i++){
			for(int j = 0; j < column1; j++){
				arr[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		
		return arr;
	}

	public static int[][] multiply(int row1, int column1, int row2, int column2, 
			int[][] matrix1, int[][] matrix2){
		
		int[][] arr = new int[row1][column2];
		int[][] m1 = matrix1;
		int[][] m2 = transpose(row2, column2,matrix2);
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = dotProduct(m1[i], m2[j]);
			}
		}
		return arr;
	}
	
	public static int dotProduct(int[] vector1, int[] vector2){
		int sum = 0;
		
		for(int i = 0; i < vector1.length; i++){
			int result = vector1[i] * vector2[i];
			sum += result;
		}
		
		return sum;
	}

	public static int[][] transpose(int row, int column, int[][] matrix){
		int[][] result = new int[column][row];
		
		for(int i = 0; i < column; i++){
			for(int j = 0; j < row; j++){
				result[j][i] = matrix[i][j];
			}
		}
		
		return result;
	}
}

