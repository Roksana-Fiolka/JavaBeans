import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;



@SuppressWarnings("serial")
public class MortgageCalculatorFrame extends JFrame {

	private JPanel gridLayout = new JPanel();

	DecimalFormat Currency = new DecimalFormat("$#,##0.00");

	//Set fields
	JTextField loanField;
	JTextField termField;
	JTextField rateField;
	JTextField paymentField;

	//Set buttons
	JButton submit;
	JButton reset;

	//Create panel
	JPanel panel;

	//Initiate variables
	public double loanAmount;
	public int yearTerm;
	public double interestRate;

	public MortgageCalculatorFrame() {
		super("Mortgage Calculator"); //Adds title to app frame

		// Set layout
        gridLayout.setLayout(new BorderLayout());
        gridLayout.add(this.instructionPanel(), BorderLayout.NORTH);
        gridLayout.add(this.labelPanel(), BorderLayout.WEST);
        gridLayout.add(this.fieldsPanel(), BorderLayout.CENTER);
        gridLayout.add(this.buttonPanel(), BorderLayout.SOUTH);
        add(gridLayout);
	}

	private JPanel instructionPanel() {
		//Create instruction labels
		JLabel submitLabel = new JLabel("Enter information, then click on Submit to get monthly payment amount.");
		JLabel resetLabel = new JLabel("Click on Reset to start over.");
		JLabel closeLabel = new JLabel("To exit the program, click on the X of the frame.");

		//Add instruction labels
		JPanel instruct = new JPanel();
		instruct.setLayout(new GridLayout(5,5));
		instruct.add(submitLabel);
		instruct.add(resetLabel);
		instruct.add(closeLabel);

		return instruct;
	}

	private JPanel labelPanel() {
		//Create labels
		JLabel loanLabel = new JLabel("Loan Amount: ");
		JLabel termLabel = new JLabel("Year Term: ");
		JLabel rateLabel = new JLabel("Interest Rate: ");
		JLabel paymentLabel = new JLabel("Monthly Payment Amount: ");

		//Add labels
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(9,2));
		labels.add(loanLabel);
		labels.add(termLabel);
		labels.add(rateLabel);
		labels.add(paymentLabel);

		return labels;
	}

	private JPanel fieldsPanel() {
		//Create fields
		loanField = new JTextField();
		loanField.setEditable(true);
		termField = new JTextField();
		termField.setEditable(true);
		rateField = new JTextField();
		rateField.setEditable(true);
		paymentField = new JTextField();
		paymentField.setEditable(false);

		//Add fields
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(9,2));
		fields.add(loanField);
		fields.add(termField);
		fields.add(rateField);
		fields.add(paymentField);

		return fields;
	}

	private JPanel buttonPanel() {
		//Create buttons
		submit = new JButton("Submit");
		submit.addActionListener(new submitListener());
		reset = new JButton("Reset");
		reset.addActionListener(new resetListener());

		//Add buttons
		JPanel buttons = new JPanel();
		buttons.add(submit);
		buttons.add(reset);

		return buttons;
	}

		//Inner class to display payment when user clicks on Submit button
		class submitListener implements ActionListener {
			Calculator frameCalculator = new Calculator();
			public void actionPerformed(ActionEvent event) {

				//Convert field values from strings to numbers for the calculation
				String loanAmountString = loanField.getText();
				Double loanAmountDouble = new Double(loanAmountString);
				loanAmount = loanAmountDouble.doubleValue();
				loanAmount = frameCalculator.setLoanAmount(loanAmount);

				String yearTermString = termField.getText();
				Double yearTermInt = new Double(yearTermString);
				yearTerm = yearTermInt.intValue();
				yearTerm = frameCalculator.setYearTerm(yearTerm);

				String interestRateString = rateField.getText();
				Double interestRateDouble = new Double(interestRateString);
				interestRate = interestRateDouble.doubleValue();
				interestRate = frameCalculator.setInterestRate(interestRate);

				//Display monthly payment within the field
				paymentField.setText(Currency.format(frameCalculator.getMonthlyPayment()));
			}
		}

		//Inner class to clear fields when user clicks on Reset button
		class resetListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				loanField.setText("");
				termField.setText("");
				rateField.setText("");
				paymentField.setText("");
			}
		}
}
