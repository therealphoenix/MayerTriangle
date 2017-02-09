package com.klindziuk.task;

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

public class HTMLtable {

	public static void main(String[] args) throws IOException {

		
		File folder = new File(".");
		StringBuilder htmlBuilder = new StringBuilder();
		
		htmlBuilder.append("--------------------------------------------------")
		.append("<br>")
		.append("<html>")
		.append("<body>")
		.append("<table")
		.append("<tr>")
		.append("<th> File </th>")
		.append("<th> Type </th>")
		.append("<th> Creation date </th>")
		.append("<th> Size (in KB) </th>")
		.append("</tr>")
	    .append("<br>")
		.append("--------------------------------------------------")
		.append("<br>");
		String html = htmlBuilder.toString();
		
		
		Writer writer = new BufferedWriter(new FileWriter("./HTML.html"));
		writer.write(html);
		htmlBuilder.setLength(0);
		
		
		File[] listOfFiles = folder.listFiles();
		for (File directoryItem : listOfFiles) {
			
			BasicFileAttributes attr = Files.readAttributes(directoryItem.toPath(), BasicFileAttributes.class,
					LinkOption.NOFOLLOW_LINKS);
			Date creationTime = new Date(attr.creationTime().toMillis());
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM.dd.YYYY");
			String dateOfCreation = DATE_FORMAT.format(creationTime);
			
			if (directoryItem.isDirectory()) {
				htmlBuilder.append("<tr>");
				htmlBuilder.append("<td>").append(directoryItem.getName()).append("</td>");
				htmlBuilder.append("<td>").append(" DIR ").append("</td>");
				htmlBuilder.append("<td>").append(dateOfCreation).append(" ").append("</td>");
				htmlBuilder.append("<td>").append(folderSize(directoryItem)).append("</td>");
				htmlBuilder.append("</tr>");
				htmlBuilder.append("<br>");
				
				writer.write(htmlBuilder.toString());
				htmlBuilder.setLength(0);
				


			}
			if (directoryItem.isFile()) {
			    htmlBuilder.append("<tr>");
				htmlBuilder.append("<td>").append(directoryItem.getName()).append("</td>");
				htmlBuilder.append("<td>").append(" FILE ").append("</td>");
				htmlBuilder.append("<td>").append(dateOfCreation).append(" ").append("</td>");
				htmlBuilder.append("<td>").append(directoryItem.length()).append("</td>");
				htmlBuilder.append("</tr>");
				htmlBuilder.append("<br>");
				
				writer.write(htmlBuilder.toString());
				htmlBuilder.setLength(0);
			}
		}
		htmlBuilder.append("</table>" +
		           "</body>" +
		           "</html>").append("--------------------------------------------------");
		writer.write(htmlBuilder.toString());
		writer.close();

	}

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

}
