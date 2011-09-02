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
package com.sangupta.maer.page3;

import java.util.ArrayList;
import java.util.List;

import com.sangupta.maer.util.FileUtils;

/**
 * Problem 1 on Project Euler, http://projecteuler.net/index.php?section=problems&id=1
 *
 * @author <a href="http://www.sangupta.com">Sandeep Gupta</a>
 * @since 02-Sep-2011
 */
public class Problem102 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines(102);
		
		List<Triangle> triangles = new ArrayList<Problem102.Triangle>(1000);
		for(String line : lines) {
			triangles.add(new Triangle(line));
		}
		
		int count = 0;
		for(Triangle triangle : triangles) {
			if(triangle.containsOrigin()) {
				count++;
			}
		}
		
		System.out.println("Triangles containing origin: " + count);
	}
	
	private static class Triangle {
		public int x1, y1;
		public int x2, y2;
		public int x3, y3;
		
		public Triangle(String line) {
			String[] tokens = line.split(",");
			if(tokens.length == 6) {
				int i = 0;
				x1 = Integer.parseInt(tokens[i++]);
				y1 = Integer.parseInt(tokens[i++]);
				
				x2 = Integer.parseInt(tokens[i++]);
				y2 = Integer.parseInt(tokens[i++]);
				
				x3 = Integer.parseInt(tokens[i++]);
				y3 = Integer.parseInt(tokens[i++]);
			}
		}

		/**
		 * @return
		 */
		public boolean containsOrigin() {
			if(x1 < 0 && x2 < 0 && x3 < 0) {
				return false;
			}

			if(x1 > 0 && x2 > 0 && x3 > 0) {
				return false;
			}

			if(y1 < 0 && y2 < 0 && y3 < 0) {
				return false;
			}

			if(y1 > 0 && y2 > 0 && y3 > 0) {
				return false;
			}
			
			return pointInsideTriangle(0, 0, x1, y1, x2, y2, x3, y3);
		}
		
		private boolean pointInsideTriangle(int px, int py, int x1, int y1, int x2, int y2, int x3, int y3) {
		    int o1 = getOrientationResult(x1, y1, x2, y2, px, py);
		    int o2 = getOrientationResult(x2, y2, x3, y3, px, py);
		    int o3 = getOrientationResult(x3, y3, x1, y1, px, py);

		    return (o1 == o2) && (o2 == o3);
		}

		private int getOrientationResult(int x1, int y1, int x2, int y2, int px, int py) {
		    double orientation = ((x2 - x1) * (py - y1)) - ((px - x1) * (y2 - y1));
		    if (orientation > 0) {
		        return 1;
		    }
		    else if (orientation < 0) {
		        return -1;
		    }
		    else {
		        return 0;
		    }
		}
	}

}
