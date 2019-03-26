import java.util.*;


public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data=(E[])new Object[10];
    start=0;
    end=0;
    size=0;

  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data=(E[])new Object[initialCapacity];
    start=0;
    end=0;
    size=0;
   }
  public int size(){
    return size;
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] curr = (E[])new Object[2 * data.length + 1];
    if(start<end){
      for(int i = 0; i + start < end; i++){
        curr[i] = data[i + start];
      }
    }
    if(start > end){
      int i = 0;
      for(int l = start; l < data.length; l++){
        curr[i] = data[l];
        i++;
      }
      for(int l = 0; l < end; l++){
        curr[i] = data[l];
        i++;
      }
    }
    data = curr;
    start = 0;
    end = size;
  }

  public String toString(){
    if(size==0){
      return "{}";
    }
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
  //FIX
  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(isend()){
      resize();
    }

    if(start==0){
      if(end==0){
        data[0]=element;
        end++;
      }
      else{
        data[data.length-1]=element;
        start=data.length-1;
      }
    }
    else{
      data[start]=element;
      start--;
    }
    start--;
   }


//FIX
  public void addLast(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(isend()){
      resize();
    }
    if(end==data.length-1){
      data[data.length - 1] = element;
      end=0;
    }
    else{
      data[end] = element;
      end++;
    }
    size++;
   }


//FIX
  public E removeFirst(){
  if (size!=0){
   E removed = data[start];
   //System.out.println(removed);
   data[start] = null;
   if (start==data.length-1){
     start=0;
   }
   else{
     start++;
   }
   size--;
   return removed;
 }
 else{
   throw new NoSuchElementException();
 }

   }

//FIX
  public E removeLast(){
    E removed;
    if(size==0){
      throw new NoSuchElementException();
    }
    if(end==0){
      end=data.length;
      removed = data[end];
    }
    else{
      removed = data[end-1];
      data[end-1]=null;
      end--;
    }
    size--;
    return removed;

   }


  public E getFirst(){
    if(size!=0){
    return data[start];
  }
  else{
    throw new NoSuchElementException();
  }
  }
  public E getLast(){
    if(size!=0){
      if(end!=0){
        return data[end];
      }
      else{
        return data[data.length-1];
      }
    }
    else{
      throw new NoSuchElementException();
    }
  }

  private boolean isend(){
    if(start == data.length - 1){
      return true;
    }
    return false;
  }

  public static void main(String[] args){
    MyDeque<Integer> my = new MyDeque<Integer>();
    System.out.println(my.toString());
    my.addFirst(5);
    System.out.println(my.toString());


  }
}
