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

import java.util.HashSet;
import java.util.Set;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 32 on Project Euler, http://projecteuler.net/index.php?section=problems&id=32
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since May 2, 2011
 */
public class Problem32 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Long> products = new HashSet<Long>();
		for(int i = 1; i < 3000; i++) {
			for(int j = i; j < 3000; j++) {
				long product = i * j;
				if(String.valueOf(product).length() > 9) {
					break;
				}
				
				if(check(i, j, product)) {
					System.out.println("Adding " + i + " " + j + " " + product);
					products.add(product);
				}
			}
		}
		
		long sum = 0;
		for(Long product : products) {
			sum += product;
		}
		
		System.out.println("Sum of products: " + sum);
	}
	
	private static boolean check(int i, int j, long product) {
		String num = "" + i + j + product;
		if(num.length() == 9) {
			return MathUtil.isPandigital(num);
		}
		
		return false;
	}

}
