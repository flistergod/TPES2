package com.es2.Projeto_FInal;

import java.util.Calendar;

public class Recurso {
    int id=0, year=0;
    String name="", color="", pantone_value="";

    public static int conta_ids=1;


    public Recurso(String name, Integer year, String color, String pantone_value) throws colorException, pantoneException, yearException, RecursoException, CampoNullException {
        setName(name);
        this.id=conta_ids++;
        setColor(color);
        setPantone_value(pantone_value);
        setYear(year);
    }


    public int getId() {
        return id;
    }

    public int getYear() {

        return year;
    }

    public void setYear(Integer year) throws yearException, CampoNullException {

        if (year == null) {
            throw new CampoNullException();
        }

        if(year<2000 || year > Calendar.getInstance().get(Calendar.YEAR)){throw new yearException();}

        else{ this.year = year;}

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws RecursoException, CampoNullException {

        if(name!=null){
            this.name = name;}

        else{throw  new CampoNullException();}

        if(name.length()<3 || name.length()>30){
            throw  new  RecursoException();
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws colorException, CampoNullException, RecursoException {

        if(color==null){throw  new  CampoNullException();}

        if(color.contains("#")){
        this.color = color;} else throw  new colorException();

        if(color.length()<7 || color.length()>10){
            throw  new  RecursoException();
        }
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) throws pantoneException, CampoNullException, RecursoException {

        if(pantone_value==null){throw  new  CampoNullException();}

        if(pantone_value.contains("-")){
        this.pantone_value = pantone_value;}

        else throw  new pantoneException();

        if(pantone_value.length()<5 || pantone_value.length()>10){
            throw  new  RecursoException();
        }
    }

    @Override
    public String toString() {

        return "Recurso{" +
                "id=" + id +
                ", year=" + year +
                ", name=" + name +
                ", color=" + color +
                ", pantone_value=" + pantone_value +
                '}';
    }
}
