package sinabeulo.sinabeulobackend.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.*;

import static java.net.URLEncoder.encode;

@Service
public class pronunciationService {

    public String trans(String word) throws IOException, URISyntaxException {

        //단어 정보가 비어있을 때 예외처리
        if (word != null) {
        } else {
            return "param is null";
        }
        System.out.println(word);

        //URL setting
        String apiUrl = "http://pronunciation.cs.pusan.ac.kr/pronunc2.asp";
        String keyword = word;
        URI accessUrl = new URI(String.format("%s?text1=%s", apiUrl,
                encode(keyword,"euc-kr")));


        try {
            Document doc = Jsoup.connect(String.valueOf(accessUrl)).get(); //JSOUP을 통해 URL의 html 정보 get
            Elements Tags = doc.select(".td2");    //표준발음 결과가 담기 태그에서 데이터 추출
            String result = Tags.get(2).text();

            System.out.println(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
