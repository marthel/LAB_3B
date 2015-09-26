/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

import java.io.*;
import java.lang.Runtime;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Marthin
 */
public class UserInterface {
    private Scanner scan;
    private CollectionOfBooks library = new CollectionOfBooks();;
    public UserInterface(){
        scan = new Scanner(System.in);
    }
    
        public void menu() throws IOException{
            String ans;
            boolean quit = false;
            while(!quit) {
                printMenu();
                ans = scan.nextLine();
                switch (ans) {
                    case "1": //Add a book
                        addBook();
                        break;
                    case "2": //remove
                        removeBook();
                        break;
                    case "3": //search by title,author,isbn
                        searchBook();
                        break;
                    case "4"://print all books
                        printBooks();
                        break;
                    case "5"://quit and save to file
                        if(saveToFile()){
                            quit=true;
                        }
                        break;
                }

                try {
                    final String os = System.getProperty("os.name");

                    if (os.contains("Windows")){
                        Runtime.getRuntime().exec("cls");
                    }else{
                        Runtime.getRuntime().exec("clear");
                    }
                }
                catch (final Exception e){
                    System.out.println("Error in clear");
                }

            }
        }
        public void addBook(){
            String tmp,title,author,isbn;
            int edition;
            double price;
            
            System.out.print("Title: ");
            title = scan.nextLine();
            System.out.print("Author: ");
            author = scan.nextLine();
            System.out.print("Edition: ");
            tmp = scan.nextLine();
            edition = Integer.parseInt(tmp);
            System.out.print("ISBN: ");
            isbn = scan.nextLine();
            System.out.print("Price: ");
            tmp = scan.nextLine();
            price = Double.parseDouble(tmp);
            library.makeBook(title, author, edition, isbn, price);
        }
        
        public void removeBook(){
        
        }
        
        public void searchBook(){
        
        }
        
        public void printBooks(){
            System.out.println(library.toString());
        }
        
        public void getBooksByTitle(String title){
        }
        
        public boolean saveToFile(){
            return true;
        }
        
        public void printMenu(){
            System.out.println("-----------Menu------------");
            System.out.println("1: Add a new book");
            System.out.println("2: Remove a book");
            System.out.println("3: Search for a book");
            System.out.println("4: Print all available books");
            System.out.println("5: Exit");
            System.out.println("---------------------------");
            System.out.print("Enter: ");
        }
        
        public static void main(String[] args) throws IOException{
            UserInterface menu = new UserInterface();
            menu.menu();
         }
}
