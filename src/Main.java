import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Решение задач №1 и №2 по теме: Коллекции List.
 * Класс по реализации списка продуктов.
 */
public class Main {

    private static List<String> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Добавить");
            System.out.println("2. Показать список");
            System.out.println("3. Удалить позицию из списка");
            System.out.println("4. Найти наименование продукта из списка по ключевому слову");

            String rawInput = scanner.nextLine();
            int parseInt = Integer.parseInt(rawInput);

            switch (parseInt) {
                case 1:
                    System.out.println("Какую покупку хотите добавить? Напишите наименование продукта: ");
                    String nameOfProductCase1 = scanner.nextLine();
                    if (!nameOfProductCase1.isBlank()) {
                        productList.add(nameOfProductCase1);
                    }
                    System.out.println("Итого в списке продуктов: " + productList.size());
                    break;
                case 2:
                    printListOfProducts(productList);
                    break;
                case 3:
                    String nameOfProductCase3;
                    if (!printListOfProducts(productList)) {
                        continue;
                    }
                    System.out.println("Какой продукт из списка хотите удалить? Введите номер позиции или наименование продукта: ");
                    if (scanner.hasNextInt()) {
                        String removeProduct;
                        nameOfProductCase3 = scanner.nextLine();
                        try {
                            int inputNumber = Integer.parseInt(nameOfProductCase3);
                            removeProduct = productList.remove(inputNumber - 1);
                        } catch (Exception e) {
                            System.out.println("Товар с наименованием только из цифр невозможно удалить по названию! только по номеру позиции!");
                            continue;
                        }
                        System.out.println("Позиция " + "\"" + removeProduct + "\"" + " удалена");
                    } else {
                        nameOfProductCase3 = scanner.nextLine();
                        while (productList.remove(nameOfProductCase3))
                            System.out.println("Позиция " + "\"" + nameOfProductCase3 + "\"" + " удалена");
                    }
                    printListOfProducts(productList);
                    break;
                case 4:
                    if (!printListOfProducts(productList)) {
                        continue;
                    }
                    System.out.println("Введите текст для поиска: ");
                    String nameOfProductCase4 = scanner.nextLine();
                    checkMatch(nameOfProductCase4, productList);
                    break;
                default:
                    System.out.println("Такой операции нет!");
            }
        }
    }

    private static boolean printListOfProducts(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("Список продуктов пуст!");
            return false;
        }
        System.out.println("Список покупок: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "- " + list.get(i));
        }
        return true;
    }

    private static boolean checkMatch(String rawProduct, List<String> list) {
        String productNameCase = rawProduct.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String productNameInList = list.get(i).toLowerCase();
            if (productNameInList.contains(productNameCase)) {
                System.out.println("Найдено совпадение: " + (i + 1) + "- " + list.get(i));
                return true;
            }
        }
        System.out.println("Совпадений не найдено!");
        return false;
    }
}

