import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = new ArrayList<>();

        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Додати елемент в список");
            System.out.println("2. Видалити елемент з списку");
            System.out.println("3. Показати вміст списку");
            System.out.println("4. Перевірити чи є значення в списку");
            System.out.println("5. Замінити значення в списку");
            System.out.println("0. Вийти з програми");

            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Введіть число, яке потрібно додати в список: ");
                    int numberToAdd = scanner.nextInt();
                    numberList.add(numberToAdd);
                    break;
                case 2:
                    System.out.print("Введіть індекс числа, яке потрібно видалити: ");
                    int indexToRemove = scanner.nextInt();

                    if(indexToRemove >= 0 && indexToRemove < numberList.size())
                    {
                        numberList.remove(indexToRemove);
                    }else{
                        System.out.println("Incorrect index!");
                    }
                    break;
                case 3:
                    System.out.println("Вміст списку: " + numberList);
                    break;
                case 4:
                    System.out.print("Введіть число, яке потрібно перевірити в списку: ");
                    int numberToCheck = scanner.nextInt();

                    boolean containsNumber = numberList.contains(numberToCheck);
                    if(containsNumber)
                    {
                        System.out.println("Digit " + numberToCheck + " in array");
                    }else{
                        System.out.println("Digit " + numberToCheck + " not in array");
                    }

                    break;
                case 5:

                    System.out.print("Введіть індекс числа, яке потрібно замінити: ");
                    int indexToReplace = scanner.nextInt();

                    if(indexToReplace >=0 && indexToReplace< numberList.size())
                    {
                        System.out.println("Enter new digit: ");
                        int newNumber = scanner.nextInt();
                        numberList.set(indexToReplace,newNumber);
                    }else{
                        System.out.println("Incorrect index");
                    }

                    break;
                case 0:
                    System.out.println(" The program exits!");
                    break;
                default:
                    System.out.println("Incorrect choice! ");
            }


        }while (choice!=0);


    }
}