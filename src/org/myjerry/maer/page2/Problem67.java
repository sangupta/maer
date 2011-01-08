/**
 *
 * maer - Solutions to problems of Project Euler
 * Copyright (C) 2011, myJerry Developers
 * http://www.myjerry.org/maer
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
package org.myjerry.maer.page2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author Sandeep Gupta
 * @since Jan 8, 2011
 */
public class Problem67 {
	
	private static final int[][] matrix = new int[100][];

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String path = "c:/triangle.txt";
		
		// build the matrix
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		int lineCount = 0;
		while((line = reader.readLine()) != null) {
			String tokens[] = line.split(" ");
			if(tokens != null) {
				int[] row = new int[tokens.length];
				for(int i = 0; i < tokens.length; i++) {
					String token = tokens[i];
					int num = Integer.parseInt(token);
					row[i] = num;
				}
				matrix[lineCount++] = row;
			}
		}

		// now run the analyzer
		for(int row = matrix.length - 1; row > 0; row--) {
			for(int column = 0; column < matrix[row].length - 1; column++) {
				int max = Math.max(matrix[row][column], matrix[row][column + 1]);
				matrix[row - 1][column] += max;
			}
		}
		
		System.out.println("Max sum = " + matrix[0][0]);
		
	}

}
