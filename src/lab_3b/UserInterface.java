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

            System.out.println("Pressing enter during Author without entering something will continue");

            System.out.print("Title: ");
            title = scan.nextLine();
            if (title.length()<1){
                title=null;
            }

            while (true) {
                System.out.print("Author: ");
                tmp=scan.nextLine();
                if (tmp.length() > 0) {
                    author.add(tmp);
                }else if (author.size()<1){
                    author.add(null);
                }else{
                    break;
                }
            }

            System.out.print("Edition: ");
            tmp = scan.nextLine();
            if (tmp.length()<1){
                edition=Integer.parseInt("0");
            }else {
                edition = Integer.parseInt(tmp);
            }

            System.out.print("ISBN: ");
            isbn = scan.nextLine();
            if (isbn.length()<1){
                isbn=null;
            }

            System.out.print("Price: ");
            tmp = scan.nextLine();
            if (tmp.length()<1){
                price = Double.parseDouble("0");
            }else {
                price = Double.parseDouble(tmp);
            }

            library.makeBook(title, author, edition, isbn, price);
        }

        public void testAddBook(){
            String title,isbn;
            ArrayList<String> author = new ArrayList<>();
            int edition,price;
            title="rakkay";
            author.add("kalle");
            isbn="12-34-567890";
            edition=1;
            price=100;
            library.makeBook(title, author, edition, isbn, price);
            author.clear();
            title="Rummanof";
            author.add("Antono");
            author.add("Alexi");
            isbn="12-34-567890";
            edition=3;
            price=250;
            library.makeBook(title, author, edition, isbn, price);
            author.clear();
            title="Libre";
            author.add("linn");
            author.add("fredrik");
            isbn="12-34-567890";
            edition=2;
            price=200;
            library.makeBook(title, author, edition, isbn, price);
            author.clear();
            title="mammy";
            author.add("rinoy");
            author.add("anton");
            author.add("kalle");
            isbn="12-34-567890";
            edition=5;
            price=300;
            library.makeBook(title, author, edition, isbn, price);
            author.clear();
            title="är namn";
            author.add("örjan");
            author.add("lukas");
            isbn="12-34-567890";
            edition=4;
            price=400;
            library.makeBook(title, author, edition, isbn, price);
            author.clear();
        }

        public void removeBook(){
            String tmp,b;
            int pos=-1;
            ArrayList<String> tmpAL=library.getBooksByTitle("#");
            System.out.println("Enter the book to be removed");
            tmp=scan.nextLine();
            for (int i=0;i<tmpAL.size();i++){
                b = tmpAL.get(i);
                if (b.contains(tmp)){
                    pos=i;
                }
            }
            if (pos>-1){
                library.removeBook(pos);
                if (library.getSize()==tmpAL.size()-1){
                    System.out.println("You removed the book from the library");
                }else{
                    System.out.println("There was an error during removal");
                }
            }else{
                System.out.println("The book you were trying to remove doesn't exist in our library");
            }
        }
        
        public void searchBook(){
            String ans;
            ArrayList tmp,result=new ArrayList();
            System.out.print("Enter search term: ");
            ans = scan.nextLine();
            tmp=library.getBooksByTitle(ans);
            for (int i=0;i<tmp.size();i++){
                if (!result.contains(tmp.get(i))){
                    result.add(tmp.get(i));
                }
            }
            tmp=library.getBooksByAuthor(ans);
            for (int i=0;i<tmp.size();i++){
                if (!result.contains(tmp.get(i))){
                    result.add(tmp.get(i));
                }
            }
            tmp=library.getBooksByISBN(ans);
            for (int i=0;i<tmp.size();i++){
                if (!result.contains(tmp.get(i))){
                    result.add(tmp.get(i));
                }
            }
            for (int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        }
        
        public void printBooks(){
            ArrayList allBooks=library.getBooksByTitle("#");
            for (int i =0; i<allBooks.size();i++){
                System.out.println(allBooks.get(i));
            }
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
