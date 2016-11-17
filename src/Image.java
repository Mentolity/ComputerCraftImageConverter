import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Image {
	private static BufferedImage img;
	private Compression compressedImage;
	public int width;
	public int height;
	private int[] pixels;
	private boolean goodToGo;
	private Splitter splitImage;
	private int ArrayNumber;
	private static int Incrementer = 1;
	private static ArrayList<Image> arrayListOfInstances = new ArrayList<Image>();
	
	public Image(String path){
		this(path, false);
	}		

	public Image(String path, boolean util){
		try{
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		width = img.getWidth();
		height = img.getHeight();
		pixels = new int[width*height];	
		ArrayNumber = Incrementer++;
		
		
		int pixel;
		int red;
		int green;
		int blue;
		int index = 0;
		if(!util){
			goodToGo = false;
			for(int y=0; y<height; y++){
				for(int x=0; x<width; x++){
					pixel = (img.getRGB(x, y));
					blue = pixel & 0xff;
					green = (pixel & 0xff00) >> 8;
					red = (pixel & 0xff0000) >> 16;
					if(red==240 && green==240 && blue==240){
						pixels[index] = 1; //white
					}else if(red==242 && green==178 && blue==51){
						pixels[index] = 2; //orange
					}else if(red==229 && green==127 && blue==216){
						pixels[index] = 3; //magenta
					}else if(red==153 && green==178 && blue==242){
						pixels[index] = 4; //lightblue
					}else if(red==222 && green==222 && blue==108){
						pixels[index] = 5; //yellow
					}else if(red==127 && green==204 && blue==25){
						pixels[index] = 6; //lime
					}else if(red==242 && green==178 && blue==204){
						pixels[index] = 7; //pink
					}else if(red==76 && green==76 && blue==76){
						pixels[index] = 8; //gray
					}else if(red==153 && green==153 && blue==153){
						pixels[index] = 9; //lightgray
					}else if(red==76 && green==153 && blue==178){
						pixels[index] = 10; //cyan
					}else if(red==178 && green==102 && blue==229){
						pixels[index] = 11; //purple
					}else if(red==51 && green==102 && blue==204){
						pixels[index] = 12; //blue
					}else if(red==127 && green==102 && blue==76){
						pixels[index] = 13; //brown
					}else if(red==87 && green==166 && blue==78){
						pixels[index] = 14; //green
					}else if(red==204 && green==76 && blue==76){
						pixels[index] = 15; //red
					}else if(red==25 && green==25 && blue==25){
						pixels[index] = 16; //black
					}else{
						pixels[index] = 1;
					}
					index++;
				}
			}
		}else{
			goodToGo = true;
			for(int y=0; y<height; y++){
				for(int x=0; x<width; x++){
					pixel = (img.getRGB(x, y));
					blue = pixel & 0xff;
					green = (pixel & 0xff00) >> 8;
					red = (pixel & 0xff0000) >> 16;
					if(red==240 && green==240 && blue==240){
						pixels[index] = 0; //white
					}else if(red==242 && green==178 && blue==51){
						pixels[index] = 1; //orange
					}else if(red==229 && green==127 && blue==216){
						pixels[index] = 2; //magenta
					}else if(red==153 && green==178 && blue==242){
						pixels[index] = 3; //lightblue
					}else if(red==222 && green==222 && blue==108){
						pixels[index] = 4; //yellow
					}else if(red==127 && green==204 && blue==25){
						pixels[index] = 5; //lime
					}else if(red==242 && green==178 && blue==204){
						pixels[index] = 6; //pink
					}else if(red==76 && green==76 && blue==76){
						pixels[index] = 7; //gray
					}else if(red==153 && green==153 && blue==153){
						pixels[index] = 8; //lightgray
					}else if(red==76 && green==153 && blue==178){
						pixels[index] = 9; //cyan
					}else if(red==178 && green==102 && blue==229){
						pixels[index] = 10; //purple
					}else if(red==51 && green==102 && blue==204){
						pixels[index] = 11; //blue
					}else if(red==127 && green==102 && blue==76){
						pixels[index] = 12; //brown
					}else if(red==87 && green==166 && blue==78){
						pixels[index] = 13; //green
					}else if(red==204 && green==76 && blue==76){
						pixels[index] = 14; //red
					}else if(red==25 && green==25 && blue==25){
						pixels[index] = 15; //black
					}else{
						pixels[index] = 0;
					}
					index++;
				}
			}
		}
		compressedImage = new Compression(this);
		splitImage = new Splitter(this);
		arrayListOfInstances.add(this);
	}
				
	public int pixelRGB(int x){
		return pixels[x];
	}
	
	public void pixelRGBArray(){
		if(!goodToGo){
			System.out.print("Array" + ArrayNumber + "={");
			for(int i = 0; i < pixels.length; i++){
				if(i != (pixels.length - 1)){
					System.out.print(Integer.toString(pixels[i]) + ",");
				}else{
					System.out.print(Integer.toString(pixels[i]) + "}\n");
				}
			}
		}else{
			System.out.println("Array format incorrect: please change util value to false.");
		}
	}
	
	public void paintUtilTable(){
		if(goodToGo){
			int line=0;
			for(int i = 0; i < pixels.length; i++){
				if(i != (pixels.length)){
					if(line!=161){
						if(pixels[i] < 10){
							System.out.print(Integer.toString(pixels[i]));
							line++;
						}else{
							if(pixels[i]==10){
								System.out.print("a");
								line++;
							}else if(pixels[i]==11){
								System.out.print("b");
								line++;
							}else if(pixels[i]==12){
								System.out.print("c");
								line++;
							}else if(pixels[i]==13){
								System.out.print("d");
								line++;
							}else if(pixels[i]==14){
								System.out.print("e");
								line++;
							}else if(pixels[i]==15){
								System.out.print("f");
								line++;
							}	
						}
					}else{
						if(pixels[i] < 10){
							System.out.println(Integer.toString(pixels[i]));
							line=0;
						}else{
							if(pixels[i]==10){
								System.out.println("a");
								line=0;
							}else if(pixels[i]==11){
								System.out.println("b");
								line=0;
							}else if(pixels[i]==12){
								System.out.println("c");
								line=0;
							}else if(pixels[i]==13){
								System.out.println("d");
								line=0;
							}else if(pixels[i]==14){
								System.out.println("e");
								line=0;
							}else if(pixels[i]==15){
								System.out.println("f");
								line=0;
							}	
						}
					}
				}
			}
		}else{
			System.out.println("Array format incorrect: please change util value to true.");
		}
	}
	
	public int[] getArray(){
		return pixels;
	}
	
	public void getCompressedImage(){
		System.out.print("\nArray" + ArrayNumber + "=");
		compressedImage.getCantorPairs();
	}
	
	public ArrayList<ArrayList<Integer>> getArrayListOfCompressedImages(ArrayList<Image> arrayListOfInstances){
		ArrayList<ArrayList<Integer>> arrayListOfCompressedImages = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<arrayListOfInstances.size(); i++){
			arrayListOfCompressedImages.add(arrayListOfInstances.get(i).compressedImage.getCantorPairArray());
		}
		return this.compressedImage.removeRepeatedElements(arrayListOfCompressedImages);
	}
	
	public void getCompressedImageArrays(){
		ArrayList<ArrayList<Integer>> arrayList = getArrayListOfCompressedImages(arrayListOfInstances);
		for(int i=0; i<arrayList.size();i++){
			System.out.print("\nArray" + Integer.toString(i+1) +"={");
			for(int x=0; x<arrayList.get(i).size(); x++){
				if(x != (arrayList.get(i).size() - 1)){
					System.out.print(Integer.toString(arrayList.get(i).get(x)) + ",");
				}else{
					System.out.print(Integer.toString(arrayList.get(i).get(x)) + "}");
				}	
			}
		}
	}	

	public void getSplitImage(int threads){
		splitImage.getSpliter(threads);
	}
	
	public boolean getGoodToGo(){
		return goodToGo;
	}


	public ArrayList<ArrayList<ArrayList<Integer>>> pairArray(ArrayList<Image> arrayListOfInstances){
		ArrayList<ArrayList<ArrayList<Integer>>> pairArrayOfInstances = new ArrayList<ArrayList<ArrayList<Integer>>>();	
		for(int i=0; i<arrayListOfInstances.size(); i++){
			pairArrayOfInstances.add(arrayListOfInstances.get(i).compressedImage.getPairColorsAndTimes());
		}
		return pairArrayOfInstances;
	}
	
	//Array of Images; Array of Image; Array Pair;
	public void outPutPairArray(){
		ArrayList<ArrayList<ArrayList<Integer>>> pairArrayOfInstances = pairArray(arrayListOfInstances);
		for(int i=0; i<pairArrayOfInstances.size(); i++){
			System.out.print("\nArray" + Integer.toString(i+1) +"={");
			for(int x=0; x<pairArrayOfInstances.get(i).size(); x++){
				if(x != (pairArrayOfInstances.get(i).size() - 1)){
					if(pairArrayOfInstances.get(i).get(x).get(1) != 1){
						System.out.print("{" + Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(0)) + "," 
						+ Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(1)) + "},");
					}else{
						System.out.print(Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(0)) + ",");
					}				
				}else{
					System.out.print("{" + Integer.toString(pairArrayOfInstances.get(i).get(x).get(0)) + "," 
							+ Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(1)) + "}}");
					if(pairArrayOfInstances.get(i).get(x).get(1) != 1){
						System.out.print("{" + Integer.toString(pairArrayOfInstances.get(i).get(x).get(0)) + "," 
								+ Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(1)) + "}}");
					}else{
						System.out.print(Integer.toHexString(pairArrayOfInstances.get(i).get(x).get(0)) + "}");
					}
				}	
			}
		}
	}

	public ArrayList<Integer> arrayToArrayList(int[] array){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++){
			arrayList.add(array[i]);
		}
		return arrayList;
	}
	
	public ArrayList<ArrayList<ArrayList<Integer>>> getRelativeImageChangeArrayList(ArrayList<Image> arrayListOfInstances){
		ArrayList<ArrayList<ArrayList<Integer>>> relativeImageChangeArrayList = new ArrayList<ArrayList<ArrayList<Integer>>>();
		relativeImageChangeArrayList.add(compressedImage.getRelativeImageChangeArrayList(arrayToArrayList(arrayListOfInstances.get(arrayListOfInstances.size()-1).pixels), 
				arrayToArrayList(arrayListOfInstances.get(0).pixels)));
		for(int image=0; image<arrayListOfInstances.size()-1; image++){
			relativeImageChangeArrayList.add(compressedImage.getRelativeImageChangeArrayList(arrayToArrayList(arrayListOfInstances.get(image).pixels), 
					arrayToArrayList(arrayListOfInstances.get(image+1).pixels)));
		}
		return relativeImageChangeArrayList;
	}
	
	public void outputRelativeImageChangeArrayList(){
		ArrayList<ArrayList<ArrayList<Integer>>> relativeChangeArrayList = getRelativeImageChangeArrayList(arrayListOfInstances);
		for(int i=0; i<relativeChangeArrayList.size(); i++){
			System.out.print("\nArray" + Integer.toString(i+2) +"={");
			for(int x=0; x<relativeChangeArrayList.get(i).size(); x++){
				if(x != relativeChangeArrayList.get(i).size()-1){
					System.out.print("{" + relativeChangeArrayList.get(i).get(x).get(0) + "," 
							+ relativeChangeArrayList.get(i).get(x).get(1) + "},");
				}else{
					System.out.print("{" + relativeChangeArrayList.get(i).get(x).get(0) + "," 
							+ relativeChangeArrayList.get(i).get(x).get(1) + "}}");
				}
			}
		}
	}
}

