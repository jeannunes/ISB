package System;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.HashMap;

public class WordCounter extends Thread {

    private int arquivos, thread_count, num;
    private HashMap<String, Integer> word_count;

    WordCounter(int arquivos, int thread_count, int num) {
        this.arquivos = arquivos;
        this.thread_count = thread_count;
        this.num = num;
        word_count = new HashMap<>();
    }

    HashMap<String, Integer> getWords() {
        return word_count;
    }

    public void run() {

        BufferedReader bufferedReader;

        for (int i = 0; i < arquivos; i++) {

            if (i % thread_count != num)
                continue;

            File file = new File(Principal.endereco + "/noticia-" + (i + 1) + ".txt");

            if (!file.exists())
                continue;

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {

                        if (word.length() == 0)
                            continue;

                        String clear = clean(word);

                        if (clear.length() == 0)
                            continue;
                        Integer c = word_count.get(clear);
                        if (c != null) {
                            word_count.replace(clear, c + 1);
                        } else {
                            word_count.put(clear, 1);
                        }
                    }
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String clean(String clear) {
        clear = Normalizer.normalize(clear.toLowerCase(), Normalizer.Form.NFD);
        clear = clear.replaceAll("[^\\p{ASCII}]", " ");
        clear = clear.replaceAll("[^a-zA-Z0-9]", " ");
        clear = clear.trim();
        return clear;
    }

}
