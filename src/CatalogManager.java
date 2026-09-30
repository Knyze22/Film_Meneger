import java.util.ArrayList;
import java.util.List;

public class CatalogManager {

    private final List<Film> catalog = new ArrayList<Film>();

    public void addFilm(String title, String director, int copies) {
        //boolean done = false;
        if (copies <= 0){
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        Film film = new Film(title, director, copies);
        catalog.add(film);
    }

    public void takeFilm(String title) throws ItemNotFoundException, NoAvailableCopiesException {
        boolean isFind = false;
        for (Film film: catalog) {
            if(film.getTitle().equals(title)){
                if(film.getAvailableCopies() != 0){
                    film.setAvailableCopies(film.getAvailableCopies() - 1);
                    isFind = true;
                } else {
                    throw new NoAvailableCopiesException("Количество копий фильма меньше одного");
                }
                break;
            }
        }
        if(!isFind){
            throw new ItemNotFoundException("Фильм не найден");
        }
    }

    public void returnFilm(String title) throws ItemNotFoundException{
        boolean isFind = false;
        for (Film film: catalog) {
            if(film.getTitle().equals(title)){
                film.setAvailableCopies(film.getAvailableCopies() + 1);
                isFind = true;
            }
        }
        if(!isFind){
            throw new ItemNotFoundException("Фильм не найден");
        }
    }

    public List<Film> getAllFilm() throws EmptyListException{
        if(!catalog.isEmpty()){
            return catalog;
        } else {
            throw new EmptyListException("Список пуст");
        }
    }
}
