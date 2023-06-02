package Servlet;


import lombok.Getter;
public class Auto {
    @Getter private String name;        //Название игры
    @Getter private String body;       //Жанр
    @Getter private String transmission;    //Платформа
    @Getter private int year;         //Год
    @Getter private int mileage;        //Цена
    @Getter private int idInDatabase;//Уникальный номер в БД

    public Auto(String name, String body, String transmission, int year, int mileage, int idInDatabase) {
        this.name = name;
        this.body = body;
        this.transmission = transmission;
        this.year = year;
        this.mileage = mileage;
        this.idInDatabase = idInDatabase;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Auto auto = (Auto) obj;
        if(!name.equals(auto.name)) return false;
        if(!body.equals(auto.body)) return false;
        if(!transmission.equals(auto.transmission)) return false;
        if(year != auto.year) return false;
        if(idInDatabase != auto.idInDatabase) return false;
        return mileage == auto.mileage;

    }
    @Override
    public int hashCode() {
        int result = (int) (mileage ^ (mileage >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + transmission.hashCode();
        result = 31 * result + year;
        result = 31 * result + idInDatabase;
        return result;
    }
}
