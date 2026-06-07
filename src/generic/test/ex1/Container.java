package generic.test.ex1;

public class Container <T>{
    private T item;

    public Container() {
    }

    public Container(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public boolean isEmpty(){
        return item == null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
