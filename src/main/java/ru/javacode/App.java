package ru.javacode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        CustomStringBuilder sb = new CustomStringBuilder();

        sb.append("text1, ")
                .append("text1");
        System.out.println("current text: " + sb);

        sb.delete(7, 11);
        System.out.println("delete(7, 11): " + sb);

        sb.undo(); // Вернем текст к состоянию до удаления
        System.out.println("undoed: " + sb);

        sb.insert(7, "text2 ");
        System.out.println("inserted: " + sb);

        sb.undo(); // Вернем текст к состоянию до вставки
        System.out.println("undoed: " + sb);

        sb.undo(); // Еще одно undo, к самому первому состоянию
        System.out.println("undoed again: " + sb);
    }
}