import java.util.Vector;

/**
 * Created by Asus on 2016/8/24.
 */
public class MySource {
    private int value;
    private Vector<Listener> listeners = new Vector<Listener>();

    public void addListener(Listener listener){
        listeners.add(listener);
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        MyEvent e = new MyEvent();
        e.setValue(value);
        for(Listener listener : listeners)
            listener.valueChange(e);
    }
    public static void main(String[] args){
        MySource s = new MySource();
        s.addListener(new Listener() {
            public void valueChange(MyEvent e) {
                System.out.println("最新值：" + e.getValue());
            }
        });
        s.setValue(1);
        s.setValue(2);
    }
}
