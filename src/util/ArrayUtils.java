package util;

public class ArrayUtils {
	
	    public static void printArray(int[] array, String info) {
		    System.out.print(info+" {");
		    for (int i = 0; i < array.length; i++) {
			    System.out.print(array[i]);
			    if (i < array.length - 1) {
				    System.out.print(", ");
			    }
		    }
		    System.out.println("}");
	    }
	    
	    public static void printArray(int[] array) {
		   printArray(array, "");
	    }

}
