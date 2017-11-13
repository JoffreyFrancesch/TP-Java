package banking;

import java.util.Scanner;


public class Operation{
  Scanner scanner = new Scanner(System.in);
  Banque banque = new Banque();


  public void creer_compte(){
    String prenom, nom;
    int age, numero_compte;
    double premier_depot = 0;
    boolean flag = false;//permet de nous sortir de la boucle quand tout est OK
    //Recuperation du prenom
    System.out.print("Entrer votre Prénom : ");
    prenom = scanner.nextLine();
    //Recuperation du nom
    System.out.print("Entrer votre Nom : ");
    nom = scanner.nextLine();
    //Recuperation de l'age
    System.out.print("Entrer votre Age : ");
    age = scanner.nextInt();

    do {
      //Recuperation du premier depot
      System.out.print("Entrer un premier dépot d'argent (>0) : ");
      premier_depot = scanner.nextDouble();
      //Verif depot > 0
      if(premier_depot < 0){
        System.out.println("Vous devez mettre un montant positif");
      } else {
        flag = true;
      }
    }while(!flag);
    //attribution du numero de compte = a la taille de la liste des clients par exemple le premier client aura numero 0
    numero_compte = banque.getSize();
    //Création du client
    Client client = new Client(prenom,nom,age,premier_depot, numero_compte);
    //Ajout du Client a la liste des clients
    banque.ajout_client(prenom,nom,age,premier_depot, numero_compte);
    //Aaffichage permet de check si toute les valeurs sont OK
    System.out.println("Merci d'avoir créer un compte Mr."+  client.getNom() + " "+ client.getPrenom() + " Et vous avez "+ client.getAge() + " ans" + " Votre Numero de comtpe est le : " + client.getNumeroCompte() + "\n");
  }

  public void faire_depot(){
    int numero_compte;
    double depot, nouveau_solde;
    //recuperation du numero de compte
    System.out.println("Bonjour sur quel compte voulez vous faire un depot ? : ");
    numero_compte = scanner.nextInt();
    //recuperation du client dans la listes de des clients
    Client client = banque.getClient(numero_compte);
    //recuperation du dépot qu'on veux faire
    System.out.println("Votre solde est de " + client.getSolde() + ". Combien voulez vous rajouter sur votre compte ? ");
    depot = scanner.nextDouble();
    //test si la valeur nest pas négative
    if (depot < 0){
      //on redemande une nouvelle valeur si < 0
      System.out.println("Vous devez rentrer un valeur positive\n Nouvelle valeur ? ");
      depot = scanner.nextDouble();
    }
    //on modifie le solde
    nouveau_solde = depot + client.getSolde();
    //on met à jour le client
    banque.setNouveauSolde(numero_compte,nouveau_solde);
  }

  public void faire_retrait(){
    int numero_compte;
    double retrait, nouveau_solde;
    //Recuperation du numero de compte
    System.out.println("Bonjour sur quel compte voulez vous faire un depot ? : ");
    numero_compte = scanner.nextInt();
    //recuperation du client dans la listes de des clients
    Client client = banque.getClient(numero_compte);
    //recuperation du montant du retrait
    System.out.println("Votre solde est de " + client.getSolde() + ". Combien voulez vous retirer sur votre compte ? ");
    retrait = scanner.nextDouble();
    //test si la valeur est superieur au solde
    if(retrait > client.getSolde()){
      //on redemande la valeur
      System.out.println("Vous n'avez pas le droit de retirer plus que vous n'avez");
      System.out.println("Veuilez rentrer une autre valeur ");
      retrait = scanner.nextDouble();
    }
    //on modifie le solde
    nouveau_solde = client.getSolde() - retrait;
    //on met à jour le client
    banque.setNouveauSolde(numero_compte,nouveau_solde);
  }

  public void historique(){
    int numero_compte;
    //recuperation du compte
    System.out.println("Quel numéro de compte voulez vous voir ? ");
    numero_compte = scanner.nextInt();
    //on sort le client de la liste
    Client client = banque.getClient(numero_compte);
    //on affiche les informations
    System.out.println("Bonjour Mr."+  client.getNom() + " "+ client.getPrenom() + "Vous avez : "+ client.getSolde()+ "€ sur votre compte\n");
  }

  public void demande_pret(){
    //Todo
  }

  public void liste_pret(){
    //Todo

  }

  public void virement(){
    int numero_compte_debit, numero_compte_credit;
    double virement, solde_debit, solde_credit;
    //recuperation du compte débiteur
    System.out.println("Veuillez entrer le numero de compte à débiter : ");
    numero_compte_debit = scanner.nextInt();
    //recuperation du compte créditeur
    System.out.println("Veuillez entrer le numero de compte à créditer : ");
    numero_compte_credit = scanner.nextInt();
    //recuperation des deux clients dans la liste des clients
    Client debit = banque.getClient(numero_compte_debit);
    Client credit = banque.getClient(numero_compte_credit);
    //recuperation du montant du virement
    System.out.println("Veuiller entrer le montant du virement que vous souhaitez effectuer : ");
    virement = scanner.nextDouble();
    //test si la valeur est bonne
    if (virement >= debit.getSolde()){
      //on redemande une valeur
      System.out.println("La valeur est supérieur au solde du compte débiteur");
      System.out.println("Veuillez entrer une nouvelle valeur : ");
      virement = scanner.nextDouble();
    }
    //modification des solde des deux comptes
    solde_debit = debit.getSolde() - virement;
    solde_credit = credit.getSolde() + virement;
    //mise à jour des deux soldes des clients dans la liste des clients
    banque.setNouveauSolde(numero_compte_debit,solde_debit);
    banque.setNouveauSolde(numero_compte_credit,solde_credit);
  }

}
