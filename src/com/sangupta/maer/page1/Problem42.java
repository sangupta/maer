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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 42 on Project Euler, http://projecteuler.net/index.php?section=problems&id=42
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem42 {
	
	private static List<String> words = new ArrayList<String>();
	
	private static Map<Long, Long> scoreMap = new HashMap<Long, Long>();

	/**
	 * The term is defined as T = (1/2)n(n+1)
	 * which gives the positive solution as, n = (-1 + sqrt(1 + 8T))/2
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<String> lines = FileUtils.readLines(42);

		for(String line : lines) {
			String tokens[] = line.split(",");
			if(tokens != null) {
				for(String token : tokens) {
					if(token.startsWith("\"")) {
						token = token.substring(1);
					}
					if(token.endsWith("\"")) {
						token = token.substring(0, token.length() - 1);
					}
					
					words.add(token);
				}
			}
		}
		
		// now for each name build the name score and store against that
		for(String word : words) {
			long score = getWordScore(word);
			if(scoreMap.containsKey(score)) {
				long totalWords = scoreMap.get(score);
				scoreMap.put(score, ++totalWords);
			} else {
				// this is the first word
				scoreMap.put(score, 1l);
			}
		}
		
		// now get a list of all keys of this map
		Set<Long> scores = scoreMap.keySet();
		long numWords = 0;
		for(Long score : scores) {
			double num = ((-1 + Math.sqrt(1 + 8 * score)) * 0.5);
			long truncated = (long) num;
			if(num == truncated) {
				numWords += scoreMap.get(score);
			}
		}
		
		// output
		System.out.println("Words: " + numWords);
	}

	/**
	 * @param name
	 * @param i
	 * @return
	 */
	private static long getWordScore(String name) {
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
