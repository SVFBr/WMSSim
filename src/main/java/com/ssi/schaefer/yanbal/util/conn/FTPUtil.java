package com.ssi.schaefer.yanbal.util.conn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUtil {

	/**
	 * Upload a whole directory (including its nested sub directories and files) to
	 * a FTP server.
	 *
	 * @param ftpClient
	 *            an instance of org.apache.commons.net.ftp.FTPClient class.
	 * @param remoteDirPath
	 *            Path of the destination directory on the server.
	 * @param localParentDir
	 *            Path of the local directory being uploaded.
	 * @param remoteParentDir
	 *            Path of the parent directory of the current directory on the
	 *            server (used by recursive calls).
	 * @throws IOException
	 *             if any network or IO error occurred.
	 */
	public static void uploadDirectory(FTPClient ftpClient, String remoteDirPath, String localParentDir,
			String remoteParentDir) throws IOException {

		System.out.print("  LISTING directory: " + localParentDir + "\n");

		File localDir = new File(localParentDir);
		File[] subFiles = localDir.listFiles();
		if (subFiles != null && subFiles.length > 0) {
			for (File item : subFiles) {
				String remoteFilePath = remoteDirPath + "/" + remoteParentDir + "/" + item.getName();
				if (remoteParentDir.equals("")) {
					remoteFilePath = remoteDirPath + "/" + item.getName();
				}

				if (item.isFile()) {
					// upload the file
					String localFilePath = item.getAbsolutePath();
					System.out.println("  About to upload the file:" + localFilePath);
					boolean uploaded = uploadSingleFile(ftpClient, localFilePath, remoteFilePath);
					if (uploaded) {
						System.out.println("  UPLOADED a file to: " + remoteFilePath + "\n");
					} else {
						System.out.println("  COULD NOT upload the file: " + localFilePath);
					}
				} else {
					// create directory on the server
					boolean created = ftpClient.makeDirectory(remoteFilePath);
					if (created) {
						System.out.println("  CREATED the directory: " + remoteFilePath);
					} else {
						System.out.println("  COULD NOT create the directory: " + remoteFilePath);
					}

					// upload the sub directory
					String parent = remoteParentDir + "/" + item.getName();
					if (remoteParentDir.equals("")) {
						parent = item.getName();
					}

					localParentDir = item.getAbsolutePath();
					uploadDirectory(ftpClient, remoteDirPath, localParentDir, parent);
				}
			}
		}
	}

	/**
	 * Upload a single file to the FTP server.
	 *
	 * @param ftpClient
	 *            an instance of org.apache.commons.net.ftp.FTPClient class.
	 * @param localFilePath
	 *            Path of the file on local computer
	 * @param remoteFilePath
	 *            Path of the file on remote the server
	 * @return true if the file was uploaded successfully, false otherwise
	 * @throws IOException
	 *             if any network or IO error occurred.
	 */
	public static boolean uploadSingleFile(FTPClient ftpClient, String localFilePath, String remoteFilePath)
			throws IOException {
		File localFile = new File(localFilePath);

		InputStream inputStream = new FileInputStream(localFile);
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			return ftpClient.storeFile(remoteFilePath, inputStream);
		} finally {
			inputStream.close();
		}

	}
}