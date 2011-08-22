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

import java.math.BigInteger;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 97 on Project Euler, http://projecteuler.net/index.php?section=problems&id=97
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 7, 2011
 */
public class Problem97 {
	
	private static final long power = 7830457l;
	
	private static final int multiply = 28433;
	
	private static final int precision = 10;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger lastTen = MathUtil.raiseToPowerInPrecision(2, power, precision);
		BigInteger multiplied = Multiply(lastTen, multiply);
		BigInteger add = multiplied.add(BigInteger.valueOf(1l));
		
		System.out.println("Last ten digits: " + MathUtil.trimToPrecision(add, precision));
	}

	/**
	 * @param lastTen
	 * @param multiply2
	 * @return
	 */
	private static BigInteger Multiply(BigInteger lastTen, int multiply) {
		BigInteger x = lastTen.multiply(BigInteger.valueOf(multiply));
		return MathUtil.trimToPrecision(x, precision);
	}


}
