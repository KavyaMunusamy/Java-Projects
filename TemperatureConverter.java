import java.util.Scanner;

public class TemperatureConverter{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Fahrenheit to Celsius (1) or Celsius to Fahrenheit (2) :");
        int num = sc.nextInt();
        if (num == 1){   // fahrenheit to celsius
            System.out.println("You have chosen Fahrenheit to Celsius converter!");
            System.out.println("Enter Fahrenheit value: ");
            double val1 = sc.nextDouble();
            double result1 = (val1-32)*5/9;
            System.out.println("Celsius is : " + result1);
            System.out.println("Rounded Celsius Degree : "+ Math.round(result1*10.0)/10.0);
            
        }
        else if(num == 2){  // celsius to fahrenheit
            System.out.println("You have chosen Celsius to Fahrenheit converter!");
            System.out.println("Enter Celsius value: ");
            double val2 = sc.nextDouble();
            double result2 = val2 * 1.8 + 32;  // 9/5 = 1.8
            System.out.println("Fahrenheit is : " + result2);
            System.out.println("Rounded Fahrenheit Degree : " + Math.round(result2*10.0)/10.0);
            
        }
        else{
            System.out.println("Invalid choice number!!");
        }
    }
}