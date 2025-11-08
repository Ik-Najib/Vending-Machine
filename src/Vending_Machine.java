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

    public static void updatestock() {
        Scanner scan = new Scanner(System.in);
        int choix;
        System.out.println("=====Mise a jour le stock et les prix======");
        System.out.println("1 = mise a jour le stock.");
        System.out.println("2 = ajoute un nouveau article.");
        System.out.println("3 = mise a jour les prix.");
        choix = scan.nextInt();

        if (choix == 1) {
            MajStock();
        } else if (choix == 2) {
            AjArticle();
        } else if (choix == 3) {
            Majprix();
        } else {
            System.out.println("Choix invalide.");
        }
    }

    public static void MajStock() {
        Scanner scann = new Scanner(System.in);
        System.out.println("===choiser un article.==");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        int article = scann.nextInt() - 1;

        if (article >= produits.size() || article < 0) {
            System.out.println("article n'existe pas.");
            return;
        } else {
            int quant;
            System.out.println("entrer la quantité: ");
            quant = scann.nextInt();
            stock.set(article, quant);
            System.out.println("Stock mis à jour !");
        }
    }

    public static void AjArticle() {
        Scanner sca = new Scanner(System.in);
        String nom;
        System.out.println("entre le nom de produit: ");
        nom = sca.next();
        double p;
        System.out.println("entre le prix: ");
        p = sca.nextDouble();
        int s;
        System.out.println("entre le stock: ");
        s = sca.nextInt();

        produits.add(nom);
        prix.add(p);
        stock.add(s);
        System.out.println("Article ajouté avec succès !");
    }

    public static void Majprix() {
        Scanner scann = new Scanner(System.in);
        System.out.println("===choiser un article.==");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }
        int article = scann.nextInt() - 1;

        if (article >= produits.size() || article < 0) {
            System.out.println("article n'existe pas.");
        } else {
            double nprix;
            System.out.println("entrer le prix: ");
            nprix = scann.nextDouble();
            prix.set(article, nprix);
            System.out.println("Prix mis à jour !");
        }
    }

    public static void main(String[] args) {
        updatestock();
    }
}
