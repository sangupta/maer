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

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 59 on Project Euler, http://projecteuler.net/index.php?section=problems&id=59
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 07-Sep-2011
 */
public class Problem59 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sumOfMessage = 0;
		
		// read the numbers from file in an array
		String line = FileUtils.readLines(59).get(0);
		String tokens[] = line.split(",");
		
		final int messageLength = tokens.length;
		
		char[] numbers = new char[messageLength];
		for(int index = 0; index < messageLength; index++) {
			int number = Integer.parseInt(tokens[index]);
			numbers[index] = (char) number;
		}
		
		final String message = String.valueOf(numbers);

		// start processing by using the key as 'aaa' to 'zzz'
		boolean found = false;
		for(char c1 = 'a'; c1 <= 'z'; c1++) {
			for(char c2 = 'a'; c2 <= 'z'; c2++) {
				for(char c3 = 'a'; c3 <= 'z'; c3++) {
					String key = String.valueOf(c1) + String.valueOf(c2) + String.valueOf(c3);
					
					StringBuilder builder = new StringBuilder(messageLength);
					final int bucketSize = messageLength / 3;
					for(int index = 0; index < bucketSize; index++) {
						builder.append(key);
					}
					final int remain = messageLength % 3;
					switch(remain) {
						case 1:
							builder.append(c1);
							break;
							
						case 2:
							builder.append(c1);
							builder.append(c2);
							break;
					}
					
					String builtUpKey = builder.toString();
					
					sumOfMessage = decipherMessage(message, builtUpKey, messageLength);
					if(sumOfMessage != 0) {
						found = true;
						break;
					}
				}
				
				if(found) {
					break;
				}
			}
			
			if(found) {
				break;
			}
		}
		
		System.out.println("Sum of message: " + sumOfMessage);
	}

	private static long decipherMessage(String message, String key, int length) {
		char[] deciphered = new char[length];
		
		for(int index = 0; index < length; index++) {
			deciphered[index] = (char) (message.charAt(index) ^ key.charAt(index));
		}
		
		String decipheredMessage = String.valueOf(deciphered);
		
		if(decipheredMessage.contains(" the ")) {
			System.out.println("Deciphered message: " + decipheredMessage);
			long sum = 0;
			for(char c : deciphered) {
				sum += c;
			}
			return sum;
		}
		
		return 0;
	}

}
