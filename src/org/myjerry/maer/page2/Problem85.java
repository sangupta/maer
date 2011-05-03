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

/**
 * Problem 85 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=85
 * 
 * @author Sandeep Gupta
 * @since May 3, 2011
 */
public class Problem85 {

	private static final int eulerLimit = 2000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxArea = 0;
		int minDiff = eulerLimit;

		for (int cols = 2; cols < 100; cols++) {
			for (int rows = 2; rows < 100; rows++) {
				int rectangles = numRectangles(rows, cols);
				int diff = Math.abs(eulerLimit - rectangles);
				if (diff < minDiff) {
					System.out.println("Min diff at " + rows + " x " + cols
							+ " as " + diff);
					minDiff = diff;
					maxArea = rows * cols;
				} else {
					continue;
				}
			}
		}

		System.out.println("Max area: " + maxArea);
	}

	/**
	 * Calculate the number of different sized rectangles that can be formed in a larger rectangle of given
	 * rows and columns.
	 * 
	 * @param rows
	 * @param cols
	 * @return
	 */
	private static int numRectangles(int rows, int cols) {
		int sum = 0;
		for (int n = rows; n >= 1; n--) {
			for (int m = cols; m >= 1; m--) {
				sum += m * n;
			}
		}
		return sum;
	}

}
