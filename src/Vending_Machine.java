import java.util.*;

public class Vending_Machine {
    static ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
    static ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
    static ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));


    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("=== Distributeur Automatique ===");
            System.out.println("1. Afficher les produits");
            System.out.println("2. Acheter un produit");
            System.out.println("3. Mise a jour le stock et les prix");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            choice = input.nextInt();

            switch (choice) {
                case 1 :
                    afficherProduits();
                    break;
                case 2 :
                    acheterProduit(input);
                    break;
                case 3 :
                    updatestock();
                    break;
                case 4 :
                    System.out.println("Merci et à bientôt !");
                    break;
                    default :
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choice != 4);

        input.close();
    }


    public static void afficherProduits() {
        System.out.println("=== Produits disponibles ===");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        System.out.println();
    }


    public static void acheterProduit(Scanner sc) {
        System.out.println("=== Achat d’un produit ===");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }

        System.out.print("Entrez le numéro du produit : ");
        int choix = sc.nextInt();

        if (choix < 1 || choix > produits.size()) {
            System.out.println("Numéro invalide !");
            return;
        }
        int index = choix - 1;
        if (stock.get(index) == 0) {
            System.out.println("Produit en rupture de stock !");
            return;
        }
        System.out.print("Entrez le montant inséré (MAD) : ");
        double montant = sc.nextDouble();
        double prixProduit = prix.get(index);
        if (montant < prixProduit) {
            System.out.println("Montant insuffisant. Il manque " + (prixProduit - montant) + " MAD.");
            return;
        }
        stock.set(index, stock.get(index) - 1);
        double monnaie = montant - prixProduit;
        System.out.println("Achat réussi : " + produits.get(index));
        System.out.println("Monnaie rendue : " + monnaie + " MAD");
    }


    static final String MotDePasseADMIN = "admin123";
    public static void updatestock() {
        Scanner scan = new Scanner(System.in);
        System.out.println("===Accès Administration Sécurisé===");
        System.out.print("Entrez le mot de passe (admin123) : ");
        String motDePasse = scan.nextLine();
        if (!motDePasse.equals(MotDePasseADMIN)) {
            System.out.println(" Mot de passe incorrect. Accès refusé.");
            return;
        }
        int choix;
        System.out.println("===== Menu Administration =====");
        System.out.println("1. mise a jour le stock.");
        System.out.println("2. ajoute un nouveau article.");
        System.out.println("3. mise a jour les prix.");
        System.out.println("4. Supprimer un article.");
        System.out.print("Choix : ");
        choix = scan.nextInt();
        scan.nextLine();
        if (choix == 1) {
            MajStock();
        } else if (choix == 2) {
            AjArticle();
        } else if (choix == 3) {
            Majprix();
        } else if (choix == 4) {
            SupprimerArticle();
        } else {
            System.out.println("Choix invalide.");
        }
    }


    public static void MajStock() {
        Scanner scann = new Scanner(System.in);
        System.out.println("===choiser un article===");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        System.out.println("choix : ");
        int article = scann.nextInt() - 1;

        if (article >= produits.size() || article < 0) {
            System.out.println("article n'existe pas.");
        }
        else {
            int quant;
            System.out.println("entrer la quantité: ");
            quant = scann.nextInt();
            if (quant < 0) {
                System.out.println("le stock non négatif.");
                return;}
            stock.set(article, quant);

        }
    }

    public static void AjArticle() {
        Scanner sca = new Scanner(System.in);
        String nom;
        System.out.println("=== ajoute un nouveau article ===");
        System.out.println("entre le nom de produit: ");
        nom = sca.next();
        double p;
        System.out.println("entre le prix: ");
        if (!sca.hasNextDouble()) { System.out.println("Prix invalide."); sca.next(); return; }
        p = sca.nextDouble();
        int s;
        System.out.println("entre le stock: ");
        if (!sca.hasNextInt()) { System.out.println("Stock invalide."); sca.next(); return; }
        s = sca.nextInt();
        if (p <= 0 ) {
            System.out.println("Prix doit être positif .");
            return;}
        if (s < 0) {
            System.out.println("le stock non négatif.");
            return;}
        produits.add(nom);
        prix.add(p);
        stock.add(s);
        System.out.println("Article ajouté avec succès !");
    }


    public static void Majprix() {
        Scanner scann = new Scanner(System.in);
        System.out.println("===choiser un article===");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        System.out.println("choix : ");
        int article = scann.nextInt() - 1;
        if (article >= produits.size() || article < 0) {
            System.out.println("article n'existe pas.");
        } else {
            double nprix;
            System.out.println("entrer le prix: ");
            nprix = scann.nextDouble();
            if (nprix <= 0 ) {
                System.out.println("Prix doit être positif .");
                return;}
            prix.set(article, nprix);
            System.out.println("Prix mis à jour !");
        }
    }


    public static void SupprimerArticle() {
        Scanner scan = new Scanner(System.in);
        int choix;
        System.out.println("=== Suppression d'un article ===");

        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD)");
        }
        System.out.print("Entrez le numéro de l'article à supprimer : ");
        if (!scan.hasNextInt()) {
            System.out.println("Numéro invalide.");
            scan.next();
            return;
        }
        choix = scan.nextInt() - 1;
        if (choix < 0 || choix >= produits.size()) {
            System.out.println("Numéro d'article invalide !");
            return;
        }
        String nomSupprime = produits.remove(choix);
        prix.remove(choix);
        stock.remove(choix);
        System.out.println(" L'article '" + nomSupprime + "' a été supprimé avec succès.");
    }
}
