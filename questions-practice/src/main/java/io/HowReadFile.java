package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * How to read a file.
 *
 * 如何读取文件
 *
 * @author Thomson Tang
 * @version Created: 24/06/2017.
 */
public class HowReadFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(HowReadFile.class);
    private static final String SAMPLE_FILE_PATH = "example-file.txt";

    public static void main(String[] args) {
        HowReadFile howReadFile = new HowReadFile();

        howReadFile.readFileInJava6();
    }

    /**
     * Java 6 中读取一个文件的方法
     */
    public void readFileInJava6() {
        try {
            URL fileUrl = this.getClass().getResource(SAMPLE_FILE_PATH);
            LOGGER.info("the file path: {}", fileUrl.getPath());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileUrl.getPath()));
            String line;
            LOGGER.info("======Start to read the file:");
            while (null != (line = bufferedReader.readLine())) {
                LOGGER.info(line);
            }
            LOGGER.info("=======It's over!");
        } catch (FileNotFoundException e) {
            LOGGER.error("the file <{}> was not found.", SAMPLE_FILE_PATH);
        } catch (IOException e) {
            LOGGER.error("read the file <{}> was error.", SAMPLE_FILE_PATH);
        }
    }
}
