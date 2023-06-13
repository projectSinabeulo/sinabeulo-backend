package sinabeulo.sinabeulobackend.service;

// Imports the Google Cloud client library
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;

import org.springframework.stereotype.Service;
import sinabeulo.sinabeulobackend.model.dto.TestUserInfoDto;
import sinabeulo.sinabeulobackend.model.dto.sttDto;

import java.io.IOException;
import java.util.List;

@Service
public class sttService {


    //참고
    public static String sttrequest(sttDto sttDto) {
        String stttext;

        String encoding = sttDto.getEncoding();
        Integer sampleRateHertz = sttDto.getSampleRateHertz();
        String languageCode = sttDto.getLanguageCode();
        String gcsUri = sttDto.getUri();

//        System.out.print(encoding);
//        System.out.print(sampleRateHertz);
        System.out.print("stt sample2\n");

        try (SpeechClient speechClient = SpeechClient.create()) {

            stttext = null;

            // Builds the sync recognize request
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            .setEncoding(AudioEncoding.valueOf(encoding))
                            .setSampleRateHertz(sampleRateHertz)
                            .setLanguageCode(languageCode)
                            .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

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

}
