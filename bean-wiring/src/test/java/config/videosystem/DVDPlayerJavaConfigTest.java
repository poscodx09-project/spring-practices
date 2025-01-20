package config.videosystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import videosystem.DVDPlayer;
import videosystem.DVDPlayerConfig;
import videosystem.DigitalVideoDisc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {

    @Autowired
    @Qualifier("avengers")
    private DigitalVideoDisc dvd1;

    @Autowired
    @Qualifier("ironMan")
    private DigitalVideoDisc dvd2;

    @Autowired
    private DVDPlayer dvdPlayer1;

    @Test
    public void testDVD1(){
        assertNotNull(dvd1);
    }
    @Test
    public void testDVD2(){
        assertNotNull(dvd2);
    }

}
