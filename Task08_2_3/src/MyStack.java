
public class MyStack {
    private int size;
    private int top;
    private Object[] arrayObjects;
    private  BlackList blackList;

    public BlackList getBlackList() {
        return blackList;
    }

    public MyStack(int size) {
        this.size = size;
        top = -1;
        arrayObjects = new Object[size];
        blackList = new BlackList();
    }

    public void addElement(Object element) {
        if (isFull()) {
            System.out.println("Stack is full. Can not add!");
            return;
        }
        if(!blackList.checkObject(element)) arrayObjects[++top] = element;
        else System.out.println("Not add, " + element.getClass() + " is in Black List");
    }

    public Object getDeleleElement() {
        return arrayObjects[top--];
    }
    public Object readElement(){
        return arrayObjects[top];
    }
    public boolean isFull(){
        return (top == (size - 1));
    }
    public boolean isEmty(){
        return (top == -1);
    }

    class BlackList {
        private Class[] arrayBL;

        public BlackList() {
            arrayBL = new Class[0];
        }

        public void addBL(Class classElement){
            if (checkIncoming(classElement)) return;
            Class[] tmp = new  Class[arrayBL.length + 1];
            System.arraycopy(arrayBL,0,tmp,0,arrayBL.length);
            tmp[tmp.length - 1] = classElement;
            arrayBL = tmp;
        }
        private boolean checkIncoming(Class classElement){
            for (Class item : arrayBL){
                if (item == classElement) return true;
            }
            return false;
        }
        public boolean checkObject(Object object){
            if (object == null) return false;
            return checkIncoming(object.getClass());
        }

    }
}
