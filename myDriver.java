public class myDriver{
  public static void main(String[] args){
    int[] data= new int[]{8,6,7,3,67,72,5,3};
    System.out.println(toString(data,6,3,data.length));



  }
  public static String toString(int[] data,int start){
    String str = "{";
    for (int i=start; i<data.length && data[i]!=null;++i){
      if(i!=start){
        str+=" ";
      }
      str+=data[i];
    }
    for (int i=0; i<start && data[i]!=null; ++i){
      if(i!=start){
        str+=" ";
      }
      str+=data[i]+" ";
    }

    str += "}";

    return str;
  }


}
