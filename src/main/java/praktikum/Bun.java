package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить .
 */
public class Bun {

    public String name;
    public float price;
//Булочка
    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public float getPrice() {

        return price;
    }

}