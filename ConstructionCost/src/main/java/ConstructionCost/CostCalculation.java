package ConstructionCost;

import java.io.IOException;
public interface CostCalculation {
	double calculateCost(String area, String choiceMaterial, String choiceAutomation) throws IOException;
}