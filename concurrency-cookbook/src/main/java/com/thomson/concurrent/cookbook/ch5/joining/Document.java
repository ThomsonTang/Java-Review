package com.thomson.concurrent.cookbook.ch5.joining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 模拟生成文档
 *
 * @author Thomson Tang
 */
public class Document {
    private static final Logger LOGGER = LoggerFactory.getLogger(Document.class);

    //创建含有多个单词的字符串数组
    private String words[] = {"the", "hello", "goodbye", "package", "java", "thread", "pool", "random", "class", "main"};

    //生成文档，并打印出特定单词在文档中出现的次数。
    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        LOGGER.info("DocumentMock: The word appears {} times in the document", counter);
        return document;
    }
}
