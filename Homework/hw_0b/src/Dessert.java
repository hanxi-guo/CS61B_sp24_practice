public class Dessert {
    public int flavor;
    public int price;
    public static int numDesserts = 0;
    //using static variable to count instances
    //ensures that numDesserts is shared among all instances of Dessert.

    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        //use this.flavor and this.price in the constructor
        // to disambiguate them from the constructor parameters flavor and price.
        numDesserts++;
    }

    public void printDessert(){
        System.out.println(this.flavor + " " + this.price + " " + numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
//        Dessert dessert1 = new Dessert(1, 100);
//        dessert1.printDessert();
//        Dessert dessert2 = new Dessert(2, 150);
//        dessert2.printDessert();
    }
}
