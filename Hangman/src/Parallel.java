import java.util.ArrayList;

public class Parallel implements Runnable{
	public String fileName = ReadOptions.getFileName();
	public void run(){
			
		for(int i = 0; i <= 4; i++){
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(FileHandling.readLines(fileName));
			FileHandling.allLists.addAll(a);
			
			if(FileHandling.allLists.size()==200){
				//FileHandling.chosenList = allLists;
				FileHandling.chosenList = FileHandling.allLists;
				System.out.println(FileHandling.allLists);
			}
			
		}
	}
}



