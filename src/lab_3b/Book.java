/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 *
 * @author Marthin
 */
public class Book implements Comparable<Book> {
    private String ISBN,title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;
    public Book(String ISBN, String title, int edition, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.price = price;
        authors = new ArrayList<>();
    }
    public void addAuthor(String name) {
        Author a = new Author(name);
        authors.add(a);
    }
    public ArrayList getAuthors() {
        return authors;
    }
    public int getNmbAuthors(){
        return authors.size();
    }
    public String getAuthorName(int i){
        return authors.get(i).getName();
    }
    public String getTitle() {
        return title;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getEdition() {
        return edition;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public int compareTo(Book b){
        return(int) this.price - (int)b.price;
    }
}
