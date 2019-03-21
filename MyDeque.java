public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){

  }
  public MyDeque(int initialCapacity){
   }
  public int size(){
    return end-start;
  }
  public String toString(){
  }
  public void addFirst(E element){
    if(start>=1){
      data[start-1]=element;
      start--;
    }
    else{

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
}
