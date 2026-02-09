package singleton.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;

    private String fileName;
    private PrintWriter fileWriter;

    private Logger() {
        this.setFileName("defaultLog.txt");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        if (this.fileWriter != null) this.close();
        this.createFileWriter();
    }

    public String getFileName() {
        return this.fileName;
    }

    private void createFileWriter() {
        try {
            this.fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName, true)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String text) {
        try {
            this.fileWriter.write(text + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            this.fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
