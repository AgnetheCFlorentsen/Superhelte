public class Superhelte {
    private String navn;
    private String superhelteNavn;
    private String superKræft;
    private int skabelsesÅr;
    private boolean menneske;
    private int styrke;

    public Superhelte(String navn, String superhelteNavn, String superKræft, int skabelsesÅr, boolean menneske, int styrke) {
        this.navn = navn;
        this.superhelteNavn = superhelteNavn;
        this.superKræft = superKræft;
        this.skabelsesÅr = skabelsesÅr;
        this.menneske = menneske;
        this.styrke = styrke;
    }

    public void setSuperKræft(String superKræft) {
        this.superKræft = superKræft;
    }

    public void setSkabelsesÅr(int skabelsesÅr) {
        this.skabelsesÅr = skabelsesÅr;
    }

    public void setMenneske(boolean menneske) {
        this.menneske = menneske;
    }

    public void setStyrke(int styrke) {
        this.styrke = styrke;
    }

    public String getSuperhelteNavn() {
        return superhelteNavn;
    }

    @Override
    public String toString() {
        return "Navn: " + navn +
                "\nSuperheltenavn: " + superhelteNavn +
                "\nSuperkræft: " + superKræft +
                "\nSkabelsesår: " + skabelsesÅr +
                "\nEr et menneske: " + (menneske ? "Ja" : "Nej") +
                "\nStyrke: " + styrke + "\n";
    }

}
