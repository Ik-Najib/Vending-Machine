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
                    System.out.println("Fonction d'achat (à implémenter par Dev2)");
                    break;
                case 3 :
                    System.out.println("Merci et à bientôt !");
                    break;
                default :
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choice != 3);
    }

    public static void afficherProduits() {
        System.out.println("Produits disponibles : ");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        System.out.println();
    }
}
