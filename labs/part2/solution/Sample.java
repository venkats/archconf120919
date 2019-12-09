import java.util.*;
import java.util.stream.Stream;
import java.util.function.Function;
import java.io.*;
import java.nio.file.*;
import static java.util.stream.Collectors.*;
                      
@SuppressWarnings("unchecked")
abstract class Writer {
  private Function<String, String> operation;
  
  public Writer(Function<String, String>... operations) {
    operation = Stream.of(operations)
      .reduce(Function.identity(), Function::andThen);
  }
  
  public void write(String input) throws IOException {
    writeString(operation.apply(input));
  }                
  
  abstract public void writeString(String input) throws IOException;
  abstract public String getContents() throws IOException;
}

@SuppressWarnings("unchecked")
class StringWriter extends Writer {
  private StringBuilder contents = new StringBuilder();
  
  public StringWriter(Function<String, String>... operations) {
    super(operations);
  }

  public void writeString(String input) {
  	contents.append(input);
	}                        
	
	public String getContents() {
	  return contents.toString();
	}
}

@SuppressWarnings("unchecked")
class FileWriter extends Writer {
  private String fileName = "contents.txt";

  public FileWriter(Function<String, String>... operations) {
    super(operations);
    new File(fileName).delete();
  }
  

  public void writeString(String input) throws IOException {
  	try(var writer = new java.io.FileWriter(new File(fileName), true)) {
      writer.append(input);
    }
	}
	
	public String getContents() throws IOException {
		return Files.lines(Paths.get(fileName)).collect(joining(""));    
	}
}

@SuppressWarnings("unchecked")
public class Sample {  
  public static void writeToWriter(Writer writer) throws IOException {
    writer.write("This is really really stupid!!!");
  }
  
  public static void main(String[] args) {
    try {
      Function<String, String> stupidReplacer =
        input -> input.replace("stupid", "s*****");
      
      StringWriter writer1 = 
        new StringWriter(String::toLowerCase, stupidReplacer);
      writeToWriter(writer1);

      System.out.println(writer1.getContents());

      FileWriter writer2 =
        new FileWriter(stupidReplacer, String::toUpperCase);
      writeToWriter(writer2);

      System.out.println(writer2.getContents());
    } catch(IOException ex) {
      System.out.println(ex);
    }
  }
}