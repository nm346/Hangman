import java.util.ArrayList;

public class Parallel implements Runnable {
  static String fileName;

  public void run() {

	for (int i = 1; i < 5; i++) {
	  ArrayList<String> a = new ArrayList<String>();
	  a.addAll(FileHandling.readLines(fileName));
	  FileHandling.allLists.addAll(a);

	  if (FileHandling.allLists.size() == 200) {
		// System.out.println(FileHandling.allLists);
		return;
	  }

	}

  }
}
