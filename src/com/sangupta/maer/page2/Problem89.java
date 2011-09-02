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
import com.sangupta.maer.util.RomanNumberUtil;

/**
 * Problem 89 on Project Euler, http://projecteuler.net/index.php?section=problems&id=89
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since Jan 8, 2011
 */
public class Problem89 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<String> lines = FileUtils.readLines(89);
		int original = 0, reduced = 0;
		
		for(String line : lines) {
			original += line.length();
			reduced += RomanNumberUtil.reduce(line).length();
		}
		
		System.out.println("Saved=" + (original - reduced));
	}

}
