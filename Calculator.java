public class Calculator{

  public static double eval(String s){
    String[] nums= s.split(" ");
    MyDeque<Double> my = new MyDeque<Double>();
    for(int i=0;i<nums.length;i++){
      if(nums[i].equals("+")){
        Double first = my.removeLast();
        Double second = my.removeLast();
        my.addLast(second+first);
      }
    }
  }
}
