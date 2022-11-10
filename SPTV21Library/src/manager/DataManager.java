
package manager;
import entity.Book;
import entity.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager {
    private final String BOOK_FILE = "files/MyBooks";
    private final String READER_FILE = "files/MyReaders";


    
    public DataManager() {
        File file = new File("files");
        file.mkdirs();
    }
    
    public void saveBooks(Book[] books){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("BOOK_FILE");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("NET FILE MyBooks");
        } catch (IOException ex) {
            System.out.println("Error vvoda/vivoda");
        }
    }

    public Book[] loadBooks() {
        Book[] books = new Book[0];
        
        try {
            FileInputStream fileInputStream = new FileInputStream("BOOK_FILE");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books  = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return books;

    }
    public void saveReaders(Reader[] readers){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("READER_FILE");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("NET FILE MyReaders");
        } catch (IOException ex) {
            System.out.println("Error vvoda/vivoda");
        }
    }

    public Reader[] loadReaders() {
        Reader[] readers = new Reader[0];
        
        try {
            FileInputStream fileInputStream = new FileInputStream("READER_FILE");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers  = (Reader[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return readers;

    }
    
}
