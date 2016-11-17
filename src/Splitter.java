//Scrapped because the entire mod ran on a single thread makeing sudo multithreading impossible
public class Splitter {
	
	private int[] array;
	private boolean goodToGo;
	public Splitter(Image img){
		array = img.getArray();
		goodToGo = img.getGoodToGo();		
	}
	
	public void getSpliter(int threads){
		int split = array.length/threads;
		int addSplit = split;
		if(!goodToGo){
			System.out.print("{");
			for(int i=0; i<array.length; i++){
				if(i < split){
					System.out.print(Integer.toString(array[i]) + ", ");
					if(i==array.length-1){
						System.out.print(Integer.toString(array[i]) + "}");
					}
				}else{
					System.out.println(Integer.toString(array[i]) + "}");
					System.out.print("{");
					split+=addSplit;
				}
			}
		}else{
			System.out.println("Array format incorrect: please change util value to false.");
		}
	}
}
