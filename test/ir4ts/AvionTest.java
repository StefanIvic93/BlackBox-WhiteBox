
package ir4ts;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Ivic
 */
public class AvionTest {
    
    private Avion mlazni_4_250 = null;
    private MotorIntFac motor = null;
    private Avion propelerski_2_250 = null;
    
    @Before
    public void beforeEachTest(){
        mlazni_4_250 = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        motor = new GetPP();
        //motor = new Motor("BMW", 801);
        mlazni_4_250.setMotor(motor);
        
        propelerski_2_250 = new Avion("Boeing", "747", 2, 250, Avion.TipMotora.PROPELERSKI);
    }
    
//    /**
//     * 0. Test of constructor, of class Avion.
//     */
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorAvionMotori_nelegalnaKlasaEkvivalencije() {
//        Avion instance = new Avion("Boeing", "777", -4, 250, Avion.TipMotora.MLAZNI);
//    }
//    @Test
//    public void testConstructorAvionMotori_legalnaKlasaEkvivalencije() {
//        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
//    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorAvionMotori_granicnaVrednost0() {
//        Avion instance = new Avion("Boeing", "777", 0, 250, Avion.TipMotora.MLAZNI);
//    }
//    @Test
//    public void testConstructorAvionMotori_granicnaVrednost1() {
//        Avion instance = new Avion("Boeing", "777", 1, 250, Avion.TipMotora.MLAZNI);
//    }
//    @Test
//    public void testConstructorAvionMotori_granicnaVrednost2() {
//        Avion instance = new Avion("Boeing", "777", 2, 250, Avion.TipMotora.MLAZNI);
//    }
//    
//    // avion mora da ima 0 ili vise putnika
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorAvionPutnici_nelegalnaKlasaEkvivalencije() {
//        Avion instance = new Avion("Boeing", "777", 4, -250, Avion.TipMotora.MLAZNI);
//    } 
//    @Test
//    public void testConstructorAvionPutnici_legalnaKlasaEkvivalencije() {
//        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
//    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorAvionPutnici_granicnaVrednostM1() {
//        Avion instance = new Avion("Boeing", "777", 4, -1, Avion.TipMotora.MLAZNI);
//    } 
//    @Test
//    public void testConstructorAvionPutnici_granicnaVrednost0() {
//        Avion instance = new Avion("Boeing", "777", 4, 0, Avion.TipMotora.MLAZNI);
//    }
//    @Test
//    public void testConstructorAvionPutnici_granicnaVrednost1() {
//        Avion instance = new Avion("Boeing", "777", 4, 1, Avion.TipMotora.MLAZNI);
//    }
    
    /**
     * 3. Test of toString method, of class Avion.
     */
    @Test
    public void testToString() {
        String expResult = "(Boeing 777, 4 motora, 250 putnika, MLAZNI)";
        String result = mlazni_4_250.toString();
        assertEquals(expResult, result);
    }    
    
    /**
     * 4. Test of potrosnjaZaPredjeniPut method, of class Avion.
     */
    
    // klase ekvivalencije
    @Test(expected = IllegalArgumentException.class)
    public void testPotrosnjaZaPredjeniPut_nelegalnaKlasaEkvivalencije() {
        double put = -1000.0;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_legalnaKlasaEkvivalencije() {
        double put = 1000.0;
        double expResult = 24537.037;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.001);
    }
    
    // granicne vrednosti
    @Test(expected = IllegalArgumentException.class)
    public void testPotrosnjaZaPredjeniPut_granicnaVrednostM1() {
        double put = -1.0;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_granicnaVrednost0() {
        double put = 0.0;
        double expResult = 0.0;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_granicnaVrednost1() {
        double put = 1.0;
        double expResult = 36.805;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_granicnaVrednost499() {
        double put = 499.0;
        double expResult = 18365.972;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_granicnaVrednost500() {
        double put = 500.0;
        double expResult = 12268.518;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.001);
    }
    @Test
    public void testPotrosnjaZaPredjeniPut_granicnaVrednost501() {
        double put = 501.0;
        double expResult = 12293.055;
        double result = mlazni_4_250.potrosnjaZaPredjeniPut(put);
        assertEquals(expResult, result, 0.001);
    }
    
    /**
     * 5. Test of izracunajMaksimalnuVisinuLetenja method, of class Avion.
     */
    
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_legalnaKlasaEkvivalencije() {
        double tezinaTovara = 35653.0;
        Avion instance = new Avion("Boeing", "747", 2, 250, Avion.TipMotora.PROPELERSKI);
        double expResult = 5300.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIzracunajMaksimalnuVisinuLetenja_nelegalnaKlasaEkvivalencije() {
        double tezinaTovara = -35653.0;
        Avion instance = new Avion("Boeing", "747", 2, 250, Avion.TipMotora.PROPELERSKI);
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
    }
    
    // pokrivanje iskaza
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjeIskaza1() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.PROPELERSKI);
        double expResult = 5300.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjeIskaza2() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double expResult = 11000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    
    // pokrivanje odluka
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjeOdluka1() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 4, 50, Avion.TipMotora.PROPELERSKI);
        double expResult = 6000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjeOdluka2() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 2, 50, Avion.TipMotora.MLAZNI);
        double expResult = 10000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    
    // pokrivanje putanja
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja1() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.PROPELERSKI);
        double expResult = 6300.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja2() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 4, 50, Avion.TipMotora.PROPELERSKI);
        double expResult = 7000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja3() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double expResult = 10000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja4() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 4, 50, Avion.TipMotora.MLAZNI);
        double expResult = 12000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja5() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 4, 50, Avion.TipMotora.MLAZNI);
        double expResult = 11000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja6() {
        double tezinaTovara = 10000.0;
        Avion instance = new Avion("Boeing", "777", 2, 250, Avion.TipMotora.MLAZNI);
        double expResult = 9000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja7() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 2, 250, Avion.TipMotora.MLAZNI);
        double expResult = 8000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajMaksimalnuVisinuLetenja_pokrivanjePutanja8() {
        double tezinaTovara = 50000.0;
        Avion instance = new Avion("Boeing", "777", 2, 50, Avion.TipMotora.MLAZNI);
        double expResult = 9000.0;
        double result = instance.izracunajMaksimalnuVisinuLetenja(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * 6. Test of izracunajMinimalnuDuzinuPiste method, of class Avion.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIzracunajMinimalnuDuzinuPiste_nelegalnaKlasaEkvivalencije() {
        double tezinaTovara = -250.0;
        double result = mlazni_4_250.izracunajMinimalnuDuzinuPiste(tezinaTovara);
    }
    
    @Test
    public void testIzracunajMinimalnuDuzinuPiste_legalnaKlasaEkvivalencijeMlazni() {
        double tezinaTovara = 250.0;
        double expResult = 2541.666;
        double result = mlazni_4_250.izracunajMinimalnuDuzinuPiste(tezinaTovara);
        assertEquals(expResult, result, 0.001);
    }
    
    @Test
    public void testIzracunajMinimalnuDuzinuPiste_legalnaKlasaEkvivalencijePropelerski() {
        double tezinaTovara = 250.0;
        double expResult = 1291.666;
        double result = propelerski_2_250.izracunajMinimalnuDuzinuPiste(tezinaTovara);
        assertEquals(expResult, result, 0.001);
    }
    
    /**
     * 7. Test of izracunajProsecnuTezinuTovaraPoPutniku method, of class Avion.
     */
    
    // klase ekvivalencije
    @Test(expected = IllegalArgumentException.class)
    public void testIzracunajProsecnuTezinuTovaraPoPutniku_nelegalnaKlasaEkvivalencije() {
        double tezinaTovara = -250.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double result = instance.izracunajProsecnuTezinuTovaraPoPutniku(tezinaTovara);
    }
    @Test
    public void testIzracunajProsecnuTezinuTovaraPoPutniku_legalnaKlasaEkvivalencije() {
        double tezinaTovara = 250.0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double expResult = 1.0;
        double result = instance.izracunajProsecnuTezinuTovaraPoPutniku(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }

    // granicne vrednosti
    @Test(expected = IllegalArgumentException.class)
    public void testIzracunajProsecnuTezinuTovaraPoPutniku_granicnaVrednostM1() {
        double tezinaTovara = -1;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double result = instance.izracunajProsecnuTezinuTovaraPoPutniku(tezinaTovara);
    }
    @Test
    public void testIzracunajProsecnuTezinuTovaraPoPutniku_granicnaVrednost0() {
        double tezinaTovara = 0;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double expResult = 0.0;
        double result = instance.izracunajProsecnuTezinuTovaraPoPutniku(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    @Test
    public void testIzracunajProsecnuTezinuTovaraPoPutniku_granicnaVrednost1() {
        double tezinaTovara = 1;
        Avion instance = new Avion("Boeing", "777", 4, 250, Avion.TipMotora.MLAZNI);
        double expResult = 0.004;
        double result = instance.izracunajProsecnuTezinuTovaraPoPutniku(tezinaTovara);
        assertEquals(expResult, result, 0.0);
    }
    
}
