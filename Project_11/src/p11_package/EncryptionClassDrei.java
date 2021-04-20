package p11_package;

/**
 * Class uses linked list to encrypt text
 * 
 * @author MichaelL
 *
 */

public class EncryptionClassDrei
   {
    /**
     * Constant for one digit offset in calculations
     */
    private final int ONE_DIGIT_OFFSET = 10;
   
    /**
     * Constant for two digit offset in calculations
     */
    private final int TWO_DIGIT_OFFSET = 100;
   
    /**
     * Constant for one digit offset in calculations
     */
    private final int THREE_DIGIT_OFFSET = 1000;
   
    /**
     * Constant for minimum random iterations in encryption
     */
    private final int MIN_ITERATIONS = 3;
   
    /**
     * Constant for maximum random iterations in encryption
     */
    private final int MAX_ITERATIONS = 5;
   
    /**
     * Constant for minimum three digit random number
     */
    private final int THREE_DIGIT_LOW = 100;
   
    /**
     * Constant for maximum three digit random number
     */
    private final int THREE_DIGIT_HIGH = 999;
   
    /**
     * Constant for minimum two digit random number
     */
    private final int TWO_DIGIT_LOW = 10;
   
    /**
     * Constant for maximum two digit random number
     */
    private final int TWO_DIGIT_HIGH = 99;
   
    /**
     * Constant for caret character
     */
    private final char CARET_CHAR = '^';
   
    /**
     * Head reference for linked list
     */
    private NodeClass headRef;
    
    /**
     * Default constructor
     * <p>
     * Sets head reference to null
     */
    public EncryptionClassDrei()
       {
          // set headRef to null
        headRef = null;        
       }
    
    /**
     * Initialization constructor
     * <p>
     * Accepts and encrypts String parameter
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String value to be encrypted
     */
    public EncryptionClassDrei( String toEncrypt )
       {
          // call to encrypt input string
             // method: encryptString
        encryptString(toEncrypt);
       }
    
    /**
     * Copy constructor
     * <p>
     * Copies other linked list into this linked list, 
     * making duplicate with new data
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param copied EncryptionClassDrei object with linked list to be copied
     */
    public EncryptionClassDrei( EncryptionClassDrei copied )
       {
          // initialize method/variables
          NodeClass cpdRef;
          NodeClass wkgRef;
          
           // copy over the headref to THIS
             // method: NodeClass copy constructor
           this.headRef = new NodeClass(copied.headRef);
           
           // copy the copy head ref to another reference
           cpdRef = copied.headRef;
           
           // copy the this head ref to another reference
           wkgRef = this.headRef;
           
           // while the copied ref is not null continue looping
           while (cpdRef.nextRef != null)
              {
                 // set the copied ref to the next node in the list
                 cpdRef = cpdRef.nextRef;
                 
                 // copy the cpdRef to the next ref by creating a new node
                 // class
                 wkgRef.nextRef = new NodeClass(cpdRef);  
              }
       }
   
    /**
     * appendItem
     * <p>
     * Adds item to end of list, uses helper method
     * <p>
     * Dependencies: appendItemHelper
     * 
     * @param newVal long value to be appended to list
     */
    public void appendItem( long newVal )
       {
          // calls for appendItemHelper to append item
             // method: appendItemHelper
          headRef = appendItemHelper(headRef, newVal);
       }
    
    /**
     * appendItemHelper
     * <p>
     * Recursively iterates to end of list, then adds node
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param wkgRef NodeClass reference pointing to current node in recursion
     * 
     * @param newVal long value to be appended to list
     * 
     * @return NodeClass reference to most recent node in recursion
     */
    private NodeClass appendItemHelper( NodeClass wkgRef, long newVal )
       {
          // loop while wkgRef is not null
        if (wkgRef != null)
           {
              // recursively call appendItemHelper to get to the end of the 
              // linked list
                 // method: appendItemHelper
              wkgRef.nextRef = appendItemHelper(wkgRef.nextRef, newVal);
              
              // return the wkgRef to recursively fix the list
              return wkgRef;
           }
        
        // if wkgRef is not null, create it as a new node class
           // method: NodeClass copy constructor
        wkgRef = new NodeClass(newVal);
        
        // return the wkgRef back to appendItem
        return wkgRef; 
       }
    
    /**
     * decodeCharacter
     * <p>
     * Removes values encoded in long, reassembles and returns as character
     * <p>
     * Incoming character first digit is in the 7th position (000000x00, 
     * the second digit is in the fourth position (000x00000),
     * and the third digit is in the  first position (x00000000)
     * <p>
     * Dependencies: none
     * 
     * @param encodedLong long value holding encoded character value
     * 
     * @return value holding decoded character
     */
    private char decodeCharacter( long encodedLong )
       {
        // initialize variables
          long firstDigit;
          long secondDigit;
          long thirdDigit;
          long finalDigit;
          
          // get first digit 
          firstDigit = ((encodedLong % THREE_DIGIT_OFFSET) / TWO_DIGIT_OFFSET)
                * TWO_DIGIT_OFFSET;
          
          // get second digit
          secondDigit = ((encodedLong / (THREE_DIGIT_OFFSET * TWO_DIGIT_OFFSET))
                % ONE_DIGIT_OFFSET) * ONE_DIGIT_OFFSET;
          
          // get third digit
          thirdDigit = encodedLong / (THREE_DIGIT_OFFSET * THREE_DIGIT_OFFSET
                * TWO_DIGIT_OFFSET);
          
          // add all three together to get the 3 digit ascii code
          finalDigit = firstDigit + secondDigit + thirdDigit;
          
       // return 3 digit ascii cast as a char
        return (char) finalDigit;
       }
        
    /**
     * decryptList
     * <p>
     * Converts linked list of encoded integers into string
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param wkgRef NodeClass reference to uncloaked linked list
     * 
     * @return String result of processing
     */
    public String decryptList( NodeClass wkgRef )
       {
          // initialize merhod/variables
          String decryptedString = "";
          long tempLong;
          
          // loop while wkgRef node is not null
        while (wkgRef != null)
           {
              // move over wkgRef encrypred value to a temp variable
              tempLong = wkgRef.encryptedVal;
              
              // decode and add each decoded character onto the string
                 // method: decodeCharacter
              decryptedString += decodeCharacter(tempLong);
              
              // move the wkgRef onto the next node for the next loop around
              wkgRef = wkgRef.nextRef;
           }
       
        // once wkgRef has no more information, return the decrypted string
        return decryptedString;  // temporary stub return
       }
   
    /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays THIS linked list as series of numbers with a specified width
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( int width )
       {
          // initialize method/variables
          NodeClass wkgRef;
          long decryptChar;
          int index;

           // copy the this head ref to another reference
           wkgRef = this.headRef;
           
           // while the copied ref is not null continue looping
           while (wkgRef.nextRef != null)
              {
                 // loop through the width to get correct spacing
                 for (index = 0; index < width; index++)
                    {
                       // check again to make sure wkgRef is not null
                       if (wkgRef.nextRef != null)
                          {
                             // store the encrypted value into a temp variable
                             decryptChar = wkgRef.encryptedVal;
                             
                             // print out the encrypted value and its character
                                // method: system.out.print, decodeCharacter
                             System.out.print(wkgRef.encryptedVal + " ('" + 
                                decodeCharacter(decryptChar) + "') ");
                       
                             // set the copied ref to the next node in the list
                             wkgRef = wkgRef.nextRef;
                          }
                       }
                 // print out a new line for spacing
                    // method: System.out.println
                 System.out.println();
              }
       }
    
       /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays USER PROVIDED linked list as series of numbers 
     * with a specified width
     * 
     * @param wkgRef NodeClass reference starting at head of list
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( NodeClass wkgRef, int width )
       {
          // initialize method/variables
          long decryptChar;
          int index;
           
           // while the wkgRef is not null continue looping
           while (wkgRef.nextRef != null)
              {
                 // loop through width for spacing
                 for (index = 0; index < width; index++)
                    {
                       // check again if wkgRef is not null
                       if (wkgRef.nextRef != null)
                          {
                             // set wkgRef encrypted value to temp variable
                             decryptChar = wkgRef.encryptedVal;
                             
                             // print out the encrypted value and decoded 
                             // character 
                                // method: decodeCharacter, system.out.print
                             System.out.print(wkgRef.encryptedVal + " ('" + 
                                decodeCharacter(decryptChar) + "') ");
                       
                             // set the wkgRef to the next node in the list
                             wkgRef = wkgRef.nextRef;
                          }
                       }
                 // print out a new line for spacing
                    // method: system.out.println
                 System.out.println();
              }
       }
    
    /**
     * encodeCharacter
     * <p>
     * Sets three-digit character value into nine-digit long such that
     * the first digit is in the 7th position (000000x00), the second digit 
     * is in the fourth position (000x00000)and the third digit is in the 
     * first position (x00000000)
     * <p>
     * Dependencies: getRandBetween
     * 
     * @param encodeChar character value to be encoded
     * 
     * @return long value containing encoded character
     */
    public long encodeCharacter( char encodeChar )
       {
        // initialize method, variables
       
           // set the character to an integer
           int charInt = (int)encodeChar;
           
           // get the first/LSD digit
           int firstDigit = charInt % ONE_DIGIT_OFFSET;
           
           // declare other variables
           int thirdDigit, secondDigit;
           long resultLong;
        
        // divide off first digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture second digit
        secondDigit = charInt % ONE_DIGIT_OFFSET;
        
        // divide off second digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture third digit
        thirdDigit = charInt;
        
        // set first digit in long value
           // method: getRandBetween
        resultLong = firstDigit * TWO_DIGIT_OFFSET 
                              + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH );
        
        // set second digit in long value
           // method: getRandBetween
        resultLong = secondDigit * TWO_DIGIT_OFFSET 
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH ) 
                                               + resultLong * THREE_DIGIT_OFFSET;
        
        // set third digit in long value
           // method: getRandBetween
        resultLong = thirdDigit * TWO_DIGIT_OFFSET
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH )
                                               + resultLong * THREE_DIGIT_OFFSET;
        // return long value
        return resultLong;
       }
    
    /**
     * encryptString
     * <p>
     * Generates random groups of values in linked list,
     * then places caret and next character,
     * repeats this process until end of string,
     * then adds one more random group
     * <p>
     * Each random group has a random number between 3 and 5 values
     * which are themselves random
     * <p>
     * Dependencies: .length, charAt, getRandBetween, generateNineDigitRandom,
     * encodeCharacer, appendItem
     * 
     * @param toEncrypt String value to be encrypted to linked list
     */
    public void encryptString( String toEncrypt )
       {
        // initialize method, variables
        int index = 0;
        int randIndex, numIterations;
        long nineDigitRand, charLongValue;
        char encodeChar;
        
        // loop to end of string
           // method: .length
        while( index < toEncrypt.length() )
           {
            // create number of random iterations
               // method: getRandBetween
            numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
            
            // loop across random iterations
            for( randIndex = 0; randIndex < numIterations; randIndex++ )
               {
                // create dummy number
                   // method: generateNineDigitRandom
                nineDigitRand = generateNineDigitRandom();
                
                // add item to linked list
                   // method: appendItem
                appendItem( nineDigitRand );
               }           
            // end loop
           
            // create value for caret
               // method: encodeCharacter
            charLongValue = encodeCharacter( CARET_CHAR );
            
            // add caret to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // get next character to encrypt
               // method: .charAt
            encodeChar = toEncrypt.charAt( index );
            
            // create value for new character
               // method: encodeCharacter
            charLongValue = encodeCharacter( encodeChar );
            
            // add item to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // increment loop index
            index++;
           }
        // end loop
        
        // add one more series of random values
        
           // create number of random iterations
              // method: getRandBetween
           numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
                
           // loop across random iterations
           for( randIndex = 0; randIndex < numIterations; randIndex++ )
              {
               // create new random value
                  // method: generateNineDigitRandom
               nineDigitRand = generateNineDigitRandom();
               
               // add value to linked list
                  // method: appendItem
               appendItem( nineDigitRand );
              }           
           // end loop
       }    
   
    /**
     * generateNineDigitRandom
     * <p>
     * Generates a nine digit random value for cloaking encrypted data
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return nine digit random long
     */
    private long generateNineDigitRandom()
       {
        // initialize method/variables
          long randValueOne;
          long randValueTwo;
          long randValueThree;
          long nineDigitRandom;
          
          // 
          randValueOne = getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH);
          randValueTwo = getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH);
          randValueThree = getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH);
          
          nineDigitRandom = randValueOne + randValueTwo * THREE_DIGIT_OFFSET + 
                randValueThree * THREE_DIGIT_OFFSET * THREE_DIGIT_OFFSET;
          
          
       
        return nineDigitRandom;  // temporary stub return
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
    private int getRandBetween( int low, int high )
       {
        // initialize method, variables
       
           // create range value
           int range = high - low + 1;
   
        // find random within range, inclusive, return
           // method: Math.random
        return (int)( Math.random() * range + low );
       }
    
    /**
     * isCharacter
     * <p>
     * Returns Boolean true if node holds specified character,
     * false otherwise
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param testRef NodeClass reference to given node
     * 
     * @param testChar character value to be tested in node
     * 
     * @return Boolean result of specified test
     */
    private boolean isCharacter( NodeClass testRef, char testChar )
       {
          // initialize method/variables
          long testLong = testRef.encryptedVal;
          
          // if decoded character of input long number equals the test char
        if (decodeCharacter(testLong) == testChar)
           {
              return true;
           }
       
        // else, return false
        return false;  // temporary stub return
       }
    
    /**
     * uncloakList
     * <p>
     * Removes all random and caret nodes from linked list, 
     * linked list with encoded integers/characters remains
     * <p>
     * Dependencies: isCharacter
     * 
     * @return NodeClass reference to newly created linked list
     * containing only the encoded text letters
     */
    public NodeClass uncloakList()
       {
        // initialize method, variables
       
           // set working reference to head reference
           NodeClass wkgRef = headRef;
           
           // set other references to null
           NodeClass wkgResultRef = null, resultRef = null;
        
        // loop to end of linked list   
        while( wkgRef != null )
           {
            // search for caret
               // method: isCharacter
            while( wkgRef != null && !isCharacter( wkgRef, CARET_CHAR ) )
               {
                // skip ahead in linked list
                wkgRef = wkgRef.nextRef;               
               }
            
            // check for caret found (not null)
            if( wkgRef != null )
               {
                // skip over caret
                wkgRef = wkgRef.nextRef;
                
                // check for result reference null (empty)
                if( resultRef == null )
                   {
                    // set result reference to working reference
                    resultRef = wkgRef;
                    
                    // set a working result reference to the result reference
                    wkgResultRef = resultRef;
                   }
                
                // otherwise, assume result reference already has data
                else
                   {
                    // link the newest found character node
                    //   to the working result reference
                    wkgResultRef.nextRef = wkgRef;
                    
                    // advance the working result reference
                    wkgResultRef = wkgResultRef.nextRef;
                   }
               }
           }
        // end loop across linked list
        
        // set end for working result reference
        wkgResultRef.nextRef = null;
        
        // return result reference
        return resultRef;
       }
   }
