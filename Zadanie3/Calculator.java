

public class Calculator {
	// Variables for input
	double loanAmount = 0;				// Amount of loan
	int yearTerm = 0;					// Loan term in years
	double interestRate = 0;			// Interest rate of loan

	// Instance variables
	double numberPayments = 0;
	double monthlyPayment = 0;

	public double setLoanAmount(double aLoanAmount) { // method to set loan amount
		return loanAmount = aLoanAmount;
	}
	public double getLoanAmount() { // method to retrieve loan amount
		return loanAmount;
	}

	public int setYearTerm(int yearTerm2) { // method to set loan term
		return yearTerm = yearTerm2;
	}
	public int getYearTerm() { // method to retrieve loan term
		return yearTerm;
	}

	public double setInterestRate(double aInterestRate) { // method to set interest rate
		return interestRate = aInterestRate;
	}
	double getInterestRate() { // method to set interest rate
		return interestRate;
	}

	protected double getMonthlyPayment() { // method to calculate monthly payment
		return monthlyPayment = loanAmount * (((interestRate/100)/12) / (1 - Math.pow(1 + (interestRate/100)/12, - (yearTerm * 12))));

	}
}
