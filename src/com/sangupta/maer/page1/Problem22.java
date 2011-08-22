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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem 22 on Project Euler, http://projecteuler.net/index.php?section=problems&id=22
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem22 {
	
	private static List<String> names = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String path = "C:/names.txt";
		
		// read all names in an array first
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			String tokens[] = line.split(",");
			if(tokens != null) {
				for(String token : tokens) {
					if(token.startsWith("\"")) {
						token = token.substring(1);
					}
					if(token.endsWith("\"")) {
						token = token.substring(0, token.length() - 1);
					}
					
					names.add(token);
				}
			}
		}
		
		// sort the names
		Collections.sort(names);
		
		long sum = 0;
		// now start computing the values
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			sum += getNameScore(name) * (i + 1);
		}
		
		System.out.println("Total Score: " + sum);
	}

	/**
	 * @param name
	 * @param i
	 * @return
	 */
	private static long getNameScore(String name) {
		long sum = 0;
		// sum the name
		for(int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			int val = c - 'A' + 1;
			sum += val;
		}
		return sum;
	}

}
