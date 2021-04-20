package p5_package;

public class PolyMultiplierClass_II_S4
   {
      // constants used in formatting the program
      public static final char DOUBLE_DASH = '=';   
      public static final int TWO_ENDLINES = 2;
      
      //constants used for deciding the degree of the polynomial
      public static final int DEGREE_ONE = 1;
      public static final int DEGREE_TWO = 2;
      public static final int DEGREE_THREE = 3;
      
      // initialize console io globally
      public static final Console_IO_Class conIO = new Console_IO_Class();
      
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
        int degreeForm;
        int coefA = 0;
        int coefB = 0;
        int coefC = 0;
        int coefD = 0;
        int coefE = 0;
        int coefF = 0;
        boolean incorrectDegrees = false;
        int outputCoefA = 0;
        int outputCoefB = 0;
        int outputCoefC = 0;
        int outputCoefD = 0;
        int outputCoefE = 0;
         
         // show title and underline
            // method: printString, printChars, printEndline, printEndlines
         conIO.printString( "Polynomial Calculator, Part Deux" );
         conIO.printEndline();
         conIO.printChars( 32, DOUBLE_DASH );
         conIO.printEndlines( TWO_ENDLINES );
         
         //Explain the program
            // what the program does
               // method: printString, printEndline
         conIO.printString( "Multiplies a first degree polynomial" );
         conIO.printEndline();
         
            //shows a first degree form
               // method: printString, printEndline
         conIO.printString( "   by a first degree form: "
               + "( ax + b ) * ( cx + d )" );
         conIO.printEndline();
         
            // shows a second degree form
               // method: printString, printEndline
         conIO.printString( "   or by a second degree form: ( ax + b ) * "
               + "( cx^2 + dx + e )" );
         conIO.printEndline();
         
            // shows a third degree form
               // method: printString, printEndline
         conIO.printString( "   or by a third degree form: ( ax + b ) * "
               + "( cx^3 + dx^2 + ex + f)" );
         conIO.printEndline();
         
            // lets the user know it changes on their selection
               // method: printString, printEndlines
         conIO.printString( "depending on user selection" );
         conIO.printEndlines( TWO_ENDLINES );
         
      // get coefficients/degree form from user
         
         // get degree form from user
            // method: promptForInt
         degreeForm = conIO.promptForInt("Enter degree form (1-3): ");
         
         // boolean flag in the case that the user does not put in correct num
         if (degreeForm < DEGREE_ONE || degreeForm > DEGREE_THREE )
            {
               incorrectDegrees = true;
            }
         
         // begins if statements prompting for coefficients as long as 
         // the correct degree was input
         if (!incorrectDegrees)
            {
               // get coefficient A
                  // method: promptForInt
               coefA = conIO.promptForInt( "Enter Coefficient A: " );
               
               // get coefficient B
                  // method: promptForInt
               coefB = conIO.promptForInt( "Enter Coefficient B: " );
               
               // get coefficient C
                  // method: promptForInt
               coefC = conIO.promptForInt( "Enter Coefficient C: " );
               
               // get coefficient D
                  // method: promptForInt
               coefD = conIO.promptForInt( "Enter Coefficient D: " );
               
               // grabs other coefficients depending on input from user
               if (degreeForm == DEGREE_TWO || degreeForm == DEGREE_THREE)
                  {
                     // get coefficient E if two or three degree polynomial
                        // method: promptForInt
                     coefE = conIO.promptForInt("Enter Coefficient E: ");
                     
                     // gets last coefficient if of degree 3
                     if (degreeForm == DEGREE_THREE)
                        {
                           // get coefficient F if three degree polynomial
                              // method: promptForInt
                           coefF = conIO.promptForInt("Enter Coefficient F: ");
                        }
                  }
               // prints endline for spacing
                  // method printEndline
               conIO.printEndline();
            }
         
         // if the polynomial degree was incorrectly input, tell the user that
         // and then abort the program
            // method: printEndline, printEndlines, printString
         else
            {
               conIO.printEndline();
               conIO.printString("Incorrect number of polynomial degrees entered - Program Aborted");
               conIO.printEndlines(TWO_ENDLINES);
            }
             
         
      // process the polynomials
         
         // again check for correctly input degrees
         if (!incorrectDegrees)
            {
               // calculates first output, same for all 3 degrees
               outputCoefA = coefA * coefC;
               
               // calculates outputs if of degree one
               if (degreeForm == DEGREE_ONE)
                  {
                     // calculate output coefficient B
                     outputCoefB = coefA * coefD + coefB * coefC;
                     
                     // calculate output coefficient C
                     outputCoefC = coefB * coefD;
                  }
               
               // calculates outputs if of degree two
               else if (degreeForm == DEGREE_TWO)
                  {
                     // calculate output coefficient B
                     outputCoefB = coefA * coefD + coefB * coefC;
                     
                     // calculate output coefficient C
                     outputCoefC = coefA * coefE + coefB * coefD;
                     
                     // calculate output coefficient D
                     outputCoefD = coefB * coefE;
                  }
               
               // calculates outputs if of degree three
               else
                  {
                     // calculate output coefficient B
                     outputCoefB = coefA * coefD + coefB * coefC;
                     
                     // calculate output coefficient C
                     outputCoefC = coefA * coefE + coefB * coefD;
                     
                     // calculate output coefficient D
                     outputCoefD = coefA * coefF + coefB * coefE;
                     
                     // calculate output coefficient E
                     outputCoefE = coefB * coefF;
                  }
            }
      
      // display results to user
         // again, only displays if correct degrees chosen
         if (!incorrectDegrees)
            {
               // prints out the beginning of the results
               conIO.printString("Result: ");
               conIO.printEndline();
               
               // display polynomial result if of degree one
                  // method: printString
               if (degreeForm == DEGREE_ONE)
                  {
                     conIO.printString("( " + coefA + "x + " + coefB + " )*( " 
                  + coefC + "x + " + coefD + " ) = " + outputCoefA + "x^2 + " 
                           + outputCoefB + "x + " + outputCoefC);
                  }
               
               // display polynomial result if of degree two
                  // method: printString
               else if (degreeForm == DEGREE_TWO)
                  {
                     conIO.printString("( " + coefA + "x + " + coefB + " )*( " 
                  + coefC + "x^2 + " + coefD + "x + " + coefE + ") = " 
                  + outputCoefA + "x^3 + " + outputCoefB + "x^2 + " 
                  + outputCoefC + "x + " + outputCoefD);
                  }
               
               // display polynomial result if of degree three
                  // method: printString
               else
                  {
                     conIO.printString("( " + coefA + "x + " + coefB + " )*( "
                  + coefC + "x^3 + " + coefD + "x^2 + " + coefE + "x + " 
                  + coefF + ") = " + outputCoefA + "x^4 + " + outputCoefB 
                  + "x^3 + " + outputCoefC + "x^2 + " + outputCoefD + "x + " 
                  + outputCoefE);
                  }
               
               // print endlines for formatting
                  // method printEndlines
               conIO.printEndlines(TWO_ENDLINES);
            }
         
      // end program
         
         // display program end
            // method: printString, printEndline
         conIO.printString("End Program");
         conIO.printEndline();
      }
   }
