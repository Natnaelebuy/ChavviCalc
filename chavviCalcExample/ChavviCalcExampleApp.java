package com.chavviCalcExample;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';
    
    //declare and initialize a and b variables to zero
    double a = 0.0;
    double b = 0.0;
    //choice variable to store what the user want to do in the program
    String choice = "";
    //process is enclosed in a loop. We only exit the loop if the user chooses 'q' for exit
    while(true){
      //prompt the user with the Chavvi Calc menu
      //also display the values of a and b in 3 decimal places
      //enter values for a and and also do arithmetic operations
      System.out.println("------------------------------------------------------------");
      System.out.println("Chavvi Calc");
      System.out.println("------------------------------------------------------------");
      System.out.printf("A = %-15.3fB = %.3f\n", a, b);
      System.out.println("------------------------------------------------------------");
      System.out.printf("%-5s%s\n", "a", "Enter value for A");
      System.out.printf("%-5s%s\n", "b", "Enter value for B");
      System.out.printf("%-5s%s\n", "+", "Add");
      System.out.printf("%-5s%s\n", "-", "Subtract");
      System.out.printf("%-5s%s\n", "*", "Multiply");
      System.out.printf("%-5s%s\n", "/", "Divide"); 
      System.out.printf("%-5s%s\n", "c", "Clear");
      System.out.printf("%-5s%s\n", "q", "Quit");
      System.out.println("------------------------------------------------------------");
      System.out.print("Enter command: ");
      
      //input for user choice. and convert our input to lowercase
      //in case the input is in uppercase
      //case a will read a value for variable a
      //we validate input by checking if the value we entered is a double
      //we keep on entering values until we get a proper value
      //The case is also the same for B
      choice = reader.nextLine().toLowerCase();
      switch(choice){
          case "a":                    
              System.out.print("\nEnter value for A: ");  
              while(!reader.hasNextDouble()){
                  System.out.println("Invalid input. Try again.");
                  System.out.print("Enter value for A: ");  
                  reader.next();
              }
              a = reader.nextDouble();
              reader.nextLine();
              System.out.println();
              break;
          case "b":
              System.out.print("\nEnter value for B: ");  
              while(!reader.hasNextDouble()){
                  System.out.println("Invalid input. Try again.");
                  System.out.print("Enter value for B: ");  
                  reader.next();
              }
              b = reader.nextDouble();
              reader.nextLine();
              System.out.println();
              break;
          //the below cases are for arithmetic operations
          //add, subtract, multiply and divide
          //display the values in 3 decimal places
          //also check if the value of b is equal to zero
          //since we cannot divide by zero and it will result to an undefined value
          //thus we prompt the user with error in case
          case "+":
              System.out.printf("\n%.3f + %.3f = %.3f\n\n", a, b, (a+b));
              break;
          case "-":
              System.out.printf("\n%.3f - %.3f = %.3f\n\n", a, b, (a-b));
              break;
          case "*":
              System.out.printf("\n%.3f * %.3f = %.3f\n\n", a, b, (a*b));
              break;
          case "/":
              if(b == 0){
                  System.out.println("\ncannot divide by zero.\n");
              }else{
                  System.out.printf("\n%.3f * %.3f = %.3f\n\n", a, b, (a/b));  
              }
              break;
          //if the user chooses 'q' then we use System.exit(0) command 
          //to exit our program immediately
          
          case "q":
              System.exit(0);
              break;
          //case 'c' will set the values of a and b back to zero
          //by default if the user enters another value other than the
          //the values specified in the menu then we prompt the user 
          //for invalid input
          case "c":
              a = 0.0;
              b = 0.0;
              System.out.println("\nA and B values has been reset to zero.\n");
              break;
          default:
              System.out.println("\nInvalid input. Try again.\n");
      }
  }

  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
      "----------------------------------------------------------"
    );
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();

    printMenuCommand('q', "Quit");

    printMenuLine();
  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }
}
