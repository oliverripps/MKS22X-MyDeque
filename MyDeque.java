public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    E[] es=new E[10];
    data=es;
    start=0;
    end=0;
    size=0;

  }
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
    String str="["
    for(int i=start;i<=end;i++){
      if(i>=size){
        i=i-size;
      }
      str+=data[i]+ ",";
    }
    str+="]";
  }
  public void addFirst(E element){
    if(start>=1){
      data[start-1]=element;
      start--;
    }
    if(isend())
    else{
      data[size-1]=element;
    }
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
  }
  public E getLast(){
  }
  private void resize(){
    //double
  }
  private boolean isend(){
    if(end==size-1){
      return true;
    }
    return false;
  }
}
