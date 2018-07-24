import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class FileThreads implements Runnable{
	
	private static String fileName;
	public FileThreads(ArrayList<String> list){
		
	}
	public static String getFileName(){
		return fileName;
	}
	
	public static ArrayList<String> readLines(String fileName) throws IOException
	{
			Path path = FileSystems.getDefault().getPath(fileName);
			
			//System.out.println(path.toString());

		    ArrayList<String> words = new ArrayList<String>();
			try
			{
			BufferedReader fileReader = Files.newBufferedReader(path);
			for(String line; (line = fileReader.readLine()) !=null;)
			{
				words = FileHandling.append1(words,line);
			}
			fileReader.close();
			}
			catch(IOException exception)
			{
				System.out.printf("Error");
				exception.printStackTrace();
			}
			int min = 0;
			int max = words.size();
			max -= 1;
			Random random = new Random();
			
			ArrayList<String> fiftyWords = new ArrayList<String>();
				for(int i = 0; i<=50; i++)
				{
					int  n = random.nextInt(max) + min;
					fiftyWords.add(words.get(n));
				}
				
				return fiftyWords;
	}
	
	
	public void run(){
		try{
		readLines(fileName);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
