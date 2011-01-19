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
package org.myjerry.maer.page2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 79 on Project Euler, http://projecteuler.net/index.php?section=problems&id=79
 *
 * @author Sandeep Gupta
 * @since Jan 9, 2011
 */
public class Problem79 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String path = "c:/keylog.txt";
		
		List<String> passcodes = new ArrayList<String>();
		
		// read the attempts
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			passcodes.add(line);
		}

		// analyze the pass-codes and build the unique password
		String[] codes = passcodes.toArray(new String[] { });
		
		String finalCode = codes[0];
		
		for(int index = 1; index < codes.length; index++) {
			String code = codes[index];
			
			// does the code digits occur in passcode
			int lastIndex = -1;
			for(int i = 0; i < code.length(); i++) {
				char c = code.charAt(i);
				int found = finalCode.indexOf(c, lastIndex); 
				if(found != -1) {
					// insert this just after the given position
					lastIndex = found; 
					continue;
				}

				if(lastIndex != -1) {
					String before = finalCode.substring(0, lastIndex);
					String after = finalCode.substring(lastIndex);

					// see if this digit occurs in the string before
					int previous = before.indexOf(c); 
					if(previous != -1) {
						// yes it does, bring the last digit before it
						String rebuilt = before.substring(0, previous) + after.substring(0, 1) + before.substring(previous) + after.substring(1);
						finalCode = rebuilt;
					} else {
						// no it does not
						finalCode = before + c + after;
					}
				} else {
					finalCode += c;
				}
			}
			
		}

		System.out.println("Code=" + finalCode);
	}
}
