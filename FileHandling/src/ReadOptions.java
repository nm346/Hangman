import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadOptions {
  private String fileName;

  public ReadOptions() {
  } // CONSTRUCT

  public String getFileName() {
	return fileName;
  }
  
/*
ArrayList<String> amateur = new ArrayList<String>(); // word less than 4
ArrayList<String> SemiPro = new ArrayList<String>(); // between 4 and 5
ArrayList<String> Professional = new ArrayList<String>(); // between 6 and 8
ArrayList<String> Legendary = new ArrayList<String>(); // greater than 9

public void difficulty(){
	for(int i = 0; i < FileHandling.chosenList.size(); i++){
		
	  if(length(FileHandling.chosenList.get(i)) < 4){
		  amateur.add(FileHandling.chosenList.get(i));
		}
		
	  else if(length(FileHandling.chosenList.get(i)) >= 4 &&length(FileHandling.chosenList.get(i)) <= 5){
		  amateur.add(FileHandling.chosenList.get(i));
		}
	  
	  else if(length(FileHandling.chosenList.get(i)) >= 6 &&length(FileHandling.chosenList.get(i)) <= 8){
		  amateur.add(FileHandling.chosenList.get(i));
		}
	  
	  else if(length(FileHandling.chosenList.get(i)) >= 9){
		  amateur.add(FileHandling.chosenList.get(i));
		}
}

}


public int length(String a){
int i = 0;	
String copy = a;
while(true){
	if(copy.equals("")) return i;
	copy = copy.substring(1);
	i++;
	}
}

*/

  public static void sequentially() {
	ArrayList<String> list1 = FileHandling.readLines("file1.txt"); // for thread
	                                                               // do all at
	                                                               // the same
	                                                               // time,
	ArrayList<String> list2 = FileHandling.readLines("file2.txt");
	ArrayList<String> list3 = FileHandling.readLines("file3.txt");
	ArrayList<String> list4 = FileHandling.readLines("file4.txt");
	FileHandling.allLists1.addAll(list1);// for thread do all at the same time,
	FileHandling.allLists1.addAll(list2);
	FileHandling.allLists1.addAll(list3);
	FileHandling.allLists1.addAll(list4);

	// System.out.println(FileHandling.allLists1);
  }

  public static void parallel() {
	ExecutorService exe = Executors.newFixedThreadPool(4);// thread pool, no
	                                                      // more than 4 threads
	                                                      // at a time
	for (int i = 1; i < 5; i++) {
	  Parallel.fileName = "file" + i + ".txt";
	  Runnable p = new Parallel();
	  exe.submit(p);
	  // new Thread(p).start();
	}
	try {
	  exe.shutdown();
	  // exe.awaitTermination(1, TimeUnit.SECONDS);
	} catch (Exception e) {
	  e.printStackTrace();
	}

  }

}
