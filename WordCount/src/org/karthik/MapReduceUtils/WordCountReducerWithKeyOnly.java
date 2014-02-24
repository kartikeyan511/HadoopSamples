package org.karthik.MapReduceUtils;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducerWithKeyOnly extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	private static final IntWritable NullWritable = null;

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		context.write(key, NullWritable);
	}
}
