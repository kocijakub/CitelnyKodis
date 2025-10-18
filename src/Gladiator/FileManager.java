package Gladiator;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class FileManager implements Closeable {


    private static BufferedWriter bw;

    private String fileName;

    public FileManager(String fileName) throws IOException {
        this.fileName = fileName;
        bw = new BufferedWriter(new FileWriter(fileName, true));
    }

    public void write(String line) throws IOException {
        bw.write(LocalTime.now() + " : " + line);
        bw.newLine();
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
