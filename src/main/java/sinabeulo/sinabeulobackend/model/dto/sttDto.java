package sinabeulo.sinabeulobackend.model.dto;

import lombok.Data;

@Data
public class sttDto {
//    String config; {
//        String encoding;
//        Integer sampleRateHertz;
//        String languageCode;
//    }
//    String audio; {
//        String uri;
//    }

        String encoding;
        Integer sampleRateHertz;
        String languageCode;
        String uri;



//    {
//        "config": {
//        "encoding": "LINEAR16",
//                "sampleRateHertz": 16000,
//                "languageCode": "en-US",
//    },
//        "audio": {
//        "uri": "gs://bucket-name/path_to_audio_file"
//    }
//    }
}
