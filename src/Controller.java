import java.util.ArrayList;

public class Controller {
    Database db;

    public Controller() {
        this.db = new Database();

    }

    public void tilføjSuperhelt(String navn, String superhelteNavn, String superKræft, int skabelsesÅr, boolean menneske, int styrke) {
        db.tilføjSuperhelt(navn, superhelteNavn, superKræft, skabelsesÅr, menneske, styrke);
    }

    public ArrayList<Superhelte> hentSuperhelte() {
        return db.hentSuperhelt();
    }

}
