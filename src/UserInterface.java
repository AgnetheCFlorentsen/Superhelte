import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Controller controller;
    private Scanner keyboard = new Scanner(System.in);

    public UserInterface() {
        this.controller = new Controller();
    }

    public void startProgram() {
        int brugerValg = -1;
        while (brugerValg != 5) {
            System.out.println("Velkommen til superheltedatabasen! ");
            System.out.println("1. Opret ny superhelt ");
            System.out.println("2. Vis de forskellige superhelte ");
            System.out.println("3. Søg efter en superhelt i databasen ");
            System.out.println("4. Rediger en superhelt fra databasen. ");
            System.out.println("5. Afslut ");

            brugerValg = keyboard.nextInt();
            keyboard.nextLine();
            håndterBrugerValg(brugerValg);
        }
    }

    public void håndterBrugerValg(int brugerValg) {
        if (brugerValg == 1)
            tilføjSuperhelt();
        else if (brugerValg == 2)
            visSuperhelt();
        else if (brugerValg == 3) {
            søgSuperhelt();
        } else if (brugerValg == 4) {
            redigerSuperhelt();
        }
    }


    public void tilføjSuperhelt() {
        System.out.println("Du vil gerne tilføje en ny superhelt.");
        System.out.print("Indtast navnet på superhelten: ");
        String navn = keyboard.nextLine();
        System.out.print("Hvad er superheltens superheltenavn? ");
        String superheltenavn = keyboard.nextLine();
        System.out.print("Hvilken superkræft har denne superhelt? ");
        String superKræft = keyboard.nextLine();
        System.out.print("Hvornår blev denne superhelt skabt? ");
        int skabelsesÅr = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Er denne superhelt ligeledes et menneske? (true/false) ");
        boolean menneske = keyboard.nextBoolean();
        System.out.print("Hvilken styrke har denne superhelt (fra 1-10?) ");
        int styrke = keyboard.nextInt();
        keyboard.nextLine();

        Superhelte superhelt = new Superhelte(navn, superheltenavn, superKræft, skabelsesÅr, menneske, styrke);
        controller.db.tilføjSuperhelt(superhelt);
        System.out.println("Du har nu oprettet en ny superhelt");
    }

    public void visSuperhelt() {
        if (controller.hentSuperhelte().isEmpty()) {
            System.out.println("Du har ikke registreret nogle superhelte.");
        } else {
            System.out.println("Superhelte i databasen: ");
            for (Superhelte s : controller.hentSuperhelte()) {
                System.out.println(s);
            }
        }
    }

    public void søgSuperhelt() {
        System.out.println("Hvilket superheltenavn søger du (eller hvad starter det med)? ");
        String søgekriterium = keyboard.next();
        ArrayList<Superhelte> søgeResultat = new ArrayList<Superhelte>();
        for (Superhelte s : controller.db.hentSuperhelt()) {
            if (s.getSuperhelteNavn().contains(søgekriterium)) {
                søgeResultat.add(s);
            }

        }

        Superhelte fundetSuperhelt = controller.db.søgSuperhelt(søgekriterium);
        if (!søgekriterium.isEmpty()) {
            System.out.println("Der er denne/disse superhelte i databasen: " + søgekriterium + ": ");
            for (Superhelte s : søgeResultat) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("Der findes ingen superhelte i databasen med det indtastede navn. ");
        }


    }

    public void redigerSuperhelt() {
        System.out.println("Indtast superheltenavnet på den du vil redigere informationer om: ");
        String superhelteNavn = keyboard.nextLine();
        System.out.println("Indtast ny superkræft: ");
        String nySuperKræft = keyboard.nextLine();
        System.out.println("Indtast nyt skabelsesår: ");
        int nytSkabelsesÅr = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Er denne superhelt stadig et menneske? (true/false): ");
        boolean nytMenneske = keyboard.nextBoolean();
        System.out.println("Indtast ny styrke (fra 1-10): ");
        int nyStyrke = keyboard.nextInt();
        keyboard.nextLine();

        controller.db.redigerSuperhelt(superhelteNavn, nySuperKræft, nytSkabelsesÅr, nytMenneske, nyStyrke);
        System.out.println("Superhelten du søgte " + superhelteNavn + " blev ikke fundet");
    }

}
