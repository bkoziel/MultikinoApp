package pl.sanders.multikinoapp.Adapter;

import java.util.Date;

public class News {
    public String description;
    public String description2;
    public String name;
    public String photo;
    public Date date;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public News(){}

    public News(String name,String description,String description2, String photo, Date date) {
        this.description = description;
        this.name = name;
        this.photo = photo;
        this.description2 = description2;
        this.date = date;
    }


}
