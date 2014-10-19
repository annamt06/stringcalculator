package is.ru.stringcalculator;

public class Calculator {


	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text, ","));
		}
		else if(text.contains("\n")){
			return sum(splitNumbers(text, "/"));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delim){
	    return numbers.split(delim);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){

        	if(number.contains(",")){
        		total += sum(splitNumbers(number, ","));
        	}
        	else if(number.contains("\n")){
        		total += sum(splitNumbers(number, "\n"));
        	}
        	else
        	{
        		total += toInt(number);
        	}
		}
		return total;
    }


}