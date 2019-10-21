package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double donjaGranica;
    private double gornjaGranica;
    private boolean ukljucenaDonja;
    private boolean ukljucenaGornja;
    public Interval(double p, double k, boolean x1, boolean x2){
        if(p>k) throw new IllegalArgumentException ("neispravno");
        donjaGranica =p;
        gornjaGranica =k;
        ukljucenaDonja =x1;
        ukljucenaGornja =x2;

    }
    public Interval(){
        donjaGranica =0;
        gornjaGranica =0;
        ukljucenaDonja =false;
        ukljucenaGornja =false;
    }
    public boolean isNull(){
        if(donjaGranica ==0 && gornjaGranica ==0) return true;
        return false;
    }
    public boolean isIn(double x){
        if(x== donjaGranica && ukljucenaDonja ==true) return true;
        else if(x== gornjaGranica && ukljucenaDonja==true) return true;
        else if(x>donjaGranica && x<gornjaGranica) return true;
        return false;
    }

    public double getDonjaGranica() {
        return donjaGranica;
    }

    public double getGornjaGranica() {
        return gornjaGranica;
    }

    public boolean isUkljucenaDonja() {
        return ukljucenaDonja;
    }

    public boolean isUkljucenaGornja() {
        return ukljucenaGornja;
    }

    public void setDonjaGranica(double donjaGranica) {
        this.donjaGranica = donjaGranica;
    }

    public void setGornjaGranica(double gornjaGranica) {
        this.gornjaGranica = gornjaGranica;
    }

    public void setUkljucenaDonja(boolean ukljucenaDonja) {
        this.ukljucenaDonja = ukljucenaDonja;
    }

    public void setUkljucenaGornja(boolean ukljucenaGornja) {
        this.ukljucenaGornja = ukljucenaGornja;
    }

    public Interval intersect(Interval x){
        Interval novi=new Interval();
        if(x.getDonjaGranica()<this.getGornjaGranica()) {
            if (x.getDonjaGranica() > this.getDonjaGranica()) {
                novi.setDonjaGranica(x.getDonjaGranica());
                novi.setUkljucenaDonja(x.isUkljucenaDonja());
            }
            else {
                novi.setDonjaGranica(this.getDonjaGranica());
                novi.setUkljucenaDonja(this.getDonjaGranica());
            }
            if(x.gornjaGranica>gornjaGranica)  {
                novi.gornjaGranica=x.gornjaGranica;
                novi.ukljucenaGornja=x.ukljucenaGornja;
            }
            else  {
                novi.gornjaGranica=gornjaGranica;
                novi.ukljucenaGornja=ukljucenaGornja;
            }
        }
        else if(x.donjaGranica>=gornjaGranica){
            novi.gornjaGranica=x.gornjaGranica;
            novi.ukljucenaGornja=x.ukljucenaGornja;
            novi.donjaGranica=donjaGranica;
            novi.ukljucenaDonja=x.ukljucenaDonja;
        }
        else if(donjaGranica>=x.gornjaGranica) {
            novi.gornjaGranica=gornjaGranica;
            novi.ukljucenaGornja=ukljucenaGornja;
            novi.donjaGranica=x.donjaGranica;
            novi.ukljucenaDonja=ukljucenaDonja;
        }
        return novi;
    }

}
