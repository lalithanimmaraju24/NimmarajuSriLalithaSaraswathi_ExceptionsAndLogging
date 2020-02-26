package ConstructionCost;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class CostCalculationMain implements  CostCalculation {

	    private OutputStreamWriter streamWriter;
	    private final Logger log = LogManager.getLogger(this.getClass().getName());

	    public CostCalculationMain() {
	        log.info("CostCalculationimpl constructor is called");
	        streamWriter = new OutputStreamWriter(System.out);
	        log.info("Exited CostCalculationimpl constructor");
	    }
	        

		@Override
		public double calculateCost(String area, String choiceMaterial, String choiceAutomation) throws IOException {
			Map<String,Integer> MY_MAP = new HashMap<String,Integer>();
	        MY_MAP.put("normal standard materials no",1200);
	        MY_MAP.put("above standard materials no",1500);
	        MY_MAP.put("high standard materials no",1800);
	        MY_MAP.put("high standard materials fully",1800);
			log.info("Entered calculateCost() ");
	        String s = "";
	        s = s + choiceMaterial + " standard materials " + choiceAutomation;
	        double val = 0;
	        double a=0;
	        try {
	            a=Double.valueOf(area);
	            val = MY_MAP.get(s) * a;
	            log.info("Exit from calculateCost() ");
	        } catch (Exception e) {
	           streamWriter.write("Invalid input");
	           streamWriter.flush();
	           log.error("Invalid input");
	        }
	        return val;
	    }
		

	}
