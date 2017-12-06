package com.ssi.schaefer.yanbal.util.tools;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CSVUtils {

	private static final char DEFAULT_SEPARATOR = ' ';
	private static String localDirPath = "e:/_WMSSim";

	public static void writeLine(Writer w, List<String> values) throws IOException {
		writeLine(w, values, DEFAULT_SEPARATOR, ' ');
	}

	public static String getLocalDirPath() {
		return localDirPath;
	}

	public static void setLocalDirPath(String localDirPath) {
		CSVUtils.localDirPath = localDirPath;
	}

	public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
		writeLine(w, values, separators, ' ');
	}

	private static String followCVSformat(String value) {
		String result = value;
		return result;
	}

	public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

		boolean first = true;

		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}

		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			if (!first) {
				sb.append(separators);
			}
			if (customQuote == ' ') {
				sb.append(followCVSformat(value));
			} else {
				sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
			}

			first = false;
		}
		sb.append("\n");
		w.append(sb.toString());

	}

	public static File genPath(String folderName) {
		// String home = System.getProperty("user.home");
		// File path = new File(home + File.separator + "_ToFTP" + File.separator +
		// folderName);
		File path = new File(localDirPath + folderName);
		path.mkdirs();
		return path;
	}

	public static void checkIfFileExistAt(String folderName) {
		// String home = System.getProperty("user.home");
		// File path = new File(home + File.separator + "_ToFTP" + File.separator +
		// folderName);
		File path = new File(localDirPath + folderName);
		String[] entries = path.list();
		if (entries != null) {
			for (String string : entries) {
				File currentFile = new File(path.getPath(), string);
				currentFile.delete();
			}
		}
	}

	public static void deleteAllFolders() throws IOException {
		FileUtils.deleteDirectory(new File(localDirPath));
		System.out.println("\n[THE END...] \n");
	}

}