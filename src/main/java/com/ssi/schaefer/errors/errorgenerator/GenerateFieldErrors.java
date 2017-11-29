package com.ssi.schaefer.errors.errorgenerator;

import java.util.ArrayList;
import java.util.List;

import com.ssi.schaefer.entities.Field;

/**
 * Created by felipe on 06/03/17.
 */
public class GenerateFieldErrors {

    public static void generateFieldMaxSizeError(Field field){


        StringBuilder bigString = new StringBuilder();

        for (int i = 1; i <= field.getMaxSize()+5; i++){

            bigString.append("c");
        }

        field.setValue(bigString.toString());
    }

    public static void generateFieldWrongFormatError(Field field){

        switch (field.getType()) {

            case NUMERIC:
                field.setValue("ABC");
                break;

            case ALPHANUMERIC:
                field.setValue("@!%");
                break;

            case TIMESTAMP:
                field.setValue("30029999");
                break;

            case BOOLEAN:
                field.setValue("2");
                break;
        }
    }

    public static void generateWrongFieldNameError(Field field){

        List<Character> characters = new ArrayList<Character>();
        for(char c:field.getId().toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(field.getId().length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }

        field.setId(output.toString());

    }

    public static void generateMandatoryMissingError(Field field){

        if(field.isMandatory()){
            field.setId(" ");
        }

    }

}


