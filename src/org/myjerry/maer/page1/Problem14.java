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

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 14 on Project Euler, http://projecteuler.net/index.php?section=problems&id=14
 * 
 * This particular solution requires a lot of memory so you may have to set
 * VM arguments before launching.
 * 
 * @author Sandeep Gupta
 * @since Jan 6, 2011
 */
public class Problem14 {
	
	private static final long euler = (long) Math.pow(10, 6);
	
	private static final int mapGroupLimit = 25000; 
	
	private static final Map<Integer, Long[]> map = new HashMap<Integer, Long[]>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long num = 0, maxSequence = 0;
		for(long x = 1; x <= euler; x++) {
			long seq = getSequenceCount(x);
			if(seq > maxSequence) {
				maxSequence = seq;
				num = x;
			}
		}
		
		System.out.println("Max sequence consists of length: " + maxSequence + ", for number: " + num);
	}

	private static long getSequenceCount(long number) {
		if(number == 1) {
			return 1;
		}
		
		// check if we have this value in memory
		int mapIndex = (int) (number / mapGroupLimit);
		
		Long[] list = map.get(mapIndex);
		if(list == null) {
			list = new Long[mapGroupLimit + 1];
			map.put(mapIndex, list);
		}
		
		int subIndex = (int) (number % mapGroupLimit);
		if(list[subIndex] != null) {
			return list[subIndex];
		}
		
		// we do not have it in memory
		// compute
		long value = 0;
		if(number % 2 == 1) {
			value = 2 + getSequenceCount((3 * number + 1) / 2);
		} else {
			value = 1 + getSequenceCount(number / 2);
		}

		list[subIndex] = value;
		return value;
	}

}
