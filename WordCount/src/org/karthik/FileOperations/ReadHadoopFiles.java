package org.karthik.FileOperations;

import java.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;

public class ReadHadoopFiles {

	public static void main(String[] args) throws Exception {
		try {
			FileSystem fs = FileSystem.get(new Configuration());
			FileStatus[] status = fs.listStatus(new Path(args[0]));
			for (int i = 0; i < status.length; i++) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						fs.open(status[i].getPath())));
				String line;
				line = br.readLine();
				while (line != null) {
					 System.out.println(line);
					line = br.readLine();
				}
			}
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}
}
