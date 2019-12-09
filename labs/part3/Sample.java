package com.agiledeveloper;

import java.util.*;
import java.io.*;

//You have been given a writer class and a Sample class. Compile them, run Sample, and see the sample.txt file. It's empty.
//Close did not happen. Redesign the code so the programmer using the Writer does not have to worry about close, so it
//happens automatically when the writer object is no longer needed.


class Writer {
	private FileWriter fileWriter;
	
	public Writer(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
	}
	
	public void writeStuff(String message) throws IOException {
		fileWriter.write(message);
	}
	
	public void finalize() throws IOException {
		fileWriter.close();
	}
}

public class Sample {
  public static void useWriter(String fileName) throws IOException {
		Writer writer = new Writer(fileName);
		writer.writeStuff(new java.util.Date().toString());
		writer.writeStuff("See ");
		writer.writeStuff("this ");
  }

	public static void main(String[] args) throws IOException {
    final String fileName = "sample.txt";
    useWriter(fileName);
    System.out.println("sample.txt contains the following:");
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    reader.lines().forEach(System.out::println);
	}
}
