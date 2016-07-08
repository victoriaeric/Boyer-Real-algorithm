package BoyerMoore;

 class BM_algorithm {

	private final int  size	= 256;
	private int lastOccurence[] =new int[size];
	
	private void buildIndex(String pattern){
		int length =pattern.length();
		//赋初值
		for(int i=0; i<size; i++){
			lastOccurence[i] =-1 ;
		}
		for(int i=0; i< length; i++){
			lastOccurence[pattern.charAt(i)]=i;
		}
	}
	//找到要移动的长度
	private int findLast( char a){
		return lastOccurence[a];
	}
	public int find(String content, String pattern){
		if(content==null|| content.length()==0)
			return -1;
		if(pattern==null|| pattern.length()==0)
			return -1;
		if(content.length()<pattern.length())
			return -1;
		
		buildIndex(pattern);
		
		int start=pattern.length() -1;
		int end= content.length();
		int position, j;
		
		while(start< end){
			
			position =start;
			
			for(j= pattern.length()-1; j>=0; j--){
				
				if(pattern.charAt(j)!=content.charAt(position)){
					  
					if(findLast(content.charAt(position))!= -1){
						
						if(j - findLast(content.charAt(position))> 0){
							 
							start += j-findLast(content.charAt(position));
						}else{
							start +=1;
						}
					}else{
						start +=j+1; 
					}
					break;
				}
				if(j==0){
					return position;
				}
				position-- ;
			}
			
		}
		return -1;
	}
	
}
