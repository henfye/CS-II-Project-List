package p2_package;

public class IndactanceCalculationClass
    {
     public static final char DASH = '-';
     public static final char DOUBLE_DASH = '=';
     public static final char PIPE = '|';
     public static final char CROSS = '+';
     
     public static final int TWO_ENDLINES = 2;
     public static final int PRECISION = 2;
     public static final int TABLE_WIDTH = 65;
     public static final int MEASURED_BLOCK_WIDTH = 20;
     public static final int NAME_BLOCK_WIDTH = 29;
     public static final int VALUE_BLOCK_WIDTH = 12;

     public static final String PIPE_SPACE = "| ";
     public static final String SPACE_PIPE = " |";
     public static final String CROSS_SPACE = "+ ";

     public static final double TWO_PI = 2.0 * Math.PI;
     
     public static void main( String[] args )
        {
        // initialize program
           
           // initialize variables
           Console_IO_Class conIO = new Console_IO_Class();
           Double current;
           Double resistance;
           Double frequency;
           Double capacitance;
           
           // show title, with underline
              // method: printString, printEndlines
           conIO.printString( "Indactance Calculation Program" );
           conIO.printEndline();
           conIO.printChars( NAME_BLOCK_WIDTH + 1, DOUBLE_DASH );
           conIO.printEndlines( TWO_ENDLINES );
           
        // get calculation information from the user
           
           // get the current (A) from user
              // method: promptForDouble
           current = conIO.promptForDouble( "  Enter Current        (A): " );
           
           // get the resistance (Ohms) from user
              // method: promptForDouble
           resistance = conIO.promptForDouble( "  Enter Resistance  (Ohms): " );
           
           // get the frequency (hz) from user
              // method: promptForDouble
           frequency = conIO.promptForDouble( "  Enter Frequency     (hz): " );
           
           // get the capacitance from user
              // method: promptForDouble
           capacitance = conIO.promptForDouble( "  Enter Capacitance    (F): "
                 );
           
        // conduct processing
           // indactance mathematics
           double numerator = current * resistance;
           double denominator = TWO_PI * frequency * capacitance;
           double indactance = numerator / denominator;
           
        // display information in table form
           
           // display top line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( TABLE_WIDTH - 2, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display table title
              // method: printChar, printString, printEndline
           conIO.printChar( PIPE );
           conIO.printString( "INDACTANCE CALCULATION PROGRAM",
                 TABLE_WIDTH - 2, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           
           // display divider line
              // method: printChar, printChars, printEndLine
           conIO.printChar( PIPE );
           conIO.printChars(TABLE_WIDTH - 2, DASH);
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display subtitle line
              // method: printChar, printString, printEndline
           conIO.printChar( PIPE );
           conIO.printString( "MEASURED", MEASURED_BLOCK_WIDTH, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printString( "NAME", NAME_BLOCK_WIDTH, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printString( "VALUE", VALUE_BLOCK_WIDTH, "CENTER" );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DOUBLE_DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display current value
              // method: printDouble, printString, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Current", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printDouble( current, PRECISION,  VALUE_BLOCK_WIDTH - 2,
                 "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display resistance value
              // method: printDouble, printString, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Resistance", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printDouble( resistance, PRECISION,  VALUE_BLOCK_WIDTH - 2,
                 "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display frequency value
              // method: printDouble, printString, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Laboratory", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Frequency", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printDouble( frequency, PRECISION,  VALUE_BLOCK_WIDTH - 2,
                 "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display capacitance value
              // method: printDouble, printString, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Field", MEASURED_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Capacitance", NAME_BLOCK_WIDTH - 1, "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printDouble( capacitance, PRECISION,  VALUE_BLOCK_WIDTH - 2,
                 "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndline();
           
           // display indactance value
              // method: printDouble, printString, printEndline
           conIO.printString( PIPE_SPACE );
           conIO.printString( "Calculated Result", MEASURED_BLOCK_WIDTH - 1,
                 "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printString( "Capacitive Indactance", NAME_BLOCK_WIDTH - 1,
                 "LEFT" );
           conIO.printString( CROSS_SPACE );
           conIO.printDouble( indactance, PRECISION,  VALUE_BLOCK_WIDTH - 2,
                 "RIGHT" );
           conIO.printString( SPACE_PIPE );
           conIO.printEndline();
           
           // display divider line
              // method: printChar, printChars, printEndline
           conIO.printChar( PIPE );
           conIO.printChars( MEASURED_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( NAME_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printChars( VALUE_BLOCK_WIDTH, DASH );
           conIO.printChar( PIPE );
           conIO.printEndlines(2);
           
        // end program
           
           // display end program
              // method: printString, printEndline
           conIO.printString( "End Program" );
           conIO.printEndline(); 
        }

    } 


