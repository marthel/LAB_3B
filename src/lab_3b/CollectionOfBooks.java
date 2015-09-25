/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

import java.util.ArrayList;
/**
 *
 * @author Marthin
 */
public class CollectionOfBooks {
    private ArrayList<Book> library;
    
    public CollectionOfBooks() {
        library = new ArrayList<>();
    }
    public void makeBook(String title,String author,int edition,String ISBN,double price){
        Book book = new Book(ISBN,title,edition,price);
        book.addAuthor(author);
        addBook(book);
    }
    public void addBook(Book book) {
        library.add(book);
    }
    public void removeBook(Book book) {
        library.remove(book);
    }
    public int getSize(){
        return library.size();
    }
    public ArrayList getBooksByTitle(String title){
        ArrayList<Book> tmp = new ArrayList<>();
        if(title.equals("#")) {
            return library;
        }else{
            for (int i = 0; i < library.size(); i++) {
                Book b = library.get(i);
                if (b.getTitle().contains(title)) {
                    tmp.add(b);
                }
            }
            return tmp;
        }
    }
    public ArrayList getBooksByISBN(String ISBN){
        ArrayList<Book> tmp = new ArrayList<>();
        for(int i=0; i<library.size(); i++){
            Book b = library.get(i);
            if( b.getISBN().contains(ISBN)) {
                tmp.add(b);
            }
        }
        return tmp;
    }
    public ArrayList getBooksByAuthor(String author){
        ArrayList<Book> tmp = new ArrayList<>();
        for(int i=0; i<library.size(); i++){
            Book b = library.get(i);
            if( b.getAuthors().contains(author)) {
                if(!tmp.contains(b)) {
                    tmp.add(b);
                }
            }
        }
        return tmp;
    }
    public ArrayList sortByTitle(){
        return null;
    }
    public ArrayList sortByISBN(){
        return null;
    }
    public ArrayList sortByAuthor(){
        return null;
    }
    public ArrayList sortByEdition(){
        return null;
    }
    public ArrayList sortByPrice(){
        return null;
    }
    public void print(){
        System.out.println();
    }
}
