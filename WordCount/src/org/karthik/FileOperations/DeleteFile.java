package org.karthik.FileOperations;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DeleteFile {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
			FileSystem fs = FileSystem.get(new Configuration());
			if (fs.exists(new Path(args[0]))) {
				fs.delete(new Path(args[0]), true);
				System.out.println("Completed Deletion Operation");
			} else {
				System.out.println("The Path does'nt exixts in the filesystem");
			}
		} catch (Exception e) {
			System.out.println("Either Read or Write Operation got failed.");
		}
	}
}
