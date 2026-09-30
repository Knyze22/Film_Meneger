import java.util.Scanner;

public class Main {

    static String[] menu;
    static CatalogManager manager = new CatalogManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu = new String[] {"Список фильмов", "Выдать фильм", "Вернуть фильм", "Добавить фильм", "Выйти из приложения"};

        int selectMenu = 0;

            do {
                for (int i = 0; i < menu.length; i++) {
                    System.out.println((i + 1) + " " + menu[i]);
                }
                System.out.println("Выберите пункт меню: ");
                try{
                    selectMenu = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Введено не число: " + e.getMessage());
                }
                switch (selectMenu) {
                    case 1:
                        try {
                            for (Film film : manager.getAllFilm()) {
                                System.out.println(film.toString());
                            }
                        } catch (EmptyListException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Введите название фильма: ");
                        String titleForTakeFilm = scanner.nextLine();
                        try {
                            manager.takeFilm(titleForTakeFilm);
                            System.out.println("Фильм выдан");
                        } catch (ItemNotFoundException e) {
                            System.out.println("Такого фильма нет в базе: " + e.getMessage());
                        } catch (NoAvailableCopiesException e) {
                            System.out.println("Фильма сейчас нет на складе: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Введите название фильма: ");
                        String titleForReturnFilm = scanner.nextLine();
                        try {
                            manager.returnFilm(titleForReturnFilm);
                            System.out.println("Фильм сдан");
                        } catch (ItemNotFoundException e) {
                            System.out.println("Такого фильма нет в базе: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Введите название фильма: ");
                        String title = scanner.nextLine();
                        System.out.println("Введите режиссера фильма: ");
                        String director = scanner.nextLine();
                        System.out.println("Введите количество копий: ");
                        try{
                            int availableCopies = Integer.parseInt(scanner.nextLine());
                            manager.addFilm(title, director, availableCopies);
                            System.out.println("Фильм добавлен успешно");
                        } catch (NumberFormatException e) {
                            System.out.println("Введено не число: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Введено некорректное число: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Введено некорректное число");
                }

            } while (selectMenu != 5);
            scanner.close();
    }
}

