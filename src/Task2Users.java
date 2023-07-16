import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2Users {

    private static Map<String, String> userCredentials = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("Меню:");
            System.out.println("1. Додати нового користувача");
            System.out.println("2. Видалення існуючого користувача");
            System.out.println("3. Перевірити чи існує користувач");
            System.out.println("4. Змінити логін існуючого користувача");
            System.out.println("5. Змінити пароль існуючого користувача");
            System.out.println("0. Вийти з програми");

            System.out.print("Ваш вибір: ");

            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    checkUserExists();
                    break;

                case 4:
                    changeLogin();
                    break;
                case 5:
                    changePassword();
                    break;
                case 0:
                    System.out.println("The program exists");
                    break;
            }


        }while (choice!=0);
    }

    private static void addUser()
    {
        System.out.println("Enter login of new user: ");
        String login = scanner.next();

        if(userCredentials.containsKey(login))
        {
            System.out.println("User is already exists!");
        }
        else{
            System.out.print("Введіть пароль нового користувача: ");
            String password = scanner.next();

            userCredentials.put(login,password);
            System.out.println("Користувача успішно додано.");
        }
    }

    private static void removeUser()
    {
        System.out.print("Введіть логін користувача, якого потрібно видалити: ");
        String login = scanner.next();

        if(userCredentials.containsKey(login))
        {
            userCredentials.remove(login);
            System.out.println("Користувача успішно видалено.");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

    private static void checkUserExists()
    {
        System.out.print("Введіть логін користувача, якого потрібно перевірити в наявності: ");
        String login = scanner.next();

        if(userCredentials.containsKey(login))
        {
            System.out.println("Користувач з таким логіном існує.");
        } else {
            System.out.println("Користувача з таким логіном не існує.");
        }
    }

    private static void changePassword()
    {
        System.out.print("Введіть логін користувача, для якого потрібно змінити пароль: ");
        String login = scanner.next();
        if (userCredentials.containsKey(login)) {
            System.out.print("Введіть новий пароль для користувача: ");
            String newPassword = scanner.next();
            userCredentials.put(login, newPassword);
            System.out.println("Пароль користувача успішно змінено.");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

    private static void changeLogin()
    {
        System.out.print("Введіть логін користувача, для якого потрібно змінити login: ");
        String login = scanner.next();
        if (userCredentials.containsKey(login)) {
            System.out.print("Введіть новий login для користувача: ");
            String newLogin = scanner.next();

            String password = userCredentials.get(login);
            //REMOVE
            userCredentials.remove(login);
            //
            userCredentials.put(newLogin,password);


            System.out.println("Login користувача успішно змінено.");
        } else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

}
