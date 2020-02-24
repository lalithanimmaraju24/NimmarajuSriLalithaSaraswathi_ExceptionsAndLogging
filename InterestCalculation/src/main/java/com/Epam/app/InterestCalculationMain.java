package com.Epam.app;



import java.io.IOException;
import java.util.logging.Logger; 
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterestCalculationMain implements InterestCalculation {
    private InterestComponents val;
    private calculation cal;
    private Logger logger;

    public InterestCalculationMain() {
    	logger = Logger.getLogger(InterestCalculationMain.class.getName()); 
    }

    @Override
    public double calculateSimpleInterest(InterestComponents val) {
        cal = new SimpleInterest();
        return cal.calculate(this.val);
    }

    @Override
    public void displayResult(int c) throws IOException {

        if (c == 1) {
        	logger.info("simple interest is ");

        	logger.info(String.valueOf(calculateSimpleInterest(this.val)));
        } else if (c == 2) {
        	logger.info("compound interest is ");
        	logger.info(String.valueOf(calculateCompoundInterest(this.val)));
        } else {
        	logger.info("Invalid choice");
        }
    }

    @Override
    public void readInput() throws IOException {
    	logger.info("Enter principle value :\t");
        Scanner scan = new Scanner(System.in);
        try {
            double principle = scan.nextDouble();
            logger.info("Enter rateInPercent value :\t");
            double rateInPercent = scan.nextDouble();
            logger.info("Enter timeInYears value :\t");
            double timeInYears = scan.nextDouble();
            this.val = new InterestComponents(principle, rateInPercent, timeInYears);
        } catch (InputMismatchException e) {
        	logger.info("Invalid input type");
            throw e;
        }
    }

    @Override
    public double calculateCompoundInterest(InterestComponents val) {
        cal = new CompoundInterest();
        return cal.calculate(this.val);
    }
}
