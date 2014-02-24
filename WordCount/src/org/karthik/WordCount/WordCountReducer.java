package org.karthik.WordCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		Text words = new Text();
		final IntWritable NullWritable = null;
		words.set("My Program Starts Here....");
		context.write(words, NullWritable);
	}

	@Override
	protected void cleanup(Context context) throws IOException,
			InterruptedException {
		Text words = new Text();
		final IntWritable NullWritable = null;
		words.set("My Program Ends Here....");
		context.write(words, NullWritable);
	}

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		context.write(key, new IntWritable(sum));
	}
}
