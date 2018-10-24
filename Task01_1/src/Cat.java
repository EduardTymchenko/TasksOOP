/*
Описать класс «Cat» (в качестве образца можно взять домашнего
питомца). Наделить его свойствами и методами. Создать несколько
экземпляров объектов этого класса. Использовать эти объекты.
 */

public class Cat {
    private String name;
    private String breed;
    private String colorCatHair;
    private String colorCatEyes;
    private double age;

    public Cat(String name, String breed, String colorCatHair, String colorCatEyes, double age){
        this.name = name;
        this.breed = breed;
        this.colorCatHair = colorCatHair;
        this.colorCatEyes = colorCatEyes;
        this.age = age;
    }

    public void sleep(){
        System.out.println("Now " + getName() + " is sleep.");
    }
    public void eat(String food){
        System.out.println(getName() + " is eating " + food);
    }
    public void vote(String voice){
        System.out.println(getName() + " say: " + voice);
    }

    public String toString(){
        return "This is " + this.colorCatHair + " cat " + this.name + ". It is " + this.breed + " cat breed." + "\n" +
                "It has " + this.colorCatEyes + " eyes. It is " + this.age + " years old." + "\n";
    }
    //Use only class
    private String getName() {
        return name;
    }
}
