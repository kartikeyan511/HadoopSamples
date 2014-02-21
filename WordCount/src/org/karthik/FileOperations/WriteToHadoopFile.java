package org.karthik.FileOperations;

import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;

public class WriteToHadoopFile {

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		BufferedWriter brW = null;
		try {
			FileSystem fs = FileSystem.get(new Configuration());
			br = new BufferedReader(new InputStreamReader(fs.open(new Path(
					args[0]))));
			brW = new BufferedWriter(new OutputStreamWriter(fs.create(new Path(
					args[1]), true)));
			String line;
			line = br.readLine();
			while (line != null) {
				brW.write(line);
				line = br.readLine();
			}
			System.out.println("Completed Write Operation");
		} catch (Exception e) {
			System.out.println("Either Read or Write Operation got failed.");
		} finally {
			br.close();
			brW.close();
		}
	}
}