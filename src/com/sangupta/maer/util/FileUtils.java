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
package com.sangupta.maer.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * File utility operations.
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 01-Sep-2011
 */
public class FileUtils {
	
	public static List<String> readLines(int problemNumber) {
		String fileName = "src/com/sangupta/maer/dataFiles/problem" + String.valueOf(problemNumber) + ".txt";
		return readLines(fileName);
	}
	
	public static List<String> readLines(String filePath) {
		List<String> lines = new ArrayList<String>();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line;
			
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
			
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static int[][] readFileAsIntMatrix(int problemNumber, int rows, int columns) {
		List<String> lines = FileUtils.readLines(81);
		
		int[][] matrix = new int[rows][columns];
		
		for(int index = 0; index < 80; index++) {
			String line = lines.get(index);
			String[] numbers = line.split(",");
			
			for(int num = 0; num < numbers.length; num++) {
				int number = Integer.parseInt(numbers[num]);
				matrix[index][num] = number;
			}
		}		
		
		return matrix;
	}

}
