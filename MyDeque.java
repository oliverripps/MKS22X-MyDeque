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
        E[] e = (E[])new Object[data.length*2];
        for(int i=start;i<=end;i++){
            if(i<0){
              e[e.length+i]=data[data.length+i];
            }
            else{
                e[i]=data[i];
            }
        }
        data = e;
    }

  public String toString(){
    String str = "{";
    if(size == 0){
      return "{}";
    }
    if(start==end){
      str+=data[0];
    }
    else if(start < end){
      for(int i=start;i<=end;i++){
        str+=(data[i]+" ");
      }
    }
    else{
      for(int i=start;i<data.length;i++){
        str+=(data[i]+" ");
      }
      for(int l = 0;l<=end;l++){
        str+=(data[l] + " ");
      }
    }
    str+= "}";
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
       if(end==data.length-1 || size==data.length){
         resize();
       }
       end++;
       if(end<0){
         data[data.length+end]=element;
       }
       else{
         data[end] = element;
       }
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
   if (size == 0) {
     throw new NoSuchElementException();
   }
   return data[end];
 }
}
