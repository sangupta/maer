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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 62 on Project Euler, http://projecteuler.net/index.php?section=problems&id=62
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class Problem62 {
	
	private static final int MAX = 100000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Holder> map = new HashMap<String, Problem62.Holder>();
		
		Holder holder = null;
		for(int number = 345; number < MAX; number++) {
			long cube = (long) Math.pow(number, 3);
			String numberAsString = String.valueOf(cube);
			char[] chars = numberAsString.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			
			if(map.containsKey(key)) {
				holder = map.get(key);
				holder.counter++;
				
				if(holder.counter == 5) {
					break;
				}
			} else {
				holder = new Holder(number, cube);
				map.put(key, holder);
			}
		}
		
		System.out.println("Smallest cube: " + holder.cube + " for number " + holder.number);
	}
	
	private static class Holder {
		
		public int number;
		
		public long cube;
		
		public int counter;
		
		public Holder(int number, long cube) {
			this.counter = 1;
			this.cube = cube;
			this.number = number;
		}
	}

}
