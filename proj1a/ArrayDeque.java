public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;
    public ArrayDeque(){
        items=(T[]) new Object[8];
        size=0;
        nextfirst=7;
        nextlast=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void printDeque(){
        int f=(nextfirst+1)%items.length;
        int l=(nextlast+items.length-1)%items.length;
        if(f>l){
            for(int i=f;i<items.length;i++){
                System.out.print(items[i]+" ");
            }
            for(int i=0;i<=l;i++){
                System.out.print(items[i]+" ");
            }
        }
        else{
            for(int i=f;i<=l;i++){
                System.out.print(items[i]+" ");
            }
        }
    }
    public T get(int index){
        if((index>=size())||(isEmpty())||(index<0)){
            return null;
        }
        int f=(nextfirst+1)%items.length;
        return items[(index+f)%items.length];
    }
    private void resize(int arraysize){
        T[] a=(T[]) new Object[arraysize];
        int f=(nextfirst+1)%items.length;
        int l=(nextlast+items.length-1)%items.length;
        if(f>l){
            System.arraycopy(items,f,a,0,items.length-f);
            System.arraycopy(items,0,a,items.length-f,l+1);
        }
        else{
            System.arraycopy(items,f,a,0,size);
        }
        items=a;
        nextfirst=items.length-1;
        nextlast=size;
    }
    public void addLast(T item){
        if(size== items.length){
            resize(2*items.length);
        }
        items[nextlast]=item;
        size=size+1;
        nextlast=(nextlast+1)%items.length;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T x=items[(nextlast+items.length-1)%items.length];
        nextlast=(nextlast+items.length-1)%items.length;
        size=size-1;
        if((items.length>8)&&(size<items.length/4)){
            resize(items.length/2);
        }
        return x;
    }
    public void addFirst(T item){
        if(size== items.length){
            resize(2*items.length);
        }
        items[nextfirst]=item;
        size=size+1;
        nextfirst=(nextfirst+items.length-1)%items.length;
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T x=items[(nextfirst+1)%items.length];
        nextfirst=(nextfirst+1)%items.length;
        size=size-1;
        if((items.length>8)&&(size<items.length/4)){
            resize(items.length/2);
        }
        return x;
    }
}
