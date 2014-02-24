package org.karthik.PartitionProject;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartition extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text text, IntWritable count, int numReduceTasks) {
		char[] words = text.toString().toCharArray();
		int asciiVal = words[0];
		if (numReduceTasks == 0) {
			return 0;
		} 
		if( ((asciiVal > 64) && (asciiVal < 78) ) || ((asciiVal > 96) && (asciiVal < 110)) ){
			return 0;
		} else {
			return 1;
		}
	}
}
