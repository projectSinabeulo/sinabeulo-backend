package sinabeulo.sinabeulobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SinabeuloBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinabeuloBackendApplication.class, args);
	}

//	private static Credential authorize() throws Exception {
//		// load client secrets
//		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
//				new InputStreamReader(PlusSample.class.getResourceAsStream("/client_secrets.json")));
//		// set up authorization code flow
//		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//				httpTransport, JSON_FACTORY, clientSecrets,
//				Collections.singleton(PlusScopes.PLUS_ME)).setDataStoreFactory(
//				dataStoreFactory).build();
//		// authorize
//		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//	}


}
