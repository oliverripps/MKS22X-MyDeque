import java.util.*;

public class MyDeque<E>{
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
    String str="{"
    for(int i=start;i<=end;i++){
      if(i>=size){
        i=i-size;
      }
      str+=data[i];
      if(i<end){
        str+=" ";
      }
    }
    str+="}";
  }

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


  public E removeFirst(){

   }
  public E removeLast(){
   }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }

  private boolean isend(){
    if(start == data.length - 1){
      return true;
    }
    return false;
  }
}
