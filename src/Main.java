import java.util.ArrayList;


public class Main {
	public static void main(String[] args){
		
		ArrayList<Image> imgArray = new ArrayList<Image>();
		/*
		for(int i=0; i<16; i++){
			imgArray.add(new Image("C:/that" + Integer.toString(i+1) + ".png"));
		}
		*/

		for(int i=0; i<29; i++){
			imgArray.add(new Image("C:/javafiles/meduka" + Integer.toString(i+1) + ".png"));
		}

		//System.out.println(imgArray);
		
		//imgArray[1].outPutPairArray();
		

/*		imgArray.get(0).pixelRGBArray();
		for(int i=0; i<imgArray.size(); i++){
			imgArray.get(i).pixelRGBArray();
			imgArray.get(i).getCompressedImage();
		}*/
		
		imgArray.get(0).pixelRGBArray();
		imgArray.get(0).outputRelativeImageChangeArrayList();
		
		//imgArray[1].getCompressedImage();
		
		/*
		for(int i=0; i<imgArray.length; i++){
			imgArray[i].outputCompressedImage();
		}
		*/
		
		
		/*img1.pixelRGBArray();
		img2.pixelRGBArray();
		img3.pixelRGBArray();
		img4.pixelRGBArray();
		img5.pixelRGBArray();
		img6.pixelRGBArray();
		img7.pixelRGBArray();
		img8.pixelRGBArray();
		img9.pixelRGBArray();
		img10.pixelRGBArray();
		img11.pixelRGBArray();
		img12.pixelRGBArray();
		img13.pixelRGBArray();
		img14.pixelRGBArray();
		img15.pixelRGBArray();
		img16.pixelRGBArray();
		img17.pixelRGBArray();
		img18.pixelRGBArray();
		img19.pixelRGBArray();
		img21.pixelRGBArray();
		img22.pixelRGBArray();
		img23.pixelRGBArray();
		img24.pixelRGBArray();
		img25.pixelRGBArray();
		img26.pixelRGBArray();
		img27.pixelRGBArray();
		img28.pixelRGBArray();
		img29.pixelRGBArray();*/
		

		//img.paintUtilTable();	
		//img.getCompressedImage();
		//System.out.println(" ");
		//img.getSplitImage(7);
	}
}
