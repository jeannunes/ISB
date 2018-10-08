package System;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "System.iSearch")
public class Search implements iSearch {

    @Override
    public ArrayList<Count> search(String words) {

        ArrayList<Count> output = new ArrayList<Count>();

        for (String word : words.split(" ")) {
            Count count = new Count();
            count.word = word;
            count.count = Principal.global_count.getOrDefault(word, 0);
            output.add(count);
        }


        return output;
    }

}