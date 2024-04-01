import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("На скольких человек необходимо разделить счёт?");
            int peopleCount = scanner.nextInt();
            scanner.nextLine();
            if (peopleCount == 1){
                System.out.println("Зачем что то считать для одного человека?) Повторите попытку");
            }
            else if (peopleCount < 0) {
                System.out.println("Некорректное значение для подсчёта. Повторите попытку");
            }
            else if (peopleCount > 1){
                calculator = new Calculator(peopleCount);
                System.out.println("Ок, начинаем считать!");
                break;
            }
        }

        String name;
        float price;
        while (true){
            System.out.println(
                    "Добавим товар в список! \n" +
                    "Введите название товара:");
            name = scanner.nextLine();
            System.out.println("Введите цену товара в формате [рубли],[копейки], например 10,45 или 11,40:");
            price = scanner.nextFloat();
            scanner.nextLine();
            calculator.addProduct(new Product(name, price));
            System.out.println(String.format("Товар %s с ценой %.2f добавлен!", name, price));
            System.out.println("Если вы хотите завершить процесс добавления товаров, введите 'Завершить'");
            if (scanner.nextLine().equalsIgnoreCase("Завершить")){
                break;
            }
        }

        calculator.print();
    }
}