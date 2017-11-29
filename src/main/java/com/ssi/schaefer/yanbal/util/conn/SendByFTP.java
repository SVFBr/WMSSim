package com.ssi.schaefer.yanbal.util.conn;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class SendByFTP {

	@SuppressWarnings("static-access")
	public static void main(String folderName, String wamasHostIp) {

		FTPClient ftpClient = new FTPClient();
		try {
			//ftpClient.connect("192.168.173.227");
			ftpClient.connect(wamasHostIp);
			ftpClient.login("convey99", "keines");
			ftpClient.changeWorkingDirectory("/hcom/to_ssi");
			ftpClient.enterLocalPassiveMode();

			System.out.println("Connected");

			CSVUtils cvs = new CSVUtils();
			String remoteDirPath = "/hcom/to_ssi";
			String localDirPath = cvs.getLocalDirPath() + folderName;

			FTPUtil.uploadDirectory(ftpClient, remoteDirPath, localDirPath, "");

			ftpClient.logout();
			ftpClient.disconnect();

			System.out.println("Disconnected");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}