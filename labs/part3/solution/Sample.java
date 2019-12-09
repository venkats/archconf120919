package com.agiledeveloper;

import java.util.*;
import java.io.*;

interface ConsumerWithException<T, E extends Exception> {
  void accept(T input) throws E;
}

class Writer {
	private FileWriter fileWriter;
	
	private Writer(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
	}
	
	public Writer writeStuff(String message) throws IOException {
		fileWriter.write(message);
		return this;
	}
	
	private void close() throws IOException {
		fileWriter.close();
	}
	
	public static void use(String fileName,
	  ConsumerWithException<Writer, IOException> block) throws IOException {
	    
	  Writer writer = new Writer(fileName);
	  
	  try {
	    block.accept(writer);
	  } finally {
	    writer.close();
	  }
	}
}

public class Sample {
  public static void useWriter(String fileName) throws IOException {
		Writer.use(fileName, writer ->
		  writer.writeStuff(new java.util.Date().toString())
		    .writeStuff("See ")
		    .writeStuff("this "));
  }

	public static void main(String[] args) throws IOException {
    final String fileName = "sample.txt";
    useWriter(fileName);
    System.out.println("sample.txt contains the following:");
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    reader.lines().forEach(System.out::println);
	}
}
