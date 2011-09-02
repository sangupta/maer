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
package com.sangupta.maer.page2;

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 81 on Project Euler, http://projecteuler.net/index.php?section=problems&id=81
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem81 {
	
	private static int[][] matrix;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		matrix = FileUtils.readFileAsIntMatrix(81, 80, 80);
		
		System.out.println("Min Sum: " + getMinimumSum(matrix));
	}
	
	private static int getMinimumSum(int[][] matrix) {
		final int maxRow = matrix.length - 1;
		final int maxCol = matrix[0].length - 1;
		
		for(int row = maxRow; row >= 0; row--) {
			for(int col = maxCol; col >= 0; col--) {
				int min = 0;
				if(row == maxRow && col == maxCol) {
					min = 0;
				} else if(col == maxCol) {
					min = matrix[row + 1][col]; 
				} else if(row == maxRow) {
					min = matrix[row][col + 1];
				} else {
					min = Math.min(matrix[row + 1][col], matrix[row][col + 1]);
				}
				
				matrix[row][col] += min;
			}
		}
		
		return matrix[0][0];
	}
}
