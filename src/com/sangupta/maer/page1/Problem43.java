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
package com.sangupta.maer.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 43 on Project Euler, http://projecteuler.net/index.php?section=problems&id=43
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 29-Aug-2011
 */
public class Problem43 {
	
	public static void main(String[] args) {
		long sum = 0;
		
		List<String> perm = permutation("4310");
		for(String n : perm) {
			if(n.charAt(0) != '0') {
				long num = Long.parseLong(n + "952867");
				if(numCheck(num)) {
					sum += num;
				}
			}
		}
		
		perm = permutation("6410");
		for(String n : perm) {
			if(n.charAt(0) != '0') {
				long num = Long.parseLong(n + "357289");
				if(numCheck(num)) {
					sum += num;
				}
			}
		}
		
		System.out.println("Sum: " + sum);
	}
	
	/**
	 * @param num
	 * @return
	 */
	private static boolean numCheck(long num) {
		String s = String.valueOf(num);
		int d2 = Integer.parseInt(s.substring(1, 4));
		int d3 = Integer.parseInt(s.substring(2, 5));
		
		if(d2 % 2 == 0 && d3 % 3 == 0) {
			return true;
		}
		
		return false;
	}

	public static List<String> permutation(String str) { 
		List<String> values = new ArrayList<String>(); 
		permutation("", str, values); 
		
		return values;
	 }

	 private static void permutation(String prefix, String str, List<String> values) {
	    int n = str.length();
	    if (n == 0) {
	    	values.add(prefix);
	    }
	    
	    else {
	        for (int i = 0; i < n; i++)
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), values);
	    }

	}

}
