package model;

public class CalculatorModel {
	private float num1, num2;
	private String operator;

	public CalculatorModel() {
	}

	public CalculatorModel(float num1, float num2, String operator) { 
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}


	public String getOperator() { 
		return operator;
	}

	public void setOperator(String operator) { 
		this.operator = operator;
	}

	public float getNum1() { 
		return num1;
	}

	public void setNum1(float num1) { 
		this.num1 = num1;
	}

	public float getNum2() { 
		return num2;
	}

	public void setNum2(float num2) { 
		this.num2 = num2;
	}

	public float calculate() {
		if (operator.equals("+")) {
			return num1 + num2;
		}
		if (operator.equals("-")) {
			return num1 - num2;
		}
		if (operator.equals("/")) {
			return num1 / num2;
		}
		return num1 * num2;
	}

	@Override
	public String toString() {
		return num1 + " " + operator + " " + num2 + " = " + calculate();
	}

}
