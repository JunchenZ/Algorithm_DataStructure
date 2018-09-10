package assignment03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramUtil {

  public static String sort(String unsorted) {
    char[] arr = unsorted.toCharArray();
    Character[] arr1 = new Character[arr.length];
    
    for(int i = 0; i<arr.length; i++) {
      arr1[i] = Character.toLowerCase(arr[i]);
    }
    
    insertionSort(arr1, new Comparator<Character> () {
      @Override
      public int compare(Character o1, Character o2) {
         return o1.compareTo(o2);         }
    });
    
    String str = "";
    for(int i = 0; i < arr1.length; i++) {
      str += arr1[i];
    }
    return str;   
  }

  public static <T> void insertionSort(T[] arr, Comparator<? super T> comparator) {
    for(int i = 1; i<arr.length; i++) {
      T temp = arr[i];
      for(int j = i-1; j>=0; j--) {
        if(comparator.compare(temp, arr[j])<0) {
          arr[j+1] = arr[j];
          if(j==0) {
            arr[0] = temp;
          }
        }else {
          arr[j+1] = temp;
          break;
        }
      }
    }
  }
  
  public static boolean areAnagrams(String str1, String str2) {
    return sort(str1).equals(sort(str2));
  }
  
  public static String[] getLargestAnagramGroup(String[] arr) {
    String[] arr1 = new String[arr.length];
    HashMap<String, Integer> hashMap1= new HashMap<String, Integer>();
    
    for(int i = 0; i<arr.length; i++) {
      arr1[i] = sort(arr[i]);
      hashMap1.put(arr1[i], 1);
    }
    
    insertionSort(arr1, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });
    
    for(int i = 0; i<arr1.length-1; i++) {
      for(int j = i + 1; j<arr1.length; j++) {
        if(areAnagrams(arr1[i], arr1[j])) {
          hashMap1.replace(arr1[i], hashMap1.get(arr1[i])+1);
        }
      }
      i += hashMap1.get(arr1[i])-1;
    }
    
    int size = 1;
    String index = "";
    for(int i = 0; i < arr1.length; i++) {
      if(size < hashMap1.get(arr1[i])) {
        size = hashMap1.get(arr1[i]);
        index = arr1[i];
      }  
    }
    String[] arr2 = new String[size];
    
    for(int i = 0, j = 0; j<size && i < arr.length; i++) {
      if(areAnagrams(index, arr[i])){
        arr2[j++] = arr[i];
      }
    }
    return arr2;
  }
  
  public static String[] getLargestAnagramGroup(String filename) throws FileNotFoundException {
    Scanner s = new Scanner(new FileInputStream(filename));
    if(!s.hasNextLine()) {
      s.close();
      return new String[0];
    }
    ArrayList<String> arrList = new ArrayList<String>();
    while(s.hasNextLine()) {
      arrList.add(s.nextLine());
    }
    s.close();
    String[] arr = new String[arrList.size()];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = arrList.get(i);
    }
    return getLargestAnagramGroup(arr);  
  }
}
