
package ir4ts;

/**
 *
 * @author mzivkovic
 */
public class AvionCorrect {
    private String proizvodjac;
    private String model;
    private MotorIntFac motor;  
    private int brojMotora;
    private int brojPutnika;
    private double maksimalnaVisinaLetenja;
    private double maksimalnaBrzina;
    private TipMotora tipMotora;
    public enum TipMotora {MLAZNI, PROPELERSKI};

    public AvionCorrect(String proizvodjac, String model, int brojMotora, int brojPutnika, TipMotora tipMotora) {
        if(brojMotora < 1) throw new IllegalArgumentException();
        if(brojPutnika < 0) throw new IllegalArgumentException();
        this.proizvodjac = proizvodjac;
        this.model = model;
        this.brojMotora = brojMotora;
        this.brojPutnika = brojPutnika;
        this.tipMotora = tipMotora;
    }

    //geteri
    public String getProizvodjac() {
        return proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public int getBrojMotora() {
        return brojMotora;
    }

    public int getBrojPutnika() {
        return brojPutnika;
    }

    public double getMaksimalnaVisinaLetenja() {
        return maksimalnaVisinaLetenja;
    }

    public double getMaksimalnaBrzina() {
        return maksimalnaBrzina;
    }
    
    public TipMotora getTipMotora(){
        return this.tipMotora;
    }
    
    public MotorIntFac getMotor () {
        return this.motor;
    }
    
    //seteri
    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrojMotora(int brojMotora) {
        this.brojMotora = brojMotora;
    }

    public void setBrojPutnika(int brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public void setMaksimalnaVisinaLetenja(double maksimalnaVisinaLetenja) {
        this.maksimalnaVisinaLetenja = maksimalnaVisinaLetenja;
    }

    public void setMaksimalnaBrzina(double maksimalnaBrzina) {
        this.maksimalnaBrzina = maksimalnaBrzina;
    }
    
    public void setTipMotora (TipMotora tipMotora){
        this.tipMotora = tipMotora;
    }
    
    public void setMotor (MotorIntFac motor) {
        this.motor = motor;
    }
    
    public String toString (){
        return "(" + proizvodjac + " " + model + ", " + brojMotora + " motora, " + brojPutnika + " putnika, " + tipMotora + ")";
    }
    
    public double potrosnjaZaPredjeniPut (double put) throws IllegalArgumentException{
        if (put < 0) throw new IllegalArgumentException();
        double K;
        if (put >= 500){
            K = 0.06;
        } else {
            K = 0.04;
        }
        double potrosnja = (put * brojPutnika * brojMotora * motor.getProsecnaPotrosnja()) /(3600*K); 
        return potrosnja;
    }
    
    public double izracunajMaksimalnuVisinuLetenja (double tezinaTovara) throws IllegalArgumentException {
        if (tezinaTovara < 0) throw new IllegalArgumentException();
        double osnovnaVisina = 10000;
        if (tipMotora == TipMotora.PROPELERSKI) {
            osnovnaVisina *= 0.7;
            if (brojPutnika > 100)
                osnovnaVisina *= 0.9; 
        } else {
            if (brojMotora > 2) 
                osnovnaVisina +=  2000;
            if (brojPutnika > 200)
                osnovnaVisina -= 1000;
        }
        
        if (tezinaTovara > 20000)
            osnovnaVisina -= 1000;
        
        maksimalnaVisinaLetenja = osnovnaVisina;
        return osnovnaVisina;
        
    }
    
    public double izracunajMinimalnuDuzinuPiste (double tezinaTovara) throws IllegalArgumentException {
        if (tezinaTovara < 0) throw new IllegalArgumentException();
        double k = 1;
        if (tipMotora == TipMotora.PROPELERSKI) k = 0.5;
        return 2500 * (k + tezinaTovara/15000);
    }
    
    public double izracunajProsecnuTezinuTovaraPoPutniku (double tezinaTovara) throws IllegalArgumentException {
        if (tezinaTovara < 0) throw new IllegalArgumentException();
        return tezinaTovara/brojPutnika;
    }
    
}
