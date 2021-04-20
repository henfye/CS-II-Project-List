package p9_project;


public class BinaryAdderClass
   {
      
      private final int DEFAULT_CAPACITY = 50;
      private final char SPACE = ' ';
      private final int BASE_TWO = 2;
      
      private int[] bitArray;
      int numBits;
      
      /*
      Name: BinaryAdderClass (default constructor)
      Process: sets up the empty array and number of bits for an empty class
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      public BinaryAdderClass()
      {
         // initialize bitArray and numBits
         bitArray = new int[DEFAULT_CAPACITY];
         numBits = 0;
      }
      
      /*
      Name: BinaryAdderClass (initialization constructor)
      Process: converts int value into bits and stores them in array, as well
               as setting the number of bits, calls convertToBinary
      Method Input/Parameters: decimal value integer
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: converToBinary
      */
      public BinaryAdderClass(int decimalValue)
      {
         // calls converToBinary for the bitArray
            // method: covertToBinary
         bitArray = convertToBinary(decimalValue);
      }
      
      /*
      Name: BinaryAdderClass (copy constructor)
      Process: copies the array and number of bits from another object into
               the local (this) object
      Method Input/Parameters: BinaryAdderClass object
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      public BinaryAdderClass(BinaryAdderClass copied)
      {
         // initialize method/variables
         int counter;
         
         // copy over numBits
         this.numBits = copied.numBits;
         
         // change size for bitArray to the number of bits
         this.bitArray = new int[numBits];
         
         // start for loop that copies over each element of the array one by
         // one until completed
         for (counter = 0; counter < numBits; counter++)
            {
               this.bitArray[counter] = copied.bitArray[counter];
            }
      }
      
      /*
      Name: addValue (overloaded)
      Process: Creates a new BinaryAdderClass object and calls addValue to it
      Method Input/Parameters: integer
      Method Output/Parameters: none
      Method Output/Returned: BinaryAdderClass object
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: addValue
      */
      public void addValue(int decimalValue)
      {
         // create new BinaryAdderClass object
            // method: BinaryAdderClass, addValue
         BinaryAdderClass addend = new BinaryAdderClass(decimalValue);
         addValue(addend);
      }
      
      /*
      Name: addValue (overloaded)
      Process: take in a BinaryAdderClass parameter and conducts the binary
               addition of the parameter and local object. Must locate the
               least significant digit at index zero in the array to aid in
               addition
      Method Input/Parameters: BinaryAdderClass
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: findMax
      */
      public void addValue(BinaryAdderClass addend)
      {
         // initialize method/variables
         int index = 0;
         int carry = 0;
         int tempValue = 0; 
         int arrayBitsOne = addend.numBits;
         int arrayBitsTwo = this.numBits;
         
         
         // find max of the two bit string lengths
            // method: findMax
         int max = findMax(arrayBitsOne, arrayBitsTwo);
         
         // initialize a new array based on this max
         int[] sumArray = new int[max+1];
         
         
         // loop until max num digits
         for (index = 0; index < max+1; index++)
            {
               // reset the temp value to 0
               tempValue = 0;
               
            // check for index less than nD for array
               if(index < arrayBitsOne)
                  {
                  // add the bit from this array element to the temp sum
                     tempValue += addend.bitArray[index];
                  }
               // check for index less than nd for second array
               if(index < arrayBitsTwo)
                  {
                     // add the bit from this other array to the temp sum
                     tempValue += this.bitArray[index];
                  }
               
               // add the carry bit
               tempValue += carry;
               
               // find the sum digit from the modulo, assign it to the new array
               // at the same index
               sumArray[index] = tempValue % BASE_TWO;
               
               // find the carry depending on if tempValue is divisible by 2
               carry =  tempValue / BASE_TWO;
            }
         // after loop is done, check for an extra carry
         if (carry > 0)
            {
               // add in carry to array if needed
               sumArray[index+1] = carry;
            }
         
         // change size of bitArray and set equal to sumArray so it can be 
         // used outside of this method
         this.bitArray = new int[max+1];
         this.bitArray = sumArray;
         
         
         
         
      }
      
      /*
      Name: convertToBinary
      Process: accepts an int, converts to bits, and stores it in the array 
               with the least sig digit at index zero. Also sets the number of
               digits member variable
      Method Input/Parameters: int to be converted
      Method Output/Parameters: none
      Method Output/Returned: array of bits
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      private int[] convertToBinary(int decimalValue)
      {
         // initialize method/variables
         int counter = 0;
         int bit;
         int[] tempArray = new int[DEFAULT_CAPACITY];
         
         // start while loop while input int is still greater than zero
         while (decimalValue > 0)
            {
               // this determines what the bit will be as the remainder is 
               // what decides this
               bit = decimalValue % BASE_TWO;
               
               // places the bit into an array
               tempArray[counter] = bit;
               
               // divide the decimalValue in half for the next loop around
               decimalValue /= 2;
               
               // increment the counter by 1
               counter++;
            }
         
         // set numBits equal to the counter as this is the length of the 
         // array
         numBits = counter;
         
         // convert the integer to bits and store in an array
         return tempArray;
      }
      
      /*
      Name: displayBits
      Process: accepts a block size and displays the bits right justified so
               numbers line up when addition is displayed.
      Method Input/Parameters: block size (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: spaces and bit string
      Dependencies: system.out.print
      */
      public void displayBits(int blockSize)
      {
         // initalize method/variables
         int counter;
         
         // counter going up to blocksize for spacing
            // method: system.out.print
         for ( counter = 1; counter < blockSize-numBits; counter++)
            {
               System.out.print(SPACE);
            }
         
         // if the bitArray has a 1 in the carry location, print out that 1
            // method: system.out.print
         if (bitArray[numBits] == 1)
            {
               System.out.print(bitArray[numBits]);
            }
         // otherwise,  print out a space for spacing
         else
            {
               System.out.print(SPACE);
            }
         
         // counter going down from numbits to zero to display the bitArray
         // in the correct order
            // method: system.out.print
         for ( counter  = numBits-1; counter >= 0; counter--)
            {
               System.out.print(bitArray[counter]);
               
            }
         
         // print line for spacing 
         System.out.println();
      }
      
      
      /*
      Name: displayChars
      Process: accepts a number of characters and the character to be output
               then recursively displays specified number of characters
      Method Input/Parameters: character to be output (char), num of chars (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: printed char
      Dependencies: system.out.print
      */
      public void displayChars(int numChars, char outChar)
      {
         // initialize method/variables
         int counter;
         
         // loop that prints out the input character a number of times until it
         // reaches the input int
         for (counter = 0; counter < numChars; counter++)
            {
               System.out.print(outChar);
            }
      }
      
      /*
      Name: findMax
      Process: accepts two int values and returns the larger of the two, must 
               be used in other methods.
      Method Input/Parameters: two numbers (int)
      Method Output/Parameters: none
      Method Output/Returned: max number (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      private int findMax(int valOne, int valOther)
      {
         // initialize method/variables
         
         // compares values, if valueOne is larger return, otherwise return 
         // valueTwo
         if (valOne > valOther)
            {
               return valOne;
            }
         
         return valOther;
      }
      
      /*
      Name: toString
      Process: overloaded method from the Object class that converts digits 
               from the array into a string for display elsewhere
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: string
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      public String toString()
      {
         // initialize method/variables
         int counter = numBits;
         int numberLength = 0;
         String outStr = "";
         
         // while loop that goes from number of bits backwards to 0 in order
         // to display the results in the correct order
         while( counter >= numberLength )
            {
               // adds on each array location to a string in a loo
             outStr += this.bitArray[ counter ];
             
             // decrements the counter by 1
             counter--;
            }
         
         // return the completed string converted from the array
         return outStr;
      }
   }
