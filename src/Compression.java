import java.util.ArrayList;


public class Compression {
	private ArrayList<Integer> arrayColors;
	private ArrayList<Integer> arrayTimes;
	boolean same = true;
	private boolean goodToGo;
	int occurences;
	private ArrayList<Integer> cantorPairArray;
	private ArrayList<ArrayList<Integer>> pairColorsAndTimes;
	
	public Compression(Image img){
		arrayColors = new ArrayList<Integer>();
		arrayTimes = new ArrayList<Integer>();
		goodToGo = img.getGoodToGo();
		int[] pixelArray = img.getArray();
		for(int i=0; i<pixelArray.length; i++){
			occurences = 1;
			same = true;
			while(same){
				if(pixelArray.length == i+1){
					same = false;
					arrayColors.add(pixelArray[i]);
					arrayTimes.add(occurences);
				}else if(pixelArray[i] == pixelArray[i+1]){
					occurences++;
					i++;
				}else{
					same = false;
					arrayColors.add(pixelArray[i]);
					arrayTimes.add(occurences);
				}
			}
		}
		cantorPairArray = cantorPairArray(arrayColors, arrayTimes);	
		pairColorsAndTimes = pairColorsAndTimes(arrayColors, arrayTimes);
	}
	
	
	
	public void getArrayString(ArrayList<Integer> arrayList){
		if(!goodToGo){
			System.out.print("{");
			for(int i = 0; i < arrayTimes.size(); i++){
				if(i != (arrayTimes.size() - 1)){
					System.out.print(Integer.toString(arrayList.get(i)) + ",");
				}else{
					System.out.print(Integer.toString(arrayList.get(i)) + "}");
				}	
			}
		}else{
			System.out.println("Array format incorrect: please change util value to false.");
		}
	}
	
	public ArrayList<Integer> getArrayTimes(){
		return arrayTimes;
	}
	
	public ArrayList<Integer> getArrayColors(){
		return arrayColors;
	}
	
	
	public int primitiveCantorPair(int color,int occurs){
		return (((color+occurs)*((color+occurs)+1)/2)+occurs);
	}
		
	public void getColors(){
		getArrayString(arrayColors);
	}
	
	public void getTimes(){
		getArrayString(arrayTimes);
	}
	
	public void getCantorPairs(){
		getArrayString(cantorPairArray);
	}
	
	public ArrayList<Integer> cantorPairArray(ArrayList<Integer> colors, ArrayList<Integer> times){
		ArrayList<Integer> pairArray = new ArrayList<Integer>();	
		for(int i=0; i<colors.size(); i++){
			pairArray.add(primitiveCantorPair(colors.get(i), times.get(i)));
		}
		return pairArray;
	}
	
	public ArrayList<Integer> getCantorPairArray(){
		return cantorPairArray;
	}
	
	//This method seems to be a dead end however the concept seems solid for reducing render time between frames
	//Try implementing something akin to this on lua side after decompression to 'pre-render' new frames and create local arrays based on change
	//flawed *array length varies from instance to instance after compression

	public ArrayList<ArrayList<Integer>> removeRepeatedElements(ArrayList<ArrayList<Integer>> arrayListOfCompressedImages){
		ArrayList<Integer> referenceArrayList = arrayListOfCompressedImages.get(0);
		ArrayList<ArrayList<Integer>> newArrayList = arrayListOfCompressedImages;
		int levels = arrayListOfCompressedImages.size();
		for(int i=0; i<referenceArrayList.size(); i++){ //horizontal sweep
			for(int x=1; x<levels; x++){ //vertical sweep
				if(referenceArrayList.get(i) == arrayListOfCompressedImages.get(x).get(i)){
					newArrayList.get(x).set(i,0);
				}else{
					newArrayList.get(x).set(i,0);
					//referenceArrayList = arrayListOfCompressedImages.get(x);
					//levels-=1;
				}
			}
		}
		return newArrayList;
	}

	public ArrayList<ArrayList<Integer>>  pairColorsAndTimes(ArrayList<Integer> colors, ArrayList<Integer> times){
		ArrayList<ArrayList<Integer>>  newArray = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<colors.size(); i++){
			ArrayList<Integer> pairHolder = new ArrayList<Integer>();
			pairHolder.add(colors.get(i));
			pairHolder.add(times.get(i));
			newArray.add(pairHolder);
		}
		return newArray;
		
	}
	public ArrayList<ArrayList<Integer>> getPairColorsAndTimes(){
		//System.out.println(pairColorsAndTimes);
		return pairColorsAndTimes;
		
	}
	
	public ArrayList<Integer> pair(int x, int y){
		ArrayList<Integer> pair = new ArrayList<Integer>();
		pair.add(x);
		pair.add(y);
		return pair;
	}
	
	public ArrayList<ArrayList<Integer>> relativeImageChangeArray(ArrayList<Integer> array1, ArrayList<Integer> array2){
		ArrayList<ArrayList<Integer>> newRelativeChangeArray = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<array1.size(); i++){
			if(array1.size() != array2.size()){
				System.out.println("Error: Arrays not the same size\nArray1: " + Integer.toString(array1.size()) 
						+ "\nArray2: " + Integer.toString(array2.size()));
				break;
			}
			if(!array1.get(i).equals(array2.get(i))){
				newRelativeChangeArray.add(pair(array2.get(i),i));
			}
		}
		return newRelativeChangeArray;
	}
	
	public ArrayList<ArrayList<Integer>> getRelativeImageChangeArrayList(ArrayList<Integer> image1, ArrayList<Integer> image2){
		ArrayList<ArrayList<Integer>> relativeImageChangeArrayList = relativeImageChangeArray(image1, image2);
		//System.out.println(relativeImageChangeArrayList);
		return relativeImageChangeArrayList;
	}
}






