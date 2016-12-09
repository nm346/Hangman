import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class FileHandling implements Serializable {

  public static ArrayList<String> chosenList = new ArrayList<String>();
  public static ArrayList<String> allLists = new ArrayList<String>();
  public static ArrayList<String> allLists1 = new ArrayList<String>();
  private static final long serialVersionUID = 1L;
  public static long timeForParallel;
  public static long timeForSequential;

  public FileHandling(ArrayList<String> all, String file) { // CONSTRUCTOR

  }

  public static void main(String[] args) {
  }

  public static void runInParallel() {
	long start = System.currentTimeMillis();
	ReadOptions.parallel();
	long time = System.currentTimeMillis() - start;
	timeForParallel = time;
	System.out.println("It took " + time + " millisecond to select the words in parallel");
  }

  public static void runInSequential() {
	long start = System.currentTimeMillis();
	ReadOptions.sequentially();
	long time = System.currentTimeMillis() - start;
	timeForSequential = time;
	System.out.println("it took " + time + " milliseconds to select the words sequentially");
  }

  public static void binarySerialize(ArrayList<String> lists, String fileName) {

	Path path = FileSystems.getDefault().getPath("/s_home/nm346/workspace/FileHandling/Mini Project Part 1", fileName);
	try {
	  ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(path));
	  objectStream.writeObject(lists);
	} catch (IOException exception) {
	  System.out.println("Something went wrong");
	  exception.printStackTrace();
	}

  }

  public static ArrayList<String> readLines(String fileName) {
	Path path = FileSystems.getDefault().getPath("/s_home/nm346/workspace/FileHandling/Mini Project Part 1", fileName);
	// System.out.println(path.toString());

	ArrayList<String> words = new ArrayList<String>();
	try {
	  BufferedReader fileReader = Files.newBufferedReader(path);
	  for (String line; (line = fileReader.readLine()) != null;) {
		words = append1(words, line);
	  }
	  fileReader.close();
	} catch (IOException exception) {
	  System.out.printf("Error");
	  exception.printStackTrace();
	}
	int min = 0;
	int max = words.size();
	max -= 1;
	Random random = new Random();

	ArrayList<String> fiftyWords = new ArrayList<String>();
	for (int i = 0; i < 50; i++) {
	  int n = random.nextInt(max) + min;
	  fiftyWords.add(words.get(n));
	}

	return fiftyWords;
  }

  static ArrayList<String> append1(ArrayList<String> l0, String o) {
	ArrayList<String> l = l0;
	l.add(l.size(), o);
	return l;

  }

}
