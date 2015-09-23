/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

/**
 *
 * @author Marthin
 */
public class UserInterface {
        
        public void menu(){
            boolean quit = false;
            while(!quit) {
                switch (int ans) {
                    case 1: 
                        addBook();
                        break;
                    case 2: //remove
                        break;
                    case 3: //search by title,author,isbn
                        break;
                    case 4://print all books
                        break;
                    case 5://quit and save to file
                        quit = true;
                        break;
                }
            }
        }
        public void addBook(){
            
        }
        public void getBooksByTitle(String title){
            return null;
        }
}
