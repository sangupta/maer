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

import java.util.List;

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 8, 2011
 */
public class Problem67 {
	
	private static final int[][] matrix = new int[100][];

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<String> lines = FileUtils.readLines(67);
		
		int lineCount = 0;
		for(String line : lines) {
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
