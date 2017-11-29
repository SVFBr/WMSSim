package com.ssi.schaefer.yanbal.article.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.article.insert.msgwritter.ArticleInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class WebSenderArticleInsert {

	// *******************************************************************
	/**
	 * ARTICLES INSERT BY WEB .-. .-""`""-. |(@ @) _/`oOoOoOoOo`\_ \ \-/
	 * '.-=-=-=-=-=-=-.' \/ \ `-=.=-.-=.=-' \ /\ ^ ^ ^ _H_ \ [575 afr] [368 pbl]
	 * [100 pdc]
	 **/
	// *******************************************************************

	static String[] arrDevice = { "AF", "PB", "PD" };

	public void createArticleInsert(int articleInsertAFrame, int articleInsertPbl, int articleInsertPdc, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (articleInsertAFrame > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = articleInsertAFrame;
			String folderName = "/articleInsertAf";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (articleInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = articleInsertPbl;
			String folderName = "/articleInsertPb";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (articleInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = articleInsertPdc;
			String folderName = "/articleInsertPd";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
	}
}
