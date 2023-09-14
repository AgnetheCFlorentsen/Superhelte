import java.util.ArrayList;

public class Database {
    private ArrayList<Superhelte> superhelte = new ArrayList<Superhelte>();

    public void tilføjSuperhelt(String navn, String superhelteNavn, String superKræft, int skabelsesÅr, boolean menneske, int styrke) {
        superhelte.add(new Superhelte(navn, superhelteNavn, superKræft, skabelsesÅr, menneske, styrke));

    }

    public Superhelte søgSuperhelt(String efterspørgsel) {
        for (Superhelte superhelt : superhelte) {
            if (superhelt.getSuperhelteNavn().equalsIgnoreCase(efterspørgsel)) {
                return superhelt;
            }
        }
        return null;
    }

    public ArrayList<Superhelte> hentSuperhelt() {
        return superhelte;
    }

    public void tilføjSuperhelt(Superhelte superhelt) {
        superhelte.add(superhelt);
    }

    public void redigerSuperhelt(String superhelteNavn, String nySuperKræft, int nytSkabelsesÅr, boolean nytMenneske, int nyStyrke) {
        for (Superhelte superhelt : superhelte) {
            if (superhelt.getSuperhelteNavn().equalsIgnoreCase(superhelteNavn)) {
                superhelt.setSuperKræft(nySuperKræft);
                superhelt.setSkabelsesÅr(nytSkabelsesÅr);
                superhelt.setMenneske(nytMenneske);
                superhelt.setStyrke(nyStyrke);
                System.out.println("Superhelten '" + superhelteNavn + "' er blevet opdateret.");
                return;
            }
        }
        System.out.println("Superhelten med navnet '" + superhelteNavn + "' blev ikke fundet i databasen.");
    }


}

