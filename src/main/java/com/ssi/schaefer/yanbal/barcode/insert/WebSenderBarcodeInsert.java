package com.ssi.schaefer.yanbal.barcode.insert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ssi.schaefer.yanbal.article.insert.msgwritter.ArticleInsertWritter;
import com.ssi.schaefer.yanbal.barcode.insert.msgwritter.BarcodeInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.dbutils.QueriesLauncher;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class WebSenderBarcodeInsert {

	//*******************************************************************
	/** 						 				BARCODE INSERT  						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	public void createBarcodeInsert(String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		BarcodeInsertWritter.main("/barcodeInsertAf", "AF", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertAf", wamasHostIpRequested);

		BarcodeInsertWritter.main("/barcodeInsertPb", "PB", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertPb", wamasHostIpRequested);

		BarcodeInsertWritter.main("/barcodeInsertPd", "PD", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertPd", wamasHostIpRequested);
	}
}
