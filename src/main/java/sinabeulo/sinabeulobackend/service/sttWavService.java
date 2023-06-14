package sinabeulo.sinabeulobackend.service;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class sttWavService {



    //local 파일로 받고 stt 결과 반환
    public static String sttWav1() throws IOException {
        String stttext;


        String fileName = "resources/test3.wav";
//        String fileName = "resources/commercial_mono.wav";
        Path path = Paths.get(fileName);
        byte[] content = Files.readAllBytes(path);

        try (SpeechClient speechClient = SpeechClient.create()) {
            stttext = null;

            // Get the contents of the local audio file
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();


            // Builds the sync recognize request
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                            .setSampleRateHertz(48000)      //wav파일 44100
                            .setLanguageCode("ko-KR")
                            .build();

            // Performs speech recognition on the audio file
            RecognizeResponse response = speechClient.recognize(config, audio);
            List<SpeechRecognitionResult> results = response.getResultsList();

            for (SpeechRecognitionResult result : results) {
                // There can be several alternative transcripts for a given chunk of speech. Just use the
                // first (most likely) one here.
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                stttext = alternative.getTranscript();
                System.out.printf("Transcription: %s%n", stttext);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stttext;
    }


    //wav 파일로 받고 stt 결과 반환
    public static String sttWav2(byte[] fileData) throws IOException {
        String stttext;

        byte[] content = fileData;

        try (SpeechClient speechClient = SpeechClient.create()) {
            stttext = null;

            // Get the contents of the local audio file
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();


            // Builds the sync recognize request
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
//                            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                            .setSampleRateHertz(48000)      //wav파일 44100 //영현이네 wav은 24000
                            .setLanguageCode("ko-KR")
                            .build();

            // Performs speech recognition on the audio file
            RecognizeResponse response = speechClient.recognize(config, audio);
            List<SpeechRecognitionResult> results = response.getResultsList();

            for (SpeechRecognitionResult result : results) {
                // There can be several alternative transcripts for a given chunk of speech. Just use the
                // first (most likely) one here.
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                stttext = alternative.getTranscript();
                System.out.printf("Transcription: %s%n", stttext);
            }

        } catch (IOException e) {
            String error = "error";
            return error;
//            throw new RuntimeException(e);
        }

        return stttext;

    }
}
