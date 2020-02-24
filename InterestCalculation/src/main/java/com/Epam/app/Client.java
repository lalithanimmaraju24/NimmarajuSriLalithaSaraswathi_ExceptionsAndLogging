package com.Epam.app;

import java.io.IOException;
import java.util.logging.Logger; 
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        Logger logger = Logger.getLogger(Client.class.getName()); 
        InterestCalculation intrcal = new InterestCalculationMain();
        try {
            intrcal.readInput();
            logger.info("\n1)Calculate simple interest.\n2)Calculate compound interest\nEnter your choice: ");
            int c = scan.nextInt();
            intrcal.displayResult(c);
        } catch (Exception e) {
        	logger.info("\nInvalid Input ");
        }
    }
}
