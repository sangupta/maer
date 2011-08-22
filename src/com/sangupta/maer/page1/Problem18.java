/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, Sandeep Gupta
 * http://www.sangupta.com/projects/maer
 *
 * The file is licensed under the the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.sangupta.maer.page1;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 8, 2011
 */
public class Problem18 {
	
	private static final int[][] matrix = {
			{ 75 },
			{ 95, 64 },
			{ 17, 47, 82 },
			{ 18, 35, 87, 10 },
			{ 20, 4, 82, 47, 65 },
			{ 19, 1, 23, 75, 3, 34 },
			{ 88, 2, 77, 73, 7, 63, 67 },
			{ 99, 65, 4, 28, 6, 16, 70, 92 },
			{ 41, 41, 26, 56, 83, 40, 80, 70, 33 },
			{ 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
			{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
			{ 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
			{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
			{ 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
			{ 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 }
	};
	
	/**
	 * Instead of brute-forcing the solution, the approach is to start the analysis
	 * from the second last row. For number 63, there are only two ways to go down,
	 * choose 4 or 62. The maximum sum would be 63 + 62. Thus, add 62 to 63 and replace
	 * the value of 63 in matrix. Similarly do for all numbers in the row, and then
	 * move upwards. The maximum sum will get stored in the first cell of the matrix.
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		for(int row = matrix.length - 1; row > 0; row--) {
			for(int column = 0; column < matrix[row].length - 1; column++) {
				int max = Math.max(matrix[row][column], matrix[row][column + 1]);
				matrix[row - 1][column] += max;
			}
		}
		
		System.out.println("Max sum = " + matrix[0][0]);
	}

}
