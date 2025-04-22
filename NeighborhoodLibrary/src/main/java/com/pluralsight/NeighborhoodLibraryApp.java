package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibraryApp {

    // declaring static variable "theBooks" belonging to "Book" class
    // [] = array, so "theBooks" will hold multiple "Book" objects
    static Book[] theBooks = {
            new Book(1,"12345", "Ready Player 1"),
            new Book(2,"56789", "Jurassic Park"),
            new Book(3,"89324", "Green Eggs and Ham"),
            new Book(4,"332dsf2", "Charlotte's Web"),
            new Book(5,"23488", "Goodnight Moon"),
            new Book(6,"12125", "Where the Wild Things Are"),
            new Book(7,"17534", "The Cat in the Hat"),
            new Book(8,"09085", "Little House on the Prairie"),
            new Book(9,"20935", "The Lion, the Witch, and the Wardrobe"),
            new Book(10,"97058", "The Adventures of Captain Underpants"),
            new Book(11,"00003", "And Tango Makes Three"),
            new Book(12,"00324", "Because of Winn-Dixie"),
            new Book(13,"12304", "Bridge to Terabithia"),
            new Book(14,"05055", "Click, Clack, Moo"),
            new Book(15,"11000", "Coraline"),
            new Book(16,"22004", "Diary of a Wimpy Kid"),
            new Book(17,"44055", "Ellington Was Not a Street"),
            new Book(18,"69508", "Romeo and Juliet"),
            new Book(19,"99002", "Percy Jackson and the Olympians: The Lightning Thief"),
            new Book(20,"75032", "The Very Hungry Caterpillar"),
    };

    // initializing scanner to read user input
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // declaring variable appRunning to set its value to true
        boolean appRunning = true;

        // start of while loop
        // as long as appRunning is true, this code block will keep executing
        while(appRunning) {
            // ask the user what they want to do at the library (main menu)
            int userMainMenuChoice = mainMenu();

            // using switch statement to provide clear way to map each command
            switch (userMainMenuChoice) {
                case 1:
                    // call the view available books method to show the books
                    // store the selection in userBookChoice
                    int userBookChoice = viewAvailableBooks();

                // eat the newline
                myScanner.nextLine();

                // the user if they want to check out a book
                if (userBookChoice != -1) {
                    //Ask them their name
                    System.out.println("What is your name?");
                    String usersName = myScanner.nextLine();

                    // checkout the book
                    theBooks[userBookChoice].checkOut(usersName);

                }
                    break;
                case 2:
                    System.out.println("The user wants to see the checked out books");
                    // display the list of checked out books
                    System.out.println("---Checked Out Books---");
                    // checking if any books are checked out
                    boolean checkedOutBooks = false;

                    //
                    for (Book book : theBooks) {
                        if (book.isCheckedOut()) {
                            System.out.println("Title" + book.getTitle());
                        }
                    }

                    // get user's checked out book id info


                    break;
                case 3:
                    // user wants to exit app
                    System.out.println("The user wants to leave");
                    appRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }

    static int mainMenu(){

        System.out.println("Welcome to the Neighborhood Library!\n");

        System.out.println("What would you like to do?");
        System.out.println("----------------------------");
        System.out.println("1: View available books");
        System.out.println("2: View checkout books");
        System.out.println("3: Exit the library");

        return myScanner.nextInt();

    }

    // creating a new method to view avail books
    static int viewAvailableBooks() {
        System.out.println("These are the available books!\n");

        // loop over the books and work with each book
        // index starts at 0,
        for (int i = 0; i < theBooks.length; i++) {

            // set the current book to a variable so we don't have to deal with "i" anymore
            Book currentBook = theBooks[i];

            if (currentBook.isCheckedOut() == false) {
                System.out.println(i + ": " + currentBook.getTitle() + " - " + currentBook.getIsbn());

            }

        }

            // eats the random line
            myScanner.nextLine();

            // ask user if they would like to check out a book
            System.out.println("\nWould you like to check out a book? (y/n)");
            String userSelection = myScanner.nextLine();

            // if user says yes, it asks which book
            if(userSelection.equalsIgnoreCase("y")){
                System.out.println("Please enter the id of the book you want to check out");
                return myScanner.nextInt();
            }

        //return -1 if no book selected, its easy to test for
        return -1;

    }

}
