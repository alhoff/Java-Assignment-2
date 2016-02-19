/****************************************************************
 This program asks the user to enter 3 floating point values, 
 then determines the following: the sum, average, product, 
 smallest, largest, range, and median of these values. It then
 calculates the quotient of the largest divded by smallest. 
 The results are displayed to the user drawn as strings 
 inside of a rectangle.
 ****************************************************************/


import java.awt.Graphics;       // program uses class Graphics
import javax.swing.JApplet;     // program uses class JApplet
import javax.swing.JOptionPane; // program uses class JOptionPane


public class Applet extends JApplet
{

    private double sum, average, product, smallest, largest, range, median, quotient; // values to be calculated using values provided by user; quotient will be largest/smallest
    private double number1, number2, number3; //values to be provided by user
    
    
    // initialize applet by obtaining values from user
    public void init()
    {
        String firstNumber;  // first string entered by user
        String secondNumber; // second string entered by user
        String thirdNumber; // third string entered by user
        
        
        // obtain first number from user
        firstNumber = JOptionPane.showInputDialog( "Enter first floating-point value" );
        
        // obtain second number from user
        secondNumber = JOptionPane.showInputDialog( "Enter second floating-point value" );
        
        // obtain third number from user
        thirdNumber = JOptionPane.showInputDialog( "Enter third floating-point value" );
        
        // convert numbers from type String to type double
        number1 = Double.parseDouble( firstNumber );
        number2 = Double.parseDouble( secondNumber );
        number3 = Double.parseDouble( thirdNumber );
        
        // call method sumNumber and place returned value into sum
        sum = sumNumber(number1, number2, number3);
        
        // call method averageNumber and place returned value into average
        average = averageNumber(number1, number2, number3);
        
        // call method productNumber and place returned value into product
        product = productNumber(number1, number2, number3);
        
        // call method smallestNumber and place returned value into smallest
        smallest = smallestNumber(number1, number2, number3);
        
        // call method largestNumber and place returned value into largest
        largest = largestNumber(number1, number2, number3);
        
        // call method medianNumber and place returned value into median
        median = medianNumber(number1, number2, number3);
        
        // call method rangeNumber and place returned value into range
        range = rangeNumber(largest, smallest);
        
        // call method quotientNumber and place returned value into quotient
        quotient = quotientNumber(largest, smallest);
        
        
    } // end method init
    
    
    
    // sum of numbers method
    public static double sumNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double sum = num1 + num2 + num3; // sum is set to the result of the addition of all three numbers
        
