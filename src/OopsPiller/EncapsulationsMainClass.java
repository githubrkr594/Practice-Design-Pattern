package OopsPiller;

public class EncapsulationsMainClass {
    public static void main(String[] args) {
        Movie movie = new Movie("The Lion King", 1994, "Adventure");
        movie.printDetails();
        System.out.println("---");
        movie.setTitle("Forrest Gump");
        System.out.print("New title: " + movie.getTitle());
    }
}

class Movie {
    // Data members

    private String title;
    private int year;
    private String genre;

    public Movie(String title, int year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    void printDetails() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
    }

}

/*
Note:
    The Movie class has an interface with public methods for communication.
    The private members (variables or functions) cannot be accessed directly
    from the outside, but public read and write functions allow access to them.
    This, in essence, is data encapsulation.

        Advantages of encapsulation
        Classes are simpler to modify and maintain.

        Which data member we wish to keep hidden or accessible can be specified.

        We choose which variables are read-only and write-only (increases flexibility).

*/
