import java.util.*;

public class Calculator{

  public static double eval(String s){
    String[] nums= s.split(" ");
    MyDeque<Double> my = new MyDeque<Double>();
    for(int i=0;i<nums.length;i++){
      if(nums[i].equals("+")){
        Double first=my.removeLast();
        Double second=my.removeLast();
        //System.out.print(i);
        my.addLast(second+first);
      }
      else if(nums[i].equals("-")){
        Double first=my.removeLast();
        Double second=my.removeLast();
        my.addLast(second-first);
      }
      else if(nums[i].equals("*")){
        Double first=my.removeLast();
        Double second=my.removeLast();
        my.addLast(second*first);
      }
      else if(nums[i].equals("/")){
        Double first=my.removeLast();
        Double second=my.removeLast();
        my.addLast(second/first);
      }
      else if(nums[i].equals("%")){
        Double first=my.removeLast();
        Double second=my.removeLast();
        my.addLast(second%first);
      }
    else{
      Double val = Double.parseDouble(nums[i]);
      my.addLast(val);
    }
  }
  return my.getLast();

  }

}
