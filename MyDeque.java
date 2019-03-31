import java.util.*;


public class MyDeque <E> {

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


  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(size==data.length){
      resize();
    }
    if(size==0){
      data[start]=element;
      end=start;
      size++;
      return;
    }
    start=(start-1+data.length)%data.length;
    data[start]=element;
    size++;
  }

  public void addLast(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(size == data.length){
      resize();
    }
    if(size==0){
      data[start]=element;
      end=start;
      size++;
      return;
    }
    end=(end+1)%data.length;
    data[end]=element;
    size++;
  }

  public E removeFirst(){
    E e=data[start];
    data[start]=null;
    if(start==data.length){
      start=0;
    }
    else{
      start++;
    }
    size--;
    return e;
  }

  public E removeLast(){
    E e=data[end];
    data[end]=null;
    if(end==0){
      end=data.length-1;
    }
    else{
      end--;
    }
    size--;
    return e;
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
