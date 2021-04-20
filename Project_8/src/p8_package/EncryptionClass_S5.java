package p8_package;

public class EncryptionClass_S5
   {
      public static final int TWO_ENDLINES = 2;
      
      public static final Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
         
         // print title
            // method: printString, printEndlines
         
         // print instructions
            // method: printString, printEndlines
         
      // get input from user
         
         // prompt for a series of numbers and input as a string
            // method: promptForString
         
         // prompt for a string to be encrypted
            // method: promptForString, printEndline
         
      // process the encryption
         
         // convert key string to integer array
            // method: convertStringToIntArray
         
         // convert input string to character array
            // method: convertStringToCharArray
         
         // pass both arrays to encryptString
            // method: encryptString
         
      // display results to user
         // call for the displayed results
            // method: displayStringWithLeader
         
      // initialize part 2 of program
         
         // display title to user
            // method: printString, printEndlines
         
      // get input from user
         
         // prompt user to enter a series of numbers
            // method: promptForString
         
         // prompt user to enter string to be decrypted
            // method: promptForString, printEndline
         
      // process the decryption
         
         // create an integer array for the key
            // method: convertStringToIntArray
         
         // create a character array for the input string
            // method: convertStringToCharArray
         
         // pass both arrays to decryptString
            // method: decryptString
         
      // display results to user
         // call for the displayed results
            // method: displayStringWithLeader
         
      // end program
         
         // display end program to user
            // method: printString, printEndline
         
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
                    
         // return converted number
         
         // if input is not a number, return -1
         return 0;  // temporary value
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
         
         // loop through all of the characters in the string and replace
         // each location in the character array with its corresponding char
         
         // return the character array
         return null;  // temporary return
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
         
         // call charToInt in a loop to convert all characters to integers
         // and then replace each location in the integer array with its
         // corresponding integer
            // method: charToInt
         
         // return int array
         return null;  // temporary return
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
         
         // duplicate the keyArray until it becomes the same length as the
         // charArray and then subtract all of the numbers in a loop
         
         // return the modified character array
         return null; // temporary return
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
      public static void displayStringWithLeader(String leader, char[] charArray)
      {
         // initialize method/variables
         
         // display leader for encryption
            // method: printString
         
         // display leader for decryption
            // method: printString
         
         // print out each character of the encrypted/decrypted character array
         // in a loop
            //method: printChar
         
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
         
         // duplicate the keyArray until it becomes the same length as the
         // charArray and then add on all of the numbers in a loop

         // return the encrypted array
         return null; // temporary return
      }
   }
