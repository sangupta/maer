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
package com.sangupta.maer.page6;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 290 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=290
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 07-Sep-2011
 */
public class Problem290 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long value = count(18, 0, 0, new Long[18][137][2 * 9 * 18]);
		System.out.println("Answer: " + value);

	}

	private static long count(int numDigits, int carry, int diff, Long[][][] cache) {
		if (numDigits == 0) {
			int calculatedDiff = MathUtil.sumOfDigits(carry);
			if (calculatedDiff == diff) {
				return 1;
			} else {
				return 0;
			}
		}
		
		numDigits -= 1;

		final int key = diff + 9 * 18;

		Long count = cache[numDigits][carry][key];
		if (count == null) {
			count = 0L;
			for (int d = 0; d < 10; ++d) {
				final int x = d * 137 + carry;
				count += count(numDigits, x / 10, diff + d - x % 10, cache);
			}
		}

		return cache[numDigits][carry][key] = count;
	}

	

}
