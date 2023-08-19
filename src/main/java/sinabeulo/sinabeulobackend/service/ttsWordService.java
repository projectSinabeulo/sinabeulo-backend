package sinabeulo.sinabeulobackend.service;

import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;

import java.io.*;

public class ttsWordService {

    //google Text-to-speech api request 함수
    public static byte[] ttsWords(String words) {
        // Instantiates a client
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {

            //request를 보낼 단어에 대해 빌드
            SynthesisInput input = SynthesisInput.newBuilder().setText(words).build();

            //음성 request 빌드, 언어/목소리/성별 등을 설정
            VoiceSelectionParams voice =
                    VoiceSelectionParams.newBuilder()
                            .setLanguageCode("ko-KR")               // 한국어 설정
                            .setName("ko-KR-Neural2-C")             // Optional: 목소리 설정
                            .setSsmlGender(SsmlVoiceGender.MALE)    //성별 설정
                            .build();

            //return 받는 audio 파일에 대한 configuration 설정
            AudioConfig audioConfig =
                    AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.LINEAR16).build();  //for return byte

            // text-to-speech request를 세팅하고 보냄, input/voice/audioConfig
            SynthesizeSpeechResponse response =
                    textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

            //response에서 audio를 받아옴
            ByteString audioContents = response.getAudioContent();

            byte[] ttsfile = audioContents.toByteArray();   //audio를 byte arrary로 변환하여 반환
            return ttsfile;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
