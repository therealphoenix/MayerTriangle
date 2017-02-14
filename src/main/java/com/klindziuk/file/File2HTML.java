package com.klindziuk.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File2HTML {
	public final static String HTML_OPEN = "<html>";
	public final static String HTML_CLOSE = "</html>";
	public final static String BODY_OPEN = "<body>";
	public final static String BODY_CLOSE = "</body>";
	public final static String TABLE_OPEN = "<table style=\"background : linear-gradient(to top, #000, #FFF );\">";
	public final static String TABLE_CLOSE = "</table>";
	public final static String TR_OPEN = "<tr>";
	public final static String TR_CLOSE = "</tr>";
	public final static String TH_OPEN = "<th>";
	public final static String TH_CLOSE = "</th>";
	public final static String TD_OPEN = "<td>";
	public final static String TD_CLOSE = "</td>";

	public static long folderSize(File directory) {
		long length = 0;
		for (File file : directory.listFiles()) {
			if (file.isFile())
				length += file.length();
			else
				length += folderSize(file);
		}
		return length;
	}

	public static void main(String[] args) throws IOException {

		File folder = new File(".");

		Writer writer = new BufferedWriter(new FileWriter("./HTMLTable.html"));

		StringBuilder builder = new StringBuilder();
		builder.append(HTML_OPEN).append(BODY_OPEN).append(TABLE_OPEN).append(TR_OPEN).append(TH_OPEN).append("FILE")
				.append(TH_CLOSE).append(TH_OPEN).append(" TYPE ").append(TH_CLOSE).append(TH_OPEN)
				.append(" CREATION DATE ").append(TH_CLOSE).append(TH_OPEN).append("SIZE(KB) ").append(TH_CLOSE)
				.append(TR_CLOSE);

		File[] listOfFiles = folder.listFiles();
		for (File directoryItem : listOfFiles) {

			BasicFileAttributes attr = Files.readAttributes(directoryItem.toPath(), BasicFileAttributes.class,
					LinkOption.NOFOLLOW_LINKS);
			Date creationTime = new Date(attr.creationTime().toMillis());
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM.dd.YYYY");
			String dateOfCreation = DATE_FORMAT.format(creationTime);

			builder.append((TR_OPEN));
			
			boolean isItemDir = directoryItem.isDirectory();
			String type = isItemDir ? " DIR " : " FILE "; 
			long size = isItemDir ? folderSize(directoryItem) : directoryItem.length();

			builder.append(TD_OPEN).append(directoryItem.getName()).append(TD_CLOSE);
			builder.append(TD_OPEN).append(type).append(TD_CLOSE);
			builder.append(TD_OPEN).append(dateOfCreation).append(" ").append(TD_CLOSE);
			builder.append(TD_OPEN).append(size).append(TD_CLOSE);


//			if (directoryItem.isDirectory()) {
//
//				builder.append(TD_OPEN).append(directoryItem.getName()).append(TD_CLOSE);
//				builder.append(TD_OPEN).append(" DIR ").append(TD_CLOSE);
//				builder.append(TD_OPEN).append(dateOfCreation).append(" ").append(TD_CLOSE);
//				builder.append(TD_OPEN).append(folderSize(directoryItem)).append(TD_CLOSE);
//
//			}
//
//			if (directoryItem.isFile()) {
//
//				builder.append(TD_OPEN).append(directoryItem.getName()).append(TD_CLOSE);
//				builder.append(TD_OPEN).append(" FILE ").append(TD_CLOSE);
//				builder.append(TD_OPEN).append(dateOfCreation).append(" ").append(TD_CLOSE);
//				builder.append(TD_OPEN).append(directoryItem.length()).append(TD_CLOSE);
//
//			}
			builder.append((TR_CLOSE));
		}

		builder.append(TABLE_CLOSE).append(BODY_CLOSE).append(HTML_CLOSE);

		writer.write(builder.toString());

		writer.close();

	}
}
