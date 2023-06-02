package sinabeulo.sinabeulobackend.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.jsoup.nodes.Document;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;

import static java.net.URLEncoder.encode;

@Service
public class secondService {


    public String trans(String name) throws IOException, URISyntaxException {

        System.out.println(name);

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = "http://pronunciation.cs.pusan.ac.kr/pronunc2.asp";
        String keyword = name;

        URI accessUrl = new URI(String.format("%s?text1=%s", apiUrl,
                encode(keyword,"euc-kr")));

//        String res = restTemplate.getForObject(accessUrl, String.class);
//        System.out.println(res);


//        //츄라이 츄...
//        String urlstr = String.format("%s?text1=%s", apiUrl, encode(keyword,"euc-kr"));
//        Document doc2 = Jsoup.parse(new URL(urlstr).openStream(), "euc-kr", urlstr);
//        System.out.println(doc2.outerHtml());






        //츄라이 ..
//        String rawString = res;
//
//        String text1 = URLDecoder.decode(res, "euc-kr");
//        String text2 = URLEncoder.encode(text1, "UTF-8");
//        System.out.println(text2);

        try {
            Document doc = Jsoup.connect(String.valueOf(accessUrl)).get();
//            String docHtml = doc.html();
//            String docText = doc.text();
//            System.out.println(docHtml);
//            System.out.println(docText);
//
//
//            String urlstr = String.format("%s?text1=%s", apiUrl, encode(keyword,"UTF-8"));
//

            //encoding test
//            String urlstr = String.valueOf(accessUrl);
//            InputStream inputStream = new ByteArrayInputStream(urlstr.getBytes());
//            Document doc1 = Jsoup.parse(inputStream, "euc-kr", String.valueOf(accessUrl));
////            System.out.println(doc1.outerHtml());
////            System.out.println(doc1.text());
//
//            Elements Tags1 = doc1.select(".td2");
//            String text = Tags1.get(2).text();
//            System.out.println(text);

//            String text1 = URLDecoder.decode(text, "euc-kr");
//            String text2 = URLEncoder.encode(text, "euc-kr");
//            String text3 = URLDecoder.decode(text2, "utf-8");
//            System.out.println(text2);



            //이렇게 하면 됨. //근데 띄어쓰기까지 표준어가 되도록 바르게 입력해야함.
//            Elements content = doc.select(".td2");
//            System.out.println(content);
//            String text1 = URLEncoder.encode(docText, "UTF-8");
//            String text2 = URLDecoder.decode(docText, "UTF-8");
//            System.out.println(text2);

//            String text3 =  content.html();
//            System.out.println(text3);
//
//            text3=text3.replace("<br>", "");       // <br> 정리
//            System.out.println(text3);

            Elements Tags = doc.select(".td2");
            String text4 = Tags.get(2).text();
            System.out.println(text4);

//            String text5 = URLDecoder.decode(text4, "euc-kr");
//            String text6 = URLEncoder.encode(text5, "euc-kr");
//            String text7 = URLDecoder.decode(text6, "utf-8");

            return text4;




            //try 1.
//            String rawString = docText;
//            byte[] bytes = rawString.getBytes("euc-kr");
//            String utf8EncodedString = new String(bytes);
//            String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
//            System.out.println(utf8EncodedString);

            //try 2.
//            String text3 =  new String(docText.getBytes("MS949"), "utf-8");
//            System.out.println(text3);

            //try 3.
//            String originalstr = "&#xfffd;&#xfffd";
//            String [] charSet = {"utf-8", "utf-16", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949", "cp949", "MS949"};
//
//            for (int i=0; i<charSet.length;i++) {
//                for(int j=0; j<charSet.length; j++) {
//                    try {
//                        System.out.println("[" + charSet[i] + "," + charSet[j] + "]=" + new String(originalstr.getBytes(charSet[i]), charSet[j]));
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //todo. 표준변환발음기을 restTemplate으로 호출 (name을 url encoding한 값으로)
        //todo. 위 값을 String response로 받음
        //todo. html parsing으로 원하는 태그를 받아와서 그 태그 안에 있는 text값만 추출 (decode euc-kr -> encode utf-8)
        //todo. return text
//        return text4;            //text return 해줘야함
    }

}
