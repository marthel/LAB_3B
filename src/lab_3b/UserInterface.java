/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_3b;

import java.util.Scanner;
/**
 *
 * @author Marthin
 */
public class UserInterface {
    private Scanner scan;    
    public UserInterface(){
        scan = new Scanner(System.in);
    }
        public void menu(){
            int ans =0;
            boolean quit = false;
            while(!quit) {
                ans = scan.nextInt();
                switch (ans) {
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
        }
        public static void main(String[] args) {
          UserInterface menu = new UserInterface();
          menu.menu();
         }
}
