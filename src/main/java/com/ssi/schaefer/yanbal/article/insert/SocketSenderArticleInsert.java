package com.ssi.schaefer.yanbal.article.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.article.insert.msgwritter.ArticleInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class SocketSenderArticleInsert {

	//*******************************************************************
	/** 						 				ARTICLES INSERT BY SOCKET 						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \    [575 afr] [368 pbl] [100 pdc]
	 **/
	//*******************************************************************

//	static String wamasHostIpRequested = "192.168.173.222"
	static String wamasHostIpRequested = "10.34.234.2";
	static String[] arrDevice = { "AF", "PB", "PD"};

	static int articleInsertAFrame = 575; // 575
	static int articleInsertPbl = 368; // 368
	static int articleInsertPdc = 100; // 100

	//*******************************************************************

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		if (articleInsertAFrame > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = articleInsertAFrame;
			String folderName = "/articleInsertSocAf";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (articleInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = articleInsertPbl;
			String folderName = "/articleInsertSocPb";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (articleInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = articleInsertPdc;
			String folderName = "/articleInsertSocPd";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		
	}
}
