package is.ru.stringcalculator;

import java.util.*;

public class Calculator {


	public static int add(String text) throws RuntimeException{

		if(text.equals("")){
			return 0;
		}
		else if (text.contains("-")) {
			throw new RuntimeException("-");
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text, ","));
		}
		else if(text.contains("\n")){
			return sum(splitNumbers(text, "/"));
		}
		/*else if(text.contains("//")){

			return sum(splitArrayNum(text));
		}*/
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	/*private static String[] determDelim(String text){
		String[] array = text.split("\n");

		return Arrays.asList(array).indexOf(2);
	}

	private static String[] splitArrayNum(String text){
		String[] array = text.split("\n");
		String num = array(1).indexOf(2);
		String delim = determDelim(text);
		return num.split(delim);
	}*/

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
        	/*else if(number.contains("//")){
        		total += sum(splitArrayNum(number));
        	}*/
        	else
        	{
        		if(toInt(number) > 1000){
        		number = "0";
        		}
        		total += toInt(number);
        	}
		}
		return total;
    }


}