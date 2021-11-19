package cl.ucn.disc.dsm.mlam.contactos;

import org.junit.Test;

import static org.junit.Assert.*;


public class ScrapperTest {
    @Test
    public void testScrapper() {
        Scrapper scrapper = new Scrapper();

        scrapper.startScrapper();
         assertFalse(scrapper.getContactos().isEmpty()) ;
    }
}