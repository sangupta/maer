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
package org.myjerry.maer.page1;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.myjerry.maer.util.MathUtil;

/**
 * Problem 23 on Project Euler,
 * http://projecteuler.net/index.php?section=problems&id=23
 * 
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem23 {

	public static void main(String[] args) {
		Set<BigInteger> numbers = new HashSet<BigInteger>();

		int count = 0;
		for (int a = 2; a < 101; a++) {
			for (int b = 2; b < 101; b++) {
				BigInteger num = MathUtil.raiseToPower(a, b);
				count++;
				numbers.add(num);
			}
		}

		System.out.println("Distinct numbers: " + numbers.size() + " in total " + count + " numbers.");
	}

}
