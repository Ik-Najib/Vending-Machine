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
            System.out.println("3. Quitter");
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
                    System.out.println("Merci et à bientôt !");
                    break;
                default :
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choice != 3);

        input.close();
    }

    public static void afficherProduits() {
        System.out.println("Produits disponibles : ");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        System.out.println();
    }

    public static void acheterProduit(Scanner sc) {
        System.out.println("\n=== Achat d’un produit ===");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }

        System.out.print("\nEntrez le numéro du produit : ");
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
}
