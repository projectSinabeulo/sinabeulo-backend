package sinabeulo.sinabeulobackend.service;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;

import java.util.List;
import java.util.Arrays;

public class sttWavService {

    //wav 파일을 구성할 byte[]로 받고 stt 결과 반환
    public static String sttWav(byte[] fileData) throws IOException {

        String stttext;

        byte[] content = fileData;

        try (SpeechClient speechClient = SpeechClient.create()) {
            stttext = null;

            //request를 보낼 audio에 대해 파일 content 빌드
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();


            // speechContext 단어 인식 설정
            List<String> phrases = Arrays.asList(
                    "너픈 아늘", "노픈 아늘", "너픈 하늘"
            );
            SpeechContext speechContext =
                    SpeechContext.newBuilder().addAllPhrases(phrases).build();
//            System.out.print(speechContext.getPhrases(2));  //speechContext 적용 확인

            //RecognitionConfig 빌드, encoding/hertz/languageCode ...etc.
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            //byte [] 파일로 받아오면서 encoding과 hertz 설정 없이 진행
                            .setLanguageCode("ko-KR")
                            .build();

            // speech-to-text에 request를 세팅하고 보냄
            RecognizeResponse response = speechClient.recognize(config, audio);

            //response results에서 text를 받아옴
            List<SpeechRecognitionResult> results = response.getResultsList();
            for (SpeechRecognitionResult result : results) {
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                stttext = alternative.getTranscript();
                System.out.printf("Transcription: %s%n", stttext);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stttext; //stt api return text

    }
}
