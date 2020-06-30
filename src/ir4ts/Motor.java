
package ir4ts;

/**
 *
 * @author Ivic
 */
public class Motor implements MotorIntFac {
    
    private String proizvodjac;
    private double snagaPotiska;

    public Motor(){
    }
    
    public Motor(String proizvodjac, double snagaPotiska) throws IllegalArgumentException {
        if(snagaPotiska < 0) throw new IllegalArgumentException();
        this.proizvodjac = proizvodjac;
        this.snagaPotiska = snagaPotiska;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public double getSnagaPotiska() {
        return snagaPotiska;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public void setSnagaPotiska(double snagaPotiska) {
        this.snagaPotiska = snagaPotiska;
    }
    
    @Override
    public double getProsecnaPotrosnja(){
        return Math.sqrt(snagaPotiska)/20.0;
    }
    
}
