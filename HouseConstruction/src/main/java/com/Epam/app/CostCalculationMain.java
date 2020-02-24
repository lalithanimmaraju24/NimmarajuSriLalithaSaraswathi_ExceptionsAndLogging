package com.Epam.app;

import java.io.IOException;
import java.util.logging.Logger; 
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CostCalculationMain implements CostCalculation {

    private double area;
    private String sMaterial;
    private String auto;
    private Scanner scan;
    private Logger logger; 
    

    public CostCalculationMain() {
    	logger = Logger.getLogger( CostCalculationMain.class.getName()); 
        scan = new Scanner(System.in);
       
    }

    @Override
    public double calculateCost(double area, String choiceMaterial, String choiceAutomation) throws IOException {
    	Map<String,Integer> MY_MAP = new HashMap<String,Integer>();
        MY_MAP.put("normal standard materials no",1200);
        MY_MAP.put("above standard materials no",1500);
        MY_MAP.put("high standard materials no",1800);
        MY_MAP.put("high standard materials fully",1800);

    	String s = "";
        s = s + choiceMaterial + " standard materials " + choiceAutomation;
        double val = 0;
        try {

            val = MY_MAP.get(s) * area;
        } catch (Exception e) {
        }
        return val;
    }

    @Override
    public boolean read() throws IOException {

        Scanner scan = new Scanner(System.in);
        try {
        	 logger.info("Enter Material (normal or above or high ):\t");
             sMaterial = scan.nextLine();
            logger.info("Enter automatic ( fully or no ) :\t");
            auto = scan.nextLine();
            logger.info("Enter area :\t");
            area = scan.nextDouble();
        } catch (Exception e) {
        	 logger.info("Invalid input\n");
            return false;
        }
        return true;
    }

    @Override
    public void displayResultCost() throws IOException {
    	 logger.info("Total cost :\t");
    	 logger.info(String.valueOf(calculateCost(area, sMaterial, auto)) + "INR");
    }
}
