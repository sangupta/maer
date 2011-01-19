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
package org.myjerry.maer.page1;

/**
 * Problem 39 on Project Euler, http://projecteuler.net/index.php?section=problems&id=39
 *
 * @author Sandeep Gupta
 * @since Jan 18, 2011
 */
public class Problem39 {
	
	private static final int eulerLimit = 1000;

	/**
	 * p = a + b + c
	 * c^2 = a^2 + b^2
	 * a^2 + b^2 = (p - a - b)^2
	 * b = p(p - 2a)/2(p-a)
	 * ==> p(p-2a) MOD 2(p-a) == 0 when we have a triangle 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int maxTriangles = 0;
		int maxPerimeter = 0;
		
		for(int perimeter = 2; perimeter <= eulerLimit; perimeter += 2) {
			int triangles = 0;
			for(int side = 2; side < (perimeter / 4); side++) {
				if((perimeter * (perimeter - 2 * side)) % (2 * (perimeter - side)) == 0) {
					triangles += 1;
				}
				
				if(triangles > maxTriangles) {
					maxTriangles = triangles;
					maxPerimeter = perimeter;
				}
			}
		}
		
		System.out.println("Max triangles: " + maxPerimeter);
	}

}
