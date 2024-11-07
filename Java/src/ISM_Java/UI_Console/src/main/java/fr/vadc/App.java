package fr.vadc;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String dirName ="E:\\CCP_Library_New\\IT\\ComputerScience\\Programming Languages\\Languages\\Java\\Core";

        try ( DirectoryStream<Path> dirstrm =
                      Files.newDirectoryStream(Path.of(dirName)) )
        {
            System.out.println("Directory of " + dirName);
// Because DirectoryStream implements Iterable, we
// can use a "foreach" loop to display the directory.
            for(Path entry : dirstrm) {
                BasicFileAttributes attribs =
                        Files.readAttributes(entry, BasicFileAttributes.class);
                if(attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("         ");
                System.out.println(entry.toAbsolutePath().toString());
            }
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch(NotDirectoryException e) {
            System.out.println(dirName + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
