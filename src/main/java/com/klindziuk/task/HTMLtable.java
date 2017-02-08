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

		// for(String s: args)
		// System.out.println(s);
		File folder = new File(".");
		Writer writer = new BufferedWriter(new FileWriter("./HTML.txt"));
		File[] listOfFiles = folder.listFiles();
		for (File directoryItem : listOfFiles) {
			
			BasicFileAttributes attr = Files.readAttributes(directoryItem.toPath(), BasicFileAttributes.class,
					LinkOption.NOFOLLOW_LINKS);
			Date creationTime = new Date(attr.creationTime().toMillis());
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM.dd.YYYY");
			String dateOfCreation = DATE_FORMAT.format(creationTime);
			
			if (directoryItem.isDirectory()) {

				String directory =  directoryItem.getName() + " DIR " +  " " + dateOfCreation + " " + folderSize(directoryItem);
				writer.write(directory);
				writer.append("\n");
			}
			if (directoryItem.isFile()) {
				String file = directoryItem.getName() + " FILE " + " " + dateOfCreation + " " + directoryItem.length();
				writer.write(file);
				writer.append("\n");
			}
		}
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
