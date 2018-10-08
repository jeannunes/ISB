package System;

import javax.xml.ws.Endpoint;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class Principal {

    public static HashMap<String, Integer> global_count = new HashMap<>();

    public static String endereco = "d:/noticias/teste";

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis(), executionTime;
        int i;
        int thread_count = 4;
        int arquivos = Objects.requireNonNull(new File(endereco).listFiles()).length;

        System.out.println("Arquivos: " + arquivos);

        // Cria o vetor de threads
        WordCounter[] threads = new WordCounter[thread_count];

        // Inicia as threads
        for (i = 0; i < thread_count; i++) {
            threads[i] = new WordCounter(arquivos, thread_count, i);
            threads[i].start();
        }

        // Depois de iniciar as threads, combina cada uma delas com o main
        for (i = 0; i < thread_count; i++) {
            threads[i].join();
            HashMap<String, Integer> temp = threads[i].getWords();
            temp.forEach((word, count) -> {
                if (global_count.containsKey(word))
                    global_count.replace(word, global_count.get(word) + count);
                else
                    global_count.put(word, count);

            });
        }

        executionTime = (System.currentTimeMillis() - startTime);

        System.out.println("Duração ".concat(String.valueOf(executionTime)).concat("ms"));

        global_count.forEach((string, value) -> {
            System.out.println(string + " = " + value);
        });

        Endpoint.publish("http://localhost:8081/", new Search());
        System.out.println("Servidor no ar!");
    }

}