import java.util.Scanner;

public class Main {

    static String[] menu;
    static CatalogManager manager = new CatalogManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu = new String[] {"Список фильмов", "Выдать фильм", "Вернуть фильм", "Добавить фильм", "Выйти из приложения"};

        int selectMenu;
        try {
            do {
                for (int i = 0; i < menu.length; i++) {
                    System.out.println((i + 1) + " " + menu[i]);
                }
                System.out.println("Выберите пункт меню: ");
                selectMenu = Integer.parseInt(scanner.nextLine());
                switch (selectMenu) {
                    //Для того чтобы коректно выводился список фильмов, переопределил метод toString для Film
                    case 1:
                        try {
                            for (Film film : manager.getAllFilm()) {
                                System.out.println(film.toString());
                            }
                        } catch (EmptyListException e) {
                            System.out.println("Список пуст: " + e.getClass().getName());
                        }
                        break;
                    case 2:
                        System.out.println("Введите название фильма: ");
                        String titleForTakeFilm = scanner.nextLine();
                        try {
                            manager.takeFilm(titleForTakeFilm);
                        } catch (ItemNotFoundException e) {
                            System.out.println("Такого фильма нет в базе: " + e.getClass().getSimpleName());
                        } catch (NoAvailableCopiesException e) {
                            System.out.println("Фильма сейчас нет на складе: " + e.getClass().getSimpleName());
                        }
                        break;
                    case 3:
                        System.out.println("Введите название фильма: ");
                        String titleForReturnFilm = scanner.nextLine();
                        try {
                            manager.returnFilm(titleForReturnFilm);
                        } catch (ItemNotFoundException e) {
                            System.out.println("Такого фильма нет в базе: " + e.getClass().getSimpleName());
                        }
                        break;
                    case 4:
                        System.out.println("Введите название фильма: ");
                        String title = scanner.nextLine();
                        System.out.println("Введите режисера фильма: ");
                        String director = scanner.nextLine();
                        System.out.println("Введите количество копий: ");
                        int availablecopies = Integer.parseInt(scanner.nextLine());
                        manager.addFilm(title, director, availablecopies);
                        break;
                }
            } while (selectMenu != 5);
            scanner.close();
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        //TODO: Сделать исключение, чтобы нельзя было вводить ничего кроме цифр
    }
}

