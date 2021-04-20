package p10_package;

/**
 * Class encrypts, stores, and decrypts messages encoded and stored in an array 
 * of long integers
 * 
 * @author MichaelL
 *
 */
public class EncryptionClassDeux
   {
    /**
     * Default capacity for square array
     */
    private final String DEFAULT_STRING = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constant for decoding first three digits of long
     */
    private final int THREE_DIGIT_OFFSET = 1000;
    
    /**
     * Constant for decoding second three digits of long
     */
    private final int SIX_DIGIT_OFFSET = 1000000;

    /**
     * Constant for decoding third three digits of long
     */
    private final int NINE_DIGIT_OFFSET = 1000000000;

    /**
     * Constant for random index lower limit
     */
    private final int RAND_LOWER_LIMIT = 10;

    /**
     * Constant for random index upper limit
     */
    private final int RAND_UPPER_LIMIT = 99;

    /**
     * Constant for minimum string size
     */
    private final int MIN_STRING_LENGTH = 15;

    /**
     * Constant indicating used value
     */
    private final int USED_CODE = 1;

    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_LOW = 2;
    
    /**
     * Constant indicating unused value
     */
    private final int UNUSED_CODE_HIGH = 9;
    
    /**
     * Constant indicating control code for number only
     */
    public static final int ENUM_NUMBER_ONLY = 1001;
    
    /**
     * Constant indicating control code for character only
     */
    public static final int ENUM_CHARACTER_ONLY = 2002;
    
    /**
     * Constant indicating control code for both number and character
     */
    public static final int ENUM_BOTH = 3003;
    
    /**
     * Constant indicating tilde character
     */
    private final char TILDE_CHAR = '~';
    
    /**
     * Constant indicating caret character
     */
    private final char CARET_CHAR = '^';
    
    /**
     * Constant indicating space character
     */
    private final char SPACE_CHAR = ' ';
    
    /**
     * Constant indicating caret character
     */
    private final char RIGHT_CURLY_BRACE_CHAR = '}';
    
    /**
     * data array
     */
    private long array[][];
    
    /**
     * side capacity for square array
     */
    private int sideCapacity;
    
    /**
     * Default constructor
     * <p>
     * Creates an array with DEFAULT_STRING "abcdefghijklmnopqrstuvwxyz" 
     * and sets all the elements in it to random characters
     * <p>
     * Dependencies: createArray
     */
    EncryptionClassDeux()
       {
        array = createArray( DEFAULT_STRING );
       }
    
    /**
     * Initialization constructor 
     * <p>
     * Captures and encrypts string
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String object holding data to be encrypted
     * 
     */
    EncryptionClassDeux( String toEncrypt )
       {
        encryptString( toEncrypt );
       }
    
    /**
     * Copy constructor 
     * <p>
     * Dependencies: None
     * 
     * @param copied EncryptionClassDeux object to be copied into this object
     * 
     */
    EncryptionClassDeux( EncryptionClassDeux copied )
       {
          // initialize method/variables
          int counter;
          
          // copy over numBits
          this.sideCapacity = copied.sideCapacity;
          
          
          // start for loop that copies over each element of the array one by
          // one until completed
          for (counter = 0; counter < sideCapacity; counter++)
             {
                // copy over copied array to this array
                this.array[counter] = copied.array[counter];
             }
       }
    
    /**
     * Create array
     * <p>
     * Finds length of string to be encrypted; 
     * if string is less than MIN_STRING_LENGTH, 
     * length is set to MIN_STRING_LENGTH;
     * either way string length is then doubled
     * <p>
     * Finds the square root of the updated string length and sets side capacity; 
     * creates local array, then calls fillArray which sets all the elements 
     * in the array to random characters other than tilde ('~')
     * <p>
     * Returns local array to calling method
     * <p>
     * Dependencies: {String}.length, Math.sqrt, fillArray
     * 
     * @param setUpString string used to find and process string length
     * 
     * @return array [][] of long values
     */
    private long [][] createArray( String setUpString )
       {
        // initialize method/variables
        int strLen = setUpString.length();        
        long [][] tempArr;
        
        // check for string length less than MIN_STRING_LENGTH
        if( strLen < MIN_STRING_LENGTH )
           {
            // set string length to MIN_STRING_LENGTH
            strLen = MIN_STRING_LENGTH; 
           }
        
        // double length of string
        strLen *= 2;
        
        // calculate side capacity
           // method: .sqrt
        sideCapacity = (int)( Math.sqrt( strLen ) );
        
        // crate new array
        tempArr = new long[ sideCapacity ][ sideCapacity ];
        
        // fill array with random
           // method: fillArray
        tempArr = fillArray( tempArr );
                
        // return array reference
        return tempArr;
       }
    
    /**
     * displayArray
     * <p>
     * Depending on control code, array is displayed one of three ways: 
     * NUMBER_ONLY: displays array of long values; CHARACTER_ONLY: displays
     * encoded characters; BOTH: displays both numbers and characters
     * <p>
     * Uses System.out.format
     * <p>
     * Dependencies: System.out.println, System.out.format, getCharValue
     * 
     * @param ctrlCode integer control code to indicate kind of display
     */
    public void displayArray( int ctrlCode )
       {
          // initialize method/variables
          int yIndex;
          int xIndex;
          
          // start for loop for y locations
          for (yIndex = 0; yIndex < sideCapacity; yIndex++)
             {
                // start for loop for x locations
                for (xIndex = 0; xIndex < sideCapacity; xIndex++)
                   {
                      // check what kind of print code is input, if either num
                      // only or both continue
                      if (ctrlCode == ENUM_NUMBER_ONLY || ctrlCode == ENUM_BOTH)
                         {
                            // print out the number 
                               // method: system.out.format
                            System.out.format("%d", array[yIndex][xIndex]);
                            
                            // if there is a print code that wants both, also
                            // print out the character next to the number
                            if (ctrlCode == ENUM_BOTH)
                               {
                                  // print out the character with a space,
                                  // parentheses, and apostrophe
                                     // method: system.out.format
                                  System.out.format("%s" + "('" + "%s" + "')" 
                                     + "%s", SPACE_CHAR, 
                                     getCharValue(array[yIndex][xIndex]), 
                                     SPACE_CHAR);
                               }
                         }
                      
                      // if the user only wants the character, print out just
                      // the character
                      else
                         {
                            // print out the character in the array
                               // method: system.out.format
                            System.out.format("%s", getCharValue(array[yIndex]
                                  [xIndex]));
                         }    
                   }
                // print out a line for formatting
                   // methodL system.out.println
                System.out.println();
             }
       }
    
    /**
     * decryptArray
     * <p>
     * Finds the tilde in the array, and tracks the elements of the array
     * to set the individual character values back into a String; 
     * list of characters ends with a caret ('^')
     * <p>
     * Dependencies: findTilde, getNextXPos, getNextYPos, getCharValue
     * 
     * @return String value containing decrypted text
     */
    public String decryptString()
       {
          // initialize method/variables
        long tildeNum;
        int nextXPos;
        int nextYPos;
        String tempStr = "";
        
        // find the long number the tilde is in and store that number
           // method: findTilde
        tildeNum = findTilde();
        
        // while the number being checked is not a caret, continue
           // method: getCharValue
        while (getCharValue(tildeNum) != CARET_CHAR)
           {
              // grab next x position from long number
                 // method: getNextXPos
              nextXPos = getNextXPos(tildeNum);
              
              // grab next y position from long number
                 // method: getNextYPos
              nextYPos = getNextYPos(tildeNum);
              
              // set the long number equal to the next location that was
              // pointed to by the previous
              tildeNum = array[nextYPos][nextXPos];
              
              // if the charValue of these two coordinates is a caret or tilde, 
              // do not add the caret to the string
                 // method: getCharValue
              if (getCharValue(array[nextYPos][nextXPos]) != TILDE_CHAR && 
                    getCharValue(array[nextYPos][nextXPos]) != CARET_CHAR)
                 {
                    // add on all of the chars to a string to create the 
                    // decrypted string
                       // method: getCharValue
                    tempStr += getCharValue(array[nextYPos][nextXPos]);
                 }
              // reset the long number to the next x and y coordinates for the
              // next loop around
              tildeNum = array[nextYPos][nextXPos];
           }
        
        // return the decoded string
        return tempStr;
       }
    
    /**
     * elementIsUsed
     * <p>
     * Returns true if element is used in the array, or if the current y position
     * is equal to the next y position and the current x position is equal to
     * the next x position
     * <p>
     * Dependencies: None
     * 
     * @param curYPos integer current y position to be tested
     * 
     * @param curXPos integer current x position to be tested
     * 
     * @param nextYPos integer next y position to be tested
     * 
     * @param nextXPos integer next x position to be tested
     * 
     * @return Boolean value indicating state of specified testing
     */
    private boolean elementIsUsed( int curYPos, 
                                       int curXPos, int nextYPos, int nextXPos )
       {
          // check if the current x and y positions are equal to the next x and
          // y position and also check if the next location in the array has
          // a number in it already
        if (curYPos == nextYPos && curXPos == nextXPos|| array[nextYPos]
              [nextXPos] / NINE_DIGIT_OFFSET == USED_CODE)
           {
              return true;
           }
        
        // the element is not used then return false
        return false; 
       }

    /**
     * encodeData
     * <p>
     * Encodes four parts of data into long value as ucccyyyxxx
     * where u is the used flag
     * ccc is the character Unicode/ASCII value
     * yyy is the y position of an element
     * xxx is the x position of an element
     * <p>
     * Dependencies: None
     * 
     * @param used integer value indicating that the value is part 
     * of the encrypted string, which is encoded into the long value
     * 
     * @param dataChar character value encoded into the long value
     * 
     * @param yPos integer value encoded into the long value
     * 
     * @param xPos integer value encoded into the long value
     * 
     * @return long value containing encoded data
     */
    public long encodeData( int used, char dataChar, int yPos, int xPos )
       {
        // initialize method/variables
        long dataValue;
        long longUsed = used;
        long scaledUsed;
        long scaledCharAscii;
        long scaledYPos;
        
        // scale up all of the necessary values to create one number with the
        // form ucccyyyxxx
        scaledUsed = longUsed * NINE_DIGIT_OFFSET;
        
        // turn dataChar into its int and multiply to its offset
        scaledCharAscii = (int) dataChar * SIX_DIGIT_OFFSET;
        
        // get the y position's offset 
        scaledYPos = yPos * THREE_DIGIT_OFFSET;
        
        // add all values together to get ucccyyyxxx
        dataValue = scaledUsed + scaledCharAscii + scaledYPos + xPos;
       
        // return the long encoded value
        return dataValue;
       }
    
    /**
     * encryptString
     * <p>
     * Creates array using the input string which also fills array with random 
     * characters, then places characters randomly around the array starting 
     * with a tilde ('~') and ending with a caret ('^')
     * <p>
     * Each long value in the array holds a used marker, the character,
     * and the y and x position of the next character
     * <p>
     * Process generates a new random y, x pair for each character data element
     * but verifies that the y, x pair has not already been used; once these
     * are found, the long value is encoded with the used marker, the character,
     * and the next y, x positions, and placed into the array
     * <p>
     * Dependencies: {String}.length, {String}.charAt, createArray, 
     * getRandBetween, encodeData, elementIsUsed
     * 
     * @param toEncrypt String value to be encrypted
     */
    public void encryptString( String toEncrypt )
       {
        // initialize method/variables
        long encodeVal;
        int currentYPos, currentXPos;
        int nextYPos, nextXPos;        
        int strIndex, strLen;
        char postChar = TILDE_CHAR;

        // place caret character at end of string
        toEncrypt += CARET_CHAR;
        
        // get string length
           // method: .length
        strLen = toEncrypt.length();
        
        // create array
           // method: createArray
        array = createArray( toEncrypt );

        // get random values for first (tilde) character
           // method: getRandBetween
        currentYPos = getRandBetween( 0, sideCapacity - 1 );
        currentXPos = getRandBetween( 0, sideCapacity - 1 );

        // loop across string
        for( strIndex = 0; strIndex < strLen; strIndex++ )
           {
            // loop until unique y and x positions
            do
               {
                // set potential next y pos
                   // method: getRandBetween
                nextYPos = getRandBetween( 0, sideCapacity - 1 );
                
                // set potential next x pos
                   // method: getRandBetween
                nextXPos = getRandBetween( 0, sideCapacity - 1 );
                
                // encode value into long
                   // method: encodeData
                encodeVal = encodeData( USED_CODE, 
                                               postChar, nextYPos, nextXPos );
               }
            // end loop if element or previous indices are not already used
               // method: elementIsUsed
            while( elementIsUsed( currentYPos, 
                                            currentXPos, nextYPos, nextXPos ) );

            // place encoded value in array
            array[ currentYPos ][ currentXPos ] = encodeVal;
            
            // set current y and x positions to processed next ones
            currentYPos = nextYPos;            
            currentXPos = nextXPos;
            
            // set new character to be encrypted
               // method: .charAt
            postChar = toEncrypt.charAt( strIndex );
           }
        
        // set last value to last character (tilde)
           // method: encodeData
        encodeVal = encodeData( USED_CODE, postChar, currentYPos, currentXPos );
        
        // set last element
        array[ currentYPos ][ currentXPos ] = encodeVal;
       }
    
    /**
     * fillArray
     * <p>
     * Fills temporary array with a random value between UNUSED_CODE_LOW and 
     * UNUSED_CODE_HIGH, a random character other than tilde ('~'), and a 
     * randomly generated y and x location between RAND_LOWER_LIMIT and
     * RAND_UPPER_LIMIT 
     * <p>
     * Dependencies: getRandBetween, getRandomChar, encodeData
     * 
     * @param arrayToFill long [][] array to be filled with random data
     * 
     * @return long [][] array with specified random values
     */
    public long [][] fillArray( long [][] arrayToFill )
       {
          // initialize method/variables
          int randValue;
          char randChar;
          int randX;
          int randY;
          long encodedData;
          int yIndex;
          int xIndex;
          
          // start for loop for all of the columns
          for (yIndex = 0; yIndex < sideCapacity; yIndex++)
             {
                // start for loop for the rows 
                for (xIndex = 0; xIndex < sideCapacity; xIndex++)
                   {
                   // find a random value between RAND_LOWER_LIMIT and RAND_UPPER_LIMIT
                      // method: getRandBetween
                   randValue = getRandBetween(UNUSED_CODE_LOW, UNUSED_CODE_HIGH);
                   
                   // find a random character
                      // method: getRandomChar
                   randChar = getRandomChar();
                 
                   // find a random x value
                      // method: getRandBetween
                   randX = getRandBetween(RAND_LOWER_LIMIT, RAND_UPPER_LIMIT);
                   
                   // find a random y value
                      // method: getRandBetween
                   randY = getRandBetween(RAND_LOWER_LIMIT, RAND_UPPER_LIMIT);
                   
                   // encode all of the random values found in a long 10 digit
                   // number
                      // method: encodeData
                   encodedData = encodeData(randValue, randChar, randY, randX );
                   
                   // fill in the random long into each and ever index of the
                   // array
                   arrayToFill[yIndex][xIndex] = encodedData;  
                   } 
             }
          
          // return the newly filled array
          return arrayToFill;
       }
    
    /**
     * findTilde
     * <p>
     * Finds tilde encoded in two dimensional array of long values
     * <p>
     * Dependencies: getCharValue, encodeData
     * 
     * @return long encoded value containing UNUSED_CODE_LOW, TILDE_CHAR,
     * and the y and x locations of the TILDE_CHAR
     */
    private long findTilde()
       {
          // initialize method/variables
          int yIndex;
          int xIndex;
          char charValue;
          long encodedNum;
        
          // begin loop across rows
          for (yIndex = 0; yIndex < sideCapacity; yIndex++ )
             {
                // begin loop across columns
                for (xIndex = 0; xIndex < sideCapacity; xIndex++)
                   {
                      // find the charValue at each index in the entire array
                         // method: getCharValue
                      charValue = (char) getCharValue(array[yIndex][xIndex]);
                      
                      // if this charValue is the tilde, then return the 
                      // long value at that location in the array
                      if (charValue == TILDE_CHAR)
                         {
                            // once tilde is found, encode the data of its
                            // location
                               // method: encodeData
                            encodedNum = encodeData(UNUSED_CODE_LOW, 
                                  TILDE_CHAR, yIndex, xIndex);
                            
                            // return the tilde long number
                            return encodedNum;
                         }
                   }
             }
          // return 0 if no tilde is found
          return 0;
       }
    
    /**
     * getCharValue
     * <p>
     * decodes long integer to return character
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded character to retrieve
     * 
     * @return character retrieved
     */
    private char getCharValue( long encoded )
       {
          // initialize method/variables
          long decoded;
        
          // find the ascii value by dividing by 1000000 and mod by 1000
          decoded = (encoded / SIX_DIGIT_OFFSET) % THREE_DIGIT_OFFSET;
        
          // return the ascii value as a char
          return (char) decoded;
       }
    
    /**
     * getRandBetween
     * <p>
     * Returns random value between low and high parameters, inclusive
     * <p>
     * Dependencies: Math.random
     * 
     * @param low integer value indicating low end of random range to generate
     * 
     * @param high integer value indicating high end of random range to generate
     * 
     * @return random value between low and high parameters, inclusive
     */
    public int getRandBetween( int low, int high )
       {
        // initialize method/variables
        // set range
        int range = high - low + 1;
        
        // return randomly generated value within range
           // method: .random
        return (int)( Math.random() * range + low );
       }

    /**
     * getRandomChar
     * <p>
     * Returns a Unicode/ASCII character from space (lowest printable character)
     * to right curly brace (highest printable character before tilde); 
     * tilde ('~') is never returned
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return value containing random character
     */
    private char getRandomChar()
       {
        // initialize method/variables
        int randomVal;
        
        // set random value
           // method: getRandBetween
        randomVal = getRandBetween( (int)SPACE_CHAR, 
                                                  (int)RIGHT_CURLY_BRACE_CHAR );
        
        // return random value as character
        return (char)randomVal;
       }
    
    /**
     * getNextXPos
     * <p>
     * Returns the next x position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded x location to retrieve
     * 
     * @return int x location retrieved
     */
    private int getNextXPos( long encoded )
       {
          // initialize method/variables
          int decoded;
        
          // find the next x position by taking the long encoded value
          // with mod 1000. Then store in decoded variable
          decoded = (int) encoded % THREE_DIGIT_OFFSET;

          // return decoded x value
          return decoded;
       }

   /**
     * getNextYPos
     * <p>
     * Returns the y position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded y location to retrieve
     * 
     * @return int y location retrieved
     */
    private int getNextYPos( long encoded )
       {
          // initialize method/variables
           int decoded;
           
           // find the next y position by taking the long encoded value
           // and dividing by 1000. Then modulo by 1000 to get the yyy portion.
           decoded = ((int) encoded / THREE_DIGIT_OFFSET) % THREE_DIGIT_OFFSET; 
           
           // return the decoded y value
           return decoded;
       }

   }
