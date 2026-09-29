
public class Film {

    private String title;
    private String director;
    private int availableCopies;


    public Film(String title, String director, int availableCopies){
        this.title = title;
        this.director = director;
        this.availableCopies = availableCopies;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAvailableCopies(){
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies){
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Фильм: " +
                "Название - " + title +
                ", Режиссер - " + director +
                ", Количество - " + availableCopies;
    }
}