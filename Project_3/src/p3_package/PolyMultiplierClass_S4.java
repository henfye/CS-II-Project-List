package p3_package;

public class PolyMultiplierClass_S4
   {
      public static final char DOUBLE_DASH = '=';
      public static final int TWO_ENDLINES = 2;
      
      public static void main( String[] args )
      {
      // initialize program
         
         // initialize variables
         Console_IO_Class conIO = new Console_IO_Class();
         int coefA;
         int coefB;
         int coefC;
         int coefD;
         int polynomialA;
         int polynomialB;
         int polynomialC;
         
         // show title
            // method: printString, printChars, printEndline, printEndlines
         conIO.printString( "Polynomial Calculator" );
         conIO.printEndline();
         conIO.printChars( 21, DOUBLE_DASH );
         conIO.printEndlines( TWO_ENDLINES );
         
         // explain what program does
            // method: printString, printEndline, printEndlines
         conIO.printString( "Multiplies two polynomial expressions" );
         conIO.printEndline();
         conIO.printString( "  in the form: ( ax + b ) * ( cx + d )" );
         conIO.printEndlines( TWO_ENDLINES );
         
      // get coefficients from user
         
         // get coefficient a
            // method: promptForInt
         coefA = conIO.promptForInt( "Enter coefficient a: " );
         
         // get coefficient b
            // method: promptForInt
         coefB = conIO.promptForInt( "Enter coefficient b: " );
         
         // get coefficient c
            // method: promptForInt
         coefC = conIO.promptForInt( "Enter coefficient c: " );
         
         // get coefficient d
            // method: promptForInt printEndline
         coefD = conIO.promptForInt( "Enter coefficient d: " );
         conIO.printEndline();
         
      // process the multiplication of the polynomials
         
         // calculate the coefficient of the x^2
               // method: printEndline
         polynomialA = coefA * coefC;
         
         
         // calculate the coefficient of the x
         polynomialB = ( coefA * coefD ) + ( coefB * coefC );
         
         // calculate the constant in the polynomial
         polynomialC = coefB * coefD;
         
      // display the results to the user
         
         // display the input polynomial and the multiplied output
            // method: printString, printDouble, printChar, printEndlines
         conIO.printString( "Result:" );
         conIO.printEndline();
         conIO.printString( "( " + coefA + "x + " + coefB + " )*"
               + "( " + coefC + "x + " + coefD + " ) = " + polynomialA 
               + "x^2 + " + polynomialB + "x + " + polynomialC );
         conIO.printEndlines( TWO_ENDLINES );
         
      // end program
         
         // display program end 
            // method: printString, printEndline
         conIO.printString( "Program End" );
         conIO.printEndline();
         
      }

   }
