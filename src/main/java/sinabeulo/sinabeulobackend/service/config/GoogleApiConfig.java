package sinabeulo.sinabeulobackend.service.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechSettings;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.TextToSpeechSettings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class GoogleApiConfig {

//    @Value("${google.credentials.path}")
//    private String credentialsPath;

    @Bean
    public TextToSpeechClient textToSpeechClient() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("project-sinabeulo-key.json"));
        TextToSpeechSettings settings = TextToSpeechSettings.newBuilder().setCredentialsProvider((CredentialsProvider) credentials).build();
        return TextToSpeechClient.create(settings);
    }

    @Bean
    public SpeechClient speechClient() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("porject-sinabulo-key.json"));
        SpeechSettings settings = SpeechSettings.newBuilder().setCredentialsProvider((CredentialsProvider) credentials).build();
        return SpeechClient.create(settings);
    }
}
