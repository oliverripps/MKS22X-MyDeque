import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    E[] es=new E[10];
    data=es;
    start=0;
    end=0;
    size=0;

  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    E[] es=new E[initialCapactity];
    data=es;
    start=0;
    end=0;
    size=initialCapacity;
   }
  public int size(){
    return end-start;
  }
  public String toString(){
    String str="{}"
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
    if(start>=1){
      data[start-1]=element;
      start--;
    }
    else if(isend()){
      resize();
    }
    start=size-1;
    data[start]=element;
   }
  public void addLast(E element){
    data[end+1]=element;
    end++;
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

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] es=new E[size*2];
    for(int i=0;i<size;i++){
      es[i]=data[i];
    }
    size=size*2;
    data=es;
  }
  private boolean isend(){
    if(end==size-1){
      return true;
    }
    return false;
  }
}
