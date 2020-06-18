package pl.sanders.multikinoapp.Adapter;

public class Event {
    public String description;
    public String name;
    public String photo;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    public Event(){}

    public Event(String name,String description, String photo) {
        this.description = description;
        this.name = name;
        this.photo = photo;
    }


}
