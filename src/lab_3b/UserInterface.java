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
                        //addBook();
                        testAddBook();
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
                    default:
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
            String tmp,title,isbn;
            ArrayList<String> author = new ArrayList<>();
            int edition;
            double price;
            
            System.out.print("Title: ");
            title = scan.nextLine();
            while (true) {
                System.out.print("Author: ");
                tmp=scan.nextLine();
                if (tmp.length() > 0) {
                    author.add(tmp);
                }else {
                    break;
                }
            }
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

        public void testAddBook(){
            String title,isbn;
            ArrayList<String> author = new ArrayList<>();
            int edition,price;
            title="rakka";
            author.add("kalle");
            isbn="12-34-567890";
            edition=1;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
            title="Rummanof";
            author.add("Antono");
            author.add("Alexi");
            isbn="12-34-567890";
            edition=1;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
            title="Libre";
            author.add("linn");
            author.add("fredrik");
            isbn="12-34-567890";
            edition=1;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
            title="mammy";
            author.add("rino");
            author.add("anton");
            author.add("kalle");
            isbn="12-34-567890";
            edition=1;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
            title="är namn";
            author.add("örjan");
            author.add("lukas");
            isbn="12-34-567890";
            edition=1;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
        }

        public void removeBook(){
        
        }
        
        public void searchBook(){
            String ans;
            ArrayList tmp;
            System.out.println("1:Title, 2:Author, 3:ISBN");
            System.out.print("What do you wana search for: ");
            ans=scan.nextLine();
            switch (ans) {
                case "1":
                    System.out.print("Enter search term: ");
                    ans = scan.nextLine();
                    tmp=library.getBooksByTitle(ans);
                    for (int i=0;i<tmp.size();i++){
                        System.out.println(tmp.get(i));
                    }
                    break;
                case "2":
                    System.out.print("Enter search term: ");
                    ans = scan.nextLine();
                    tmp=library.getBooksByAuthor(ans);
                    for (int i=0;i<tmp.size();i++){
                        System.out.println(tmp.get(i));
                    }
                    break;
                case "3":
                    System.out.print("Enter search term: ");
                    ans = scan.nextLine();
                    tmp=library.getBooksByISBN(ans);
                    for (int i=0;i<tmp.size();i++){
                        System.out.println(tmp.get(i));
                    }
                    break;
                default:
                    break;
            }
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
