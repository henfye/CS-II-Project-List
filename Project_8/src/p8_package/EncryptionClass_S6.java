package p8_package;

public class EncryptionClass_S6
   {
      // initialize two endlines constant
      public static final int TWO_ENDLINES = 2;
      
      // initialize conIO globally
      public static final Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
         String encryptKey;
         String encryptString;
         int[] encryptKeyArray;
         char[] encryptStringArray;
         char[] encryptedString;
         String decryptKey;
         String decryptString;
         int[] decryptKeyArray;
         char[] decryptStringArray;
         char[] decryptedString;
         
         // print title
            // method: printString, printEndlines
         conIO.printString("Encryption / Decryption Program");
         conIO.printEndlines(TWO_ENDLINES);
         
         // print instructions
            // method: printString, printEndlines
         conIO.printString("Part one accepts a series of key integers and "
               + "then a string to be encrypted.");
         conIO.printEndlines(TWO_ENDLINES);
         
      // get input from user
         
         // prompt for a series of numbers and input as a string
            // method: promptForString
         encryptKey = conIO.promptForString("Enter series of numbers: ");
         
         // prompt for a string to be encrypted
            // method: promptForString, printEndline
         encryptString = conIO.promptForString("Enter string to be encrypted: "
               );
         conIO.printEndline();
         
      // process the encryption
         
         // convert key string to integer array
            // method: convertStringToIntArray
         encryptKeyArray = convertStringToIntArray(encryptKey);
         
         // convert input string to character array
            // method: convertStringToCharArray
         encryptStringArray = convertStringToCharArray(encryptString);
         
         // pass both arrays to encryptString
            // method: encryptString
         encryptedString = encryptString(encryptKeyArray, encryptStringArray);
         
      // display results to user
         // call for the displayed results
            // method: displayStringWithLeader
         displayStringWithLeader("encrypt", encryptedString);
         
      // initialize part 2 of program
         
         // display title to user
            // method: printString, printEndlines
         conIO.printEndlines(TWO_ENDLINES);
         conIO.printString("Part two accepts a series of key integers and then"
               + " a string to be decrypted");
         conIO.printEndlines(TWO_ENDLINES);
         
      // get input from user
         
         // prompt user to enter a series of numbers
            // method: promptForString
         decryptKey = conIO.promptForString("Enter series of numbers: ");
         
         // prompt user to enter string to be decrypted
            // method: promptForString, printEndline
         decryptString = conIO.promptForString("Enter string to be decrypted: "
               );
         conIO.printEndline();
         
      // process the decryption
         
         // create an integer array for the key
            // method: convertStringToIntArray
         decryptKeyArray = convertStringToIntArray(decryptKey);
         
         // create a character array for the input string
            // method: convertStringToCharArray
         decryptStringArray = convertStringToCharArray(decryptString);
         
         // pass both arrays to decryptString
            // method: decryptString
         decryptedString = decryptString(decryptKeyArray, decryptStringArray);
         
      // display results to user
         // call for the displayed results
            // method: displayStringWithLeader
         displayStringWithLeader("decrypt", decryptedString);
         conIO.printEndlines(TWO_ENDLINES);
         
      // end program
         
         // display end program to user
            // method: printString, printEndline
         conIO.printString("End Program");
         conIO.printEndline();
         
      }
      /*
      Name: charToInt
      Process: take in a character and convert it to an int if it is a number
      Method Input/Parameters: potential integer (char)
      Method Output/Parameters: none
      Method Output/Returned: converted integer (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      public static int charToInt(char conversion)
      {
         // initialize method/variables
         
         // check if it is a number character
         if (conversion - '0' < 10 && conversion - '0' >= 0)
                  {
                     // return converted number
                     return conversion - '0';
                  }
         
         // if input is not a number, return -1
         return -1;
      }
      
      
      /*
      Name: convertStringToCharArray
      Process: Take in a string and convert it to an array of characters
      Method Input/Parameters: string to convert (String)
      Method Output/Parameters: none
      Method Output/Returned: array of characters (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: .length, .charAt 
      */
      public static char[] convertStringToCharArray(String conversionString)
      {
         // initialize method/variables
         int counter;
         int inputStringLength = conversionString.length();
         char[] charArray = new char[inputStringLength];
         
         // loop through all of the characters in the string and replace
         // each location in the character array with its corresponding char
         for (counter = 0; counter < inputStringLength; counter++)
            {
               charArray[counter] = conversionString.charAt(counter);
            }
         
         // return the character array
         return charArray;
      }
      
      
      /*
      Name: convertStringToIntArray
      Process: converts an input string to an integer array
      Method Input/Parameters: input key (string)
      Method Output/Parameters: none
      Method Output/Returned: integer array (int[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: charToInt, .length, .charAt
      */
      public static int[] convertStringToIntArray(String inputKey)
      {
         // initialize method/variables
         int counter;
         int inputKeyLength = inputKey.length();
         int[] intArray = new int[inputKeyLength];
         int convertedChar;
         
         // call charToInt in a loop to convert all characters to integers
         // and then replace each location in the integer array with its
         // corresponding integer
            // method: charToInt
         for (counter = 0; counter < inputKeyLength; counter++)
            {
               convertedChar = charToInt(inputKey.charAt(counter));
               intArray[counter] = convertedChar;
            }
         
         // return int array
         return intArray;
      }
      
      /*
      Name: decryptString
      Process: take in the key array and char array and create a new array that
               subtracts the two 
      Method Input/Parameters: key array (int[]) character array (char[])
      Method Output/Parameters: none
      Method Output/Returned: decrypted string (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: .length
      */
      public static char[] decryptString(int[] keyArray, char[] charArray)
      {
         // initialize method/variables
         int counter;
         int charArrayLength = charArray.length;
         int keyArrayLength = keyArray.length;
         int[] dupeKeyArray = new int[charArrayLength];
         
         // duplicate the keyArray until it becomes the same length as the
         // charArray and then subtract all of the numbers in a loop
         for (counter = 0; counter < charArrayLength; counter++)
            {
               dupeKeyArray[counter] = keyArray[counter%keyArrayLength];
               charArray[counter] -= dupeKeyArray[counter];
            }
         
         // return the modified character array
         return charArray;
      }
   
      
      /*
      Name: displayStringWithLeader
      Process: Displays either an encrypted or decrypted string with a leader
      Method Input/Parameters: leader (String), character array (char[])
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: encrypted/decrypted string
      Dependencies: conIO
      */
      public static void displayStringWithLeader(String leader, 
            char[] charArray)
      {
         // initialize method/variables
         int counter;
         int charArrayLength = charArray.length;
         
         // display leader for encryption
            // method: printString
         if (leader == "encrypt")
            {
               conIO.printString("Encrypted String: ");
            }
         
         // display leader for decryption
            // method: printString
         else
            {
               conIO.printString("Decrypted String: ");
            }
         
         // print out each character of the encrypted/decrypted character array
         // in a loop
            //method: printChar
         for (counter = 0; counter < charArrayLength; counter++)
            {
               conIO.printChar(charArray[counter]);
            }
      }

      
      /*
      Name: encrpytString
      Process: take in the key array and char array and create a new array that
               adds the two together
      Method Input/Parameters: key array (int[]) character array (char[])
      Method Output/Parameters: none
      Method Output/Returned: encrypted string (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: .length
      */
      public static char[] encryptString(int[] keyArray, char[] charArray)
      {
         // initialize method/variables
         int counter;
         int charArrayLength = charArray.length;
         int keyArrayLength = keyArray.length;
         int[] dupeKeyArray = new int[charArrayLength];
         
         // duplicate the keyArray until it becomes the same length as the
         // charArray and then add on all of the numbers in a loop
         for (counter = 0; counter < charArrayLength; counter++)
            {
               dupeKeyArray[counter] = keyArray[counter%keyArrayLength];
               charArray[counter] += dupeKeyArray[counter];
            }
         
         // return the newly encrypted array
         return charArray;
      }
   }
