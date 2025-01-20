package videosystem.mixing;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import videosystem.DVDPlayer;

@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {

    @Bean
    public DVDPlayer dvdPlayer(){
        return new DVDPlayer();
    }
}
