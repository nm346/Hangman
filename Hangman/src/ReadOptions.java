import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadOptions
{
	private static String fileName;
	
	public ReadOptions(){
	} //CONSTRUCT
	
	public static String getFileName(){
		return fileName;
	}
	
	public static void sequentially(){
		ArrayList<String> list1 = FileHandling.readLines("file1.txt"); //for thread do all at the same time,
		ArrayList<String> list2 = FileHandling.readLines("file2.txt");
		ArrayList<String> list3 = FileHandling.readLines("file3.txt");
		ArrayList<String> list4 = FileHandling.readLines("file4.txt");
		FileHandling.allLists1.addAll(list1);//for thread do all at the same time,
		FileHandling.allLists1.addAll(list2);
		FileHandling.allLists1.addAll(list3);
		FileHandling.allLists1.addAll(list4);
		//FileHandling.chosenList = FileHandling.allLists1;
		System.out.println(FileHandling.allLists1);
	}
	
	  public static void parallel(){
		  Parallel pp = new Parallel();
		  ExecutorService exe = Executors.newFixedThreadPool(4);//thread pool, no more than 4 threads at a time
	  		for(int i = 1; i < 5; i++){
	  		fileName = "file"+i+".txt";
			Runnable p = new Parallel();
			exe.submit(p);
			//new Thread(p).start();
			}
	  		try{
	  		exe.shutdown();
	  		//exe.awaitTermination(1, TimeUnit.SECONDS);
	  		}
	  		catch(Exception e){
	  			e.printStackTrace();
	  		}
	  		
		}
	
}
