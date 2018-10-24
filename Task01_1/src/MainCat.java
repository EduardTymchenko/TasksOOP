public class MainCat {
    public static void main(String[] args) {
        Cat catOne = new Cat("Barsik","british longhair","gray","yellow",1);
        System.out.println(catOne.toString());
        Cat catTwo = new Cat("Murzik","maine coon","redhead","green",0.5);
        System.out.println(catTwo.toString());
        catOne.sleep();
        catOne.vote("Mrrr");
        for (int i = 0; i < 3; i++) {
            catTwo.vote("meow");
        }
        catTwo.eat("Milk");
    }
}
