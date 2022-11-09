public class LinkedListDeque<T> implements Deque<T> {
    private class ItemNode {
        private T item;
        private ItemNode prev;
        private ItemNode next;

        private ItemNode(T x,ItemNode p,ItemNode n){
            item=x;
            prev=p;
            next=n;
        }
    }
    private ItemNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel=new ItemNode((T) new Object(),null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void addFirst(T item ){
        ItemNode first=new ItemNode(item,null,null);
        first.next=sentinel.next;
        sentinel.next=first;
        first.prev=sentinel;
        first.next.prev=first;
        size=size+1;
    }
    @Override
    public void addLast(T item){
        ItemNode last=new ItemNode(item,null,null);
        last.prev=sentinel.prev;
        last.prev.next=last;
        last.next=sentinel;
        sentinel.prev=last;
        size=size+1;
    }
    @Override
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    @Override
    public T removeFirst(){
        if(sentinel.next==sentinel){
            return null;
        }
        T first=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size=size-1;
        return first;
    }
    @Override
    public T removeLast(){
        if(sentinel.prev==sentinel){
            return null;
        }
        T last=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size=size-1;
        return last;
    }
    @Override
    public T get(int index){
        if(index>size-1){
            return null;
        }
        ItemNode a=sentinel.next;
        for(int i=0;i<index;i++){
            a=a.next;
        }
        return a.item;
    }
    public T getRecursive(int index){

        if(index>size-1){
            return null;
        }
        return getRecursive(sentinel.next,index);
    }
    private T getRecursive(ItemNode a,int i){
        if(i==0){
            return a.item;
        }
        return getRecursive(a.next,i-1);
    }
    @Override
    public void printDeque(){
        ItemNode a=sentinel.next;
        for(int i=0;i<size;i++){
            System.out.print(a.item+" ");
            a=a.next;
        }
        System.out.println();
    }


}
