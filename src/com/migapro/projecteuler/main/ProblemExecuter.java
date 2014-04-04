package com.migapro.projecteuler.main;

import com.migapro.projecteuler.problems.Problem;

public class ProblemExecuter {

	/**
	 * @param args problem number
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			try {
				String problemNumber = convertToThreeDigits(args[0]);
				Class c = Class.forName("com.migapro.projecteuler.problems.Problem" + problemNumber);
				Problem problem = (Problem) c.newInstance();
				
				System.out.println(problemNumber + ": \n\n" + problem.solve());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Convert a number to 3 digits with 0's.
	 * This will allow the source files for problems to be listed in sequential order on github.
	 * @param number
	 * @return number in 3 digits (ex: 1 -> 001)
	 */
	private static String convertToThreeDigits(String number) {
		if (number.length() < 3) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 3 - number.length(); i++)
				builder.append("0");
			builder.append(number);
			
			number = builder.toString();
		}
		
		return number;
	}

}
