package banking;

public class Affichage{
  public void message_acceuil(){
    System.out.println("    ╔═══════════════════════════════════════════════╗");
    System.out.println("    ║            International FSB Bank             ║");
    System.out.println("    ║                 $ ~ € ~ £ ~ ¥                 ║");
    System.out.println("    ╚═══════════════════════════════════════════════╝");
  }

  public void message_selection(){
    System.out.println("╔═══════════════════════════════════════════════════════╗");
    System.out.println("║              Que voulez vous faire ?                  ║");
    System.out.println("║1.  Création d'un compte  ║  5.  Demander un crédit    ║");
    System.out.println("║2.  Faire un dépot        ║  6.  Liste des crédits     ║");
    System.out.println("║3.  Faire un retrait      ║  7.  Faire un virement     ║");
    System.out.println("║4.  Historique            ║  8.  Remboursement crédit  ║");
    System.out.println("║                    9. QUITTER                         ║");
    System.out.println("╚═══════════════════════════════════════════════════════╝");
  }
}
