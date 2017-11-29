package com.ssi.schaefer.errors;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ssi.schaefer.entities.Field;
import com.ssi.schaefer.errors.errorgenerator.GenerateFieldErrors;
import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

/**
 * Created by felip on 12/03/2017.
 */
public class FieldTest {

    /**
     *
     */

	static String wamasHostIpRequested = "192.168.173.227";
	
	public static void HCOMFieldTest(List<Field> fieldList, String mainField, String minorField) {

        List<HashMap<String, String>> finalStatus = null;
        String logSizeQuery = "SELECT INFO, STATUS from message_log where dbms_lob.instr(payload_raw, 'ccccccccccc') >= 1 and ROWNUM <=1 and MESSAGE_TYPE='UNKNOWN' order by MLOG_ID desc";
        String logFormatQuery = " ";
        String logFieldNameQuery = " ";
        String logMandatoryQuery = " ";


        for (int i = 0; i <= fieldList.size(); i++) {

            String originalID = fieldList.get(i).getId();
            String originalValue = fieldList.get(i).getValue();

            //------------------------------------------------------------------------------------
            GenerateFieldErrors.generateFieldMaxSizeError(fieldList.get(i));
            try {
                createDatFile(fieldList, mainField, minorField);
                finalStatus.add(process(fieldList.get(i), logSizeQuery));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fieldList.get(i).setId(originalID);
                fieldList.get(i).setValue(originalValue);
            }


            //------------------------------------------------------------------------------------
            GenerateFieldErrors.generateFieldWrongFormatError(fieldList.get(i));
            try {
                createDatFile(fieldList, mainField, minorField);
                finalStatus.add(process(fieldList.get(i), logFormatQuery));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fieldList.get(i).setId(originalID);
                fieldList.get(i).setValue(originalValue);
            }

            //------------------------------------------------------------------------------------
            GenerateFieldErrors.generateWrongFieldNameError(fieldList.get(i));
            try {
                createDatFile(fieldList, mainField, minorField);
                finalStatus.add(process(fieldList.get(i), logFieldNameQuery));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fieldList.get(i).setId(originalID);
                fieldList.get(i).setValue(originalValue);
            }


            //------------------------------------------------------------------------------------
            GenerateFieldErrors.generateMandatoryMissingError(fieldList.get(i));
            try {
                if(fieldList.get(i).isMandatory()) {
                    createDatFile(fieldList, mainField, minorField);
                    finalStatus.add(process(fieldList.get(i), logMandatoryQuery));
                }else {
                    HashMap<String, String> notMandatory = new HashMap<>();
                    notMandatory.put("STATUS","NA");
                    notMandatory.put("INFO", "Field is not Mandatory");
                    finalStatus.add(notMandatory);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fieldList.get(i).setId(originalID);
                fieldList.get(i).setValue(originalValue);
            }
        }

    }

    /**
     *
     * @param fieldList
     * @param mainFieldName
     * @param minorFieldName
     * @throws IOException
     */
    private static void createDatFile(List<Field> fieldList, String mainFieldName, String minorFieldName) throws IOException {

        // Creating file at path @sf
        File path = CSVUtils.genPath("test");
        String csvFile = path + File.separator + "file.dat";

        java.io.FileWriter writer = new java.io.FileWriter(csvFile);

        StringBuilder content = new StringBuilder();


        for (int i = 0; i <= fieldList.size()-1; i++) {

            //style article_id="value"
            content.append(fieldList.get(i).getId() + "=\"" + fieldList.get(i).getValue() + "\"");

            if (i < fieldList.size()-1) {
                content.append(",");
            }

        }

        //opens majorField
        CSVUtils.writeLine(writer, Arrays.asList("<" + mainFieldName + ">"));

        //minorField + content
        CSVUtils.writeLine(writer, Arrays.asList(" ", "<" + minorFieldName + " " + content + "/>"));

        //closes majorField
        CSVUtils.writeLine(writer, Arrays.asList("</" + mainFieldName + ">"));

        writer.flush();
        writer.close();
    }


    /**
     *
     * @param field
     * @param query
     * @return
     */
    private static HashMap<String, String> process(Field field, String query) {

        //Send file to server
     //   FTP.sendFileToServer();


        List<HashMap<String, String>> log = null;

        try {

            TimeUnit.MINUTES.sleep(1);
            log = DatabaseQueries.executeQuery(query, wamasHostIpRequested);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return log.get(0);

    }

}