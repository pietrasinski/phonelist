package phonelist.java.fx;

public class phonelist {
    private String nazwa;
    private String numer;
   

    public phonelist(String nazwa, String numer) {
        this.nazwa = nazwa;
        this.numer = numer;
    }
    
    public String getNazwa() {
        return nazwa;
    }

    public String getNumer() {
        return numer;
    }
    

    
}