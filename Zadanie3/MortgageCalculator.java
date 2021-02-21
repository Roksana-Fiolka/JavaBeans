/**
 * Author - Jeanine Kimball
 * Mortgage Payment Calculator
 * Date 5/1/2011
 */

	/**
	 *  Write the program in Java (with a graphical user interface) and have it calculate
	 *  and display the mortgage payment amount from user input of the amount of the
	 *  mortgage, the term of the mortgage, and the interest rate of the mortgage.
	 *  Allow the user to loop back and enter new data or quit. Please insert comments
	 *  in the program to document the program.
	 */

import javax.swing.JFrame;
//import java.util.Scanner;

public class MortgageCalculator {

		public static void main(String[] args) {

			//Calls frame to display information
			JFrame frame = new MortgageCalculatorFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(450,400);
			frame.setVisible(true);

		}
}
