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

import java.util.List;

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 99 on Project Euler, http://projecteuler.net/index.php?section=problems&id=99
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 07-Sep-2011
 */
public class Problem99 {
	
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines(99);
		
		int lineNumber = 0;
		double max = 0;
		
		for(int index = 0; index < lines.size(); index++) {
			String line = lines.get(index);
			String tokens[] = line.split(",");
			int number = Integer.parseInt(tokens[0]);
			int power = Integer.parseInt(tokens[1]);
			
			double log = Math.log(number) * ((double) power);
			if(max < log) {
				max = log;
				lineNumber = index + 1; // line numbers start with 1
			}
		}
		
		System.out.println("Line number with max numerical value: " + lineNumber);
	}

}
