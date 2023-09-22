package tharini174;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class BookMain {
    public static void main(String args[]) {
        BookMethod mm = new BookMethod();
        while (true) {
            System.out.println(".............................WELCOME..........................");
            System.out.println("......LIBRARY BOOK ISSUE AND RETURN SYSTEM......");
            System.out.println();
            int n;
            Scanner in = new Scanner(System.in);
            System.out.println("1.ADD NEW BOOKS TO LIBRARY");
            System.out.println("2.DISPLAY BOOKS");
            System.out.println("3.BORROW");
            System.out.println("4.RETURN BACK");
            System.out.println("5.EXIT");
            System.out.println("PLEASE ENTER YOUR OPTION");
            n = in.nextInt();
            in.nextLine(); // Consume newline character

            switch (n) {
                case 1:
                    mm.AddBooks();
                    System.out.println();
                    break;
                case 2:
                    mm.DisplayAll();
                    break;
                case 3:
                    System.out.print("Enter the Book you want to rent.");
                    in.nextLine();
                    if (mm.RentOut(in.nextLine())) {
                        System.out.println("Borrowed successfully");
                    } else {
                        System.out.println("Sorry!! Not Available");
                    }
                    break;
                case 4:
                   
                    System.out.println("Enter the name of the Book");
                    in.nextLine(); // Consume newline character
                    System.out.println(""+mm.CollectIn(in.nextLine()));
                    try {
                        System.out.print("Enter the borrowed date (yyyy-MM-dd): ");
                        String userInput1 = in.nextLine();
                        System.out.print("Enter the return date (yyyy-MM-dd): ");
                        String userInput2 = in.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        try {
                            // Parse user input into LocalDate objects
                            LocalDate date1 = LocalDate.parse(userInput1, formatter);
                            LocalDate date2 = LocalDate.parse(userInput2, formatter);

                            // Calculate the difference between dates using Period
                            Period period = Period.between(date1, date2);
                            int days1 = period.getDays();
                            if (days1 > 10) {
                                int day = days1 * 3;
                                System.out.println("Fine to be paid is " + day);
                            } else {
                                System.out.println("No Fine to be Paid!");
                            }
                            
                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 5:
                	System.exit(0);
                	break;
           default: System.out.println("Invalid Input!!");
                    break;
  
            }
        }
    }
}

