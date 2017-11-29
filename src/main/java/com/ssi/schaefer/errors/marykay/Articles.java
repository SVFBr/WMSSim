package com.ssi.schaefer.errors.marykay;

import com.ssi.schaefer.entities.Field;
import com.ssi.schaefer.errors.FieldTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felip on 12/03/2017.
 */
public class Articles {

    //Article-Insert
    private Field articleID = new Field("article_id", 14, Field.dataType.ALPHANUMERIC, true, "ART01");
    private Field articleName = new Field("article_name", 40, Field.dataType.ALPHANUMERIC, true, "ART01");
    private Field description = new Field("description", 200, Field.dataType.ALPHANUMERIC, false, "Fragancia");
    private Field minDurability = new Field("min_durability", 9, Field.dataType.NUMERIC, false, "1234");
    private Field hasLot = new Field("has_lot", 5, Field.dataType.BOOLEAN, false, "false");
    private Field hasExpiryDate = new Field("has_expiry_date", 5, Field.dataType.BOOLEAN, false, "false");
    private Field hasWeight = new Field("has_weight", 5, Field.dataType.BOOLEAN, false, "false");

    // mainfield is always the same
    private String mainField = "articles";


    /**
     *
     */
    public void articleInsert() {

        List<Field> articleInsert = new ArrayList<>();
        String minorField = "article_insert";

        articleInsert.add(articleID);
        articleInsert.add(articleName);
        articleInsert.add(description);
        articleInsert.add(minDurability);
        articleInsert.add(hasLot);
        articleInsert.add(hasExpiryDate);
        articleInsert.add(hasWeight);

        FieldTest.HCOMFieldTest(articleInsert, mainField, minorField);

    }

    public void articleDelete(){

        List<Field> articleDel = new ArrayList<>();
        String minorField = "article_delete";

        articleDel.add(articleID);

        FieldTest.HCOMFieldTest(articleDel, mainField, minorField);

    }


    public void articleLock(){

        List<Field> articleLock = new ArrayList<>();
        String minorField = "article_lock";

        articleLock.add(articleID);

        FieldTest.HCOMFieldTest(articleLock, mainField, minorField);

    }

  }