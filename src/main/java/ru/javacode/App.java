package ru.javacode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        CustomStringBuilder sb = new CustomStringBuilder();

        for(int i = 0; i < 10; ++i){
            sb.append("X");
            System.out.println(sb);
        }
        for(int i = 0; i < 15; ++i){
            if(sb.undo()) {
                System.out.println(sb);
            }
        }
    }
}