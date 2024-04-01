import java.util.ArrayList;

public class Calculator {
    int people;
    float total = 0;
    ArrayList<Product> products = new ArrayList<>();
    Calculator(int people){
        this.people = people;
    }
    public void addProduct(Product newProduct){
        products.add(newProduct);
        total += newProduct.price;
    }
    public void print(){
        System.out.println("Добавленные товары:");
        for (int i = 0; i < products.size(); i ++){
            System.out.println(String.format("Продукт %s с ценой в %.2f %s", products.get(i).name, products.get(i).price, rubleFormat(products.get(i).price)));
        }
        System.out.println(String.format("\nИтого: %.2f %s", total, rubleFormat(total)));
        float perPerson = total / (float) people;
        System.out.println(String.format("Получается %.2f %s с человека", perPerson, rubleFormat(perPerson)));
    }

    public String rubleFormat(float price){
        int check = (int) price;
        String result = "ОшИбКаааааААаАаА";
        if (check % 100 >= 11 && check % 100 <= 19){
            result = "рублей";
        }
        else if (check % 10 == 1){
            result = "рубль";
        }
        else if (check % 10 >= 2 && check % 10 <= 4) {
            result = "рубля";
        }
        else{
            result = "рублей";
        }

        return result;
    }
}
