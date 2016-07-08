package BoyerMoore;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                final String pattern= "Once that was found the subsequent characters";
                 BufferedReader  reader;
                 StringBuilder buffer;
                 String line;
                
            try{
            	reader= new BufferedReader( new FileReader("./file/content.txt"));
            	buffer= new StringBuilder();
            	line= reader.readLine();
            	
            	while(line!=null ){
            		buffer.append(line);
            		line=reader.readLine();
            	}
             
            	BM_algorithm test= new BM_algorithm();
            
            	long startTime= System.currentTimeMillis();
            	int resultA= test.find(buffer.toString(), pattern);
            	long endTime =System.currentTimeMillis();
            	System.out.println("When the pattern is only a sentencs: "+"'" +pattern+"'");
            	System.out.println("The running time is nealy: "+(endTime- startTime)*1000000000 +"s");
            	
            	
            	startTime= System.currentTimeMillis();
            	int resultB= test.find(buffer.toString(), pattern);
            	endTime= System.currentTimeMillis();
            
            	
            	System.out.println("The fisrt pattern is in the "+resultA+" th character");
            	assert resultA == resultB;
            	
            	reader.close();
            	
            	
            }catch(FileNotFoundException e){
            	e.printStackTrace();
            }catch(IOException e){
            	e.printStackTrace();
            }

	}

}
