/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Locale;

/**
 *
 * @author Marthin
 */
public class CollectionOfBooks {
    private ArrayList<Book> library;
    
    public CollectionOfBooks() {
        library = new ArrayList<>();
    }
    public void makeBook(String title,ArrayList<String> author,int edition,String ISBN,double price){
        Book book = new Book(ISBN,title,edition,price);
        for (int i=0;i<author.size();i++){
            book.addAuthor(author.get(i));
        }

        addBook(book);
    }
    public void addBook(Book book) {
        library.add(book);
    }
    public void removeBook(int index) {
        library.remove(index);
    }
    public int getSize(){
        return library.size();
    }
    public ArrayList getBooksByTitle(String title){
        ArrayList tmp = new ArrayList<>();
        String upperCaseB,upperCaseTerm=title.toUpperCase(Locale.getDefault());
        if(title.equals("#")) {
            for (int i=0;i<library.size();i++){
                String b = bookToString(i);
                tmp.add(b);
            }
            return tmp;
        }else{
            for (int i = 0; i < library.size(); i++) {
                String b = bookToString(i);
                upperCaseB=b.toUpperCase(Locale.getDefault());
                if (upperCaseB.contains(upperCaseTerm)) {
                    tmp.add(b);
                }
            }
            return tmp;
        }
    }
    public ArrayList getBooksByISBN(String ISBN){
        ArrayList tmp = new ArrayList<>();
        for(int i=0; i<library.size(); i++){
            String b = bookToString(i);
            if( b.contains(ISBN)) {
                tmp.add(b);
            }
        }
        return tmp;
    }
    public ArrayList getBooksByAuthor(String author){
        ArrayList tmp = new ArrayList<>();
        String upperCaseB,upperCaseTerm=author.toUpperCase(Locale.getDefault());
        for(int i=0; i<library.size(); i++){
            String b = bookToString(i);
            upperCaseB=b.toUpperCase(Locale.getDefault());
            if( upperCaseB.contains(upperCaseTerm)) {
                tmp.add(b);
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
    @Override
    public String toString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ ");
        for (int i = 0;i<library.size();i++) {
            strBuilder.append(library.get(i).getTitle() + " ");
        }
        strBuilder.append("] ");
        return strBuilder.toString();
    }
    private String bookToString(int nmb){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Title: " + library.get(nmb).getTitle() + " ");
        strBuilder.append("Author:");
        for (int i = 0;i<library.get(nmb).getNmbAuthors();i++) {
            strBuilder.append(" " + library.get(nmb).getAuthorName(i));
        }
        strBuilder.append(" ");
        strBuilder.append("ISBN: " + library.get(nmb).getISBN() + " ");
        strBuilder.append("Edition: " + library.get(nmb).getEdition() + " ");
        strBuilder.append("Price: " + library.get(nmb).getPrice() + " ");
        return strBuilder.toString();
    }
}