        return sum; // return sum value
        
    } // end method sumNumber
    
    
    
    // average of numbers method
    public static double averageNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double average = (num1 + num2 + num3) / 3; // average is set to the result of the addition of all three numbers followed by division by the amount of numbers
        
        return average; // return average value
        
    } // end method averageNumber
    
    
    
    // product of numbers method
    public static double productNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double product = num1 * num2 * num3; // product is set to the result of the multiplication of all three numbers
        
        return product; // return product value
        
    } // end method productNumber
    
    
    
    // smallest number method
    public static double smallestNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double smallest = num1; // variable smallest is created which tentatively holds the value of num1
        
        if (num2 < smallest) // check if num2 is less than current smallest
        {
            smallest = num2; // smallest becomes num2
        }
        
        if (num3 < smallest) // check if num3 is less than current smallest
        {
            smallest = num3; // smallest becomes num3
        }
        return smallest; // return smallest value
        
    } // end method smallestNumber
    
    
    
    // largest number method
    public static double largestNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double largest = num1; // variable largest is created which tentatively holds the value of num1
        
        if (num2 > largest) // check if num2 is greater than current largest
        {
            largest = num2; // largest becomes num2
        }
        
        if (num3 > largest) // check if num3 is greater than current largest
        {
            largest = num3; // largest becomes num3
        }
        return largest; // return largest value
        
    } // end method largestNumber
    
    
    
    // median of numbers method
    public static double medianNumber(double num1, double num2, double num3) // method is passed three user values
    {
        double large, small, median; // variables created to be used to determine median
        
        if (num1 > num2) // check if num1 is greater than num2
        {
            large = num1; // num1 becomes large if it is greater than num2
            small = num2; // num2 becomes small if num1 is greater
        }
        else
        {
            large = num2; // num2 becomes large if it is not less than num1
            small = num1; // num1 becomes small if it is not greater than num2
        }
        
        if (num3 > large) // check if num3 is greater than current large
        {
            median = large; // if num3 is greater than current large, current large must be in middle of the three numbers and is thus the median
        }
        else if (num3 < small) // check if num3 is less than current small
        {
            median = small; // if num3 is less than current small, current small must be in the middle of the three numbers and is thus the median
        }
        else // if num3 is not greater than large nor less than small, it must be the median
        {
            median = num3;
        }
        
        return median; // return median value
        
    } // end method medianNumber
    
    
    
    // range of numbers method
    public static double rangeNumber(double largest, double smallest) // method is passed largest and smallest
    {
        double range = largest - smallest; // range is set to the result of largest subtracted by smallest
        
        return range; // return range value
        
    } // end method rangeNumber
    
    
    
    // quotient of largest divided by smallest method
    public static double quotientNumber(double largest, double smallest) // method is passed largest and smallest
    {
        double quotient = largest / smallest; // quotient is set to the result of largest divided by smallest
        
        return quotient; // return quotient value
        
    } // end method quotientNumber
    

    
    // draw results in a rectangle on applet's background
    public void paint( Graphics g )
    {
        super.paint( g ); // call superclass version of method paint
        
        // draw rectangle starting from (15, 10) that is 360
        // pixels wide and 185 pixels tall
        g.drawRect( 15, 10, 360, 185 );
        
        // convert number1, number2, and number3 into strings to format to 2 decimal places
        String stringNumber1 = String.format("%.2f", number1);
        String stringNumber2 = String.format("%.2f", number2);
        String stringNumber3 = String.format("%.2f", number3);
        // draw stringNumber1, stringNumber2, and stringNumber3 as a string at (25, 25)
        g.drawString( "The numbers entered are " + stringNumber1 + ", " + stringNumber2 + ", and " + stringNumber3, 25, 25 );
        
        // convert sum into string to format to 2 decimal places
        String stringSum = String.format("%.2f", sum);
        // draw stringSum as a string at (25, 45)
        g.drawString( "The sum is " + stringSum, 25, 45 );
        
        // convert product into string to format to 2 decimal places
        String stringProduct = String.format("%.2f", product);
        // draw stringProduct as a string at (25, 85)
        g.drawString( "The product is " + stringProduct, 25, 65 );
        
        // convert largest into string to format to 2 decimal places
        String stringLargest = String.format("%.2f", largest);
        // draw stringLargest as a string at (25, 125)
        g.drawString( "The largest is " + stringLargest, 25, 85 );
        
        // convert smallest into string to format to 2 decimal places
        String stringSmallest = String.format("%.2f", smallest);
        // draw stringSmallest as a string at (25, 105)
        g.drawString( "The smallest is " + stringSmallest, 25, 105 );
        
        // convert average into string to format to 2 decimal places
        String stringAverage = String.format("%.2f", average);
        // draw stringAverage as a string at (25, 65)
        g.drawString( "The average is " + stringAverage, 25, 125 );
        
        // convert median into string to format to 2 decimal places
        String stringMedian = String.format("%.2f", median);
        // draw stringMedian as a string at (25, 145)
        g.drawString( "The median is " + stringMedian, 25, 145 );
        
        // convert range into string to format to 2 decimal places
        String stringRange = String.format("%.2f", range);
        // draw stringRange as a string at (25, 165)
        g.drawString( "The range is " + stringRange, 25, 165 );
        
        // convert quotient into string to format to 2 decimal places
        String stringQuotient = String.format("%.2f", quotient);
        // draw stringQuotient as a string at (25, 185)
        g.drawString( "The quotient of the largest divided by smallest is " + stringQuotient, 25, 185 );
        
    } // end method paint
    
    
    
} // end class Applet