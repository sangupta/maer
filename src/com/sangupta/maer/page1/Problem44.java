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

import java.util.ArrayList;
import java.util.List;

import com.sangupta.maer.util.MathUtil;

/**
 * Problem 44 on Project Euler, http://projecteuler.net/index.php?section=problems&id=44
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since May 2, 2011
 */
public class Problem44 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> pentagonals = new ArrayList<Integer>();
		for(int i = 1; i < 2400; i++) {
			int pent = MathUtil.getPentagonalForIndex(i);
			pentagonals.add(pent);
		}
		
		int diff = 0;
		
		for(int i : pentagonals) {
			for(int j : pentagonals) {
				int add = i + j;
				int sub = Math.abs(i - j);
				
				if(pentagonals.contains(add) && pentagonals.contains(sub)) {
					diff = sub;
					break;
				}
			}
			
			if(diff > 0) {
				break;
			}
		}
		
		System.out.println("Difference: " + diff);
	}

}
