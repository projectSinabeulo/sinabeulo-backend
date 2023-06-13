package sinabeulo.sinabeulobackend.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.*;

import static java.net.URLEncoder.encode;

@Service
public class pronunciationService {


    public String trans(String word) throws IOException, URISyntaxException {

        if (word != null) {
        } else {
            return "param is null";
        }

        System.out.println(word);

        String apiUrl = "http://pronunciation.cs.pusan.ac.kr/pronunc2.asp";
        String keyword = word;
        URI accessUrl = new URI(String.format("%s?text1=%s", apiUrl,
                encode(keyword,"euc-kr")));


        try {
            Document doc = Jsoup.connect(String.valueOf(accessUrl)).get();
            Elements Tags = doc.select(".td2");
            String result = Tags.get(2).text();

            System.out.println(result);

            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
