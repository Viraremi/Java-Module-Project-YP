import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator;
        int peopleCount;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("На скольких человек необходимо разделить счёт?");

            if (scanner.hasNextInt()){
                peopleCount = scanner.nextInt();
                scanner.nextLine();
            }
            else {
                System.out.println("Некорректное значение для подсчёта. Повторите попытку");
                scanner.nextLine();
                continue;
            }

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

            if (scanner.hasNextInt()){
                price = scanner.nextFloat();
                scanner.nextLine();
            }
            else{
                System.out.println("Некорректное значение цены. Повторите попытку");
                scanner.nextLine();
                continue;
            }

            if (price < 0){
                System.out.println("Некорректное значение цены. Повторите попытку");
                continue;
            }

            calculator.addProduct(new Product(name, price));
            System.out.println(String.format("Товар %s с ценой %.2f %s добавлен!", name, price, calculator.rubleFormat(price)));
            System.out.println("Если вы хотите завершить процесс добавления товаров, введите 'Завершить'");
            if (scanner.nextLine().equalsIgnoreCase("Завершить")){
                break;
            }
        }

        calculator.print();
    }
}