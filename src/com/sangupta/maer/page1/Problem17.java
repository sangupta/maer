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

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 17 on Project Euler, http://projecteuler.net/index.php?section=problems&id=17
 * 
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 6, 2011
 */
public class Problem17 {
	
	private static final int eulerLimit = 1000;
	
	private static final Map<Integer, String> numbers = new HashMap<Integer, String>();
	
	static {
		numbers.put(0, "zero");
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
		numbers.put(7, "seven");
		numbers.put(8, "eight");
		numbers.put(9, "nine");
		numbers.put(10, "ten");
		numbers.put(11, "eleven");
		numbers.put(12, "twelve");
		numbers.put(13, "thirteen");
		numbers.put(14, "fourteen");
		numbers.put(15, "fifteen");
		numbers.put(16, "sixteen");
		numbers.put(17, "seventeen");
		numbers.put(18, "eighteen");
		numbers.put(19, "nineteen");
		
		numbers.put(20, "twenty");
		numbers.put(30, "thirty");
		numbers.put(40, "forty");
		numbers.put(50, "fifty");
		numbers.put(60, "sixty");
		numbers.put(70, "seventy");
		numbers.put(80, "eighty");
		numbers.put(90, "ninety");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for(int i = 1; i <= eulerLimit; i++) {
			sum += getCharactersInSentence(getNumberAsWords(i));
		}
		
		System.out.println("Sum of all characters: " + sum);
	}

	/**
	 * @param numberAsWords
	 * @return
	 */
	private static long getCharactersInSentence(String numberAsWords) {
		numberAsWords = numberAsWords.replaceAll(" ", "");
		numberAsWords = numberAsWords.replaceAll("-", "");
		return numberAsWords.length();
	}

	/**
	 * @param i
	 * @return
	 */
	private static String getNumberAsWords(int i) {
		if(i <= 20) {
			return numbers.get(i);
		}
		
		if(i > 20 && i < 100) {
			int div = (i / 10) * 10;
			int remain = i % 10;
			if(remain == 0) {
				return numbers.get(div);
			}
			return numbers.get(div) + "-" + numbers.get(remain);
		}
		
		if(i < 1000) {
			int hundred = i / 100;
			int remain = i % 100;
			if(remain == 0) {
				return numbers.get(hundred) + " hundred";
			}
			return numbers.get(hundred) + " hundred and " + getNumberAsWords(remain);
		}
		
		if(i < 10000) {
			int thousand = i / 1000;
			int remain = i % 1000;
			if(remain == 0) {
				return numbers.get(thousand) + " thousand";
			}
			
			return numbers.get(thousand) + " thousand " + getNumberAsWords(remain);
		}
		
		return null;
	}

}
