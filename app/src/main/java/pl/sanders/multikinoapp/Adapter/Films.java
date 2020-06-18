package pl.sanders.multikinoapp.Adapter;

public class Films {
    public String description;
    public String country;
    public String director;
    public String genre;
    public String name;
    public String photo;
    public String trailer;
    public String played="true";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public Films(){}

    public Films(String description, String country, String director, String genre, String name, String photo, String trailer, String played) {
        this.description = description;
        this.country=country;
        this.director = director;
        this.genre = genre;
        this.name = name;
        this.photo = photo;
        this.trailer = trailer;
        this.played = played;
    }


}
