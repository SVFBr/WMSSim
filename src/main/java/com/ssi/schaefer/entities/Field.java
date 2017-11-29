package com.ssi.schaefer.entities;

/**
 * Created by felip on 12/03/2017.
 */
public class Field {


    public Field(String id, int maxSize, dataType type, boolean mandatory, String value){

        this.id = id;
        this.maxSize = maxSize;
        this.type = type;
        this.mandatory = mandatory;
        this.value = value;

    }

    public enum dataType {

        NUMERIC, ALPHANUMERIC, TIMESTAMP, BOOLEAN

    }

    //nome do campo
    private String id;
    //tamanho max
    private int maxSize;
    //tipo: ver ENUM
    private dataType type;
    //Obrigatório ou não
    private boolean mandatory;
    //valor
    private String value;


    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public dataType getType() {
        return type;
    }

    public void setType(dataType type) {
        this.type = type;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
