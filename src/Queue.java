public class Queue {
    protected Object[] a;
    protected int max;
    protected int first, last;
    public Queue(int max)
    {
    
        this.max = max ;
        a = new Object[max];
        first = last = -1;
    }
    public Queue()
    {
        this(10);
       
    }
    public boolean isEmpty()
    {
        return(first==-1);
    
    }
    public boolean isFull()
    {
        return ((first == 0 && last == max -1) || first == last + 1 );
    
    }
    public void enqueue(Object x)
    {
        if (isFull() && !grow())
        {
            System.out.println("The queue is full");
            return;
        
        }
        if (last==max-1 || last==-1)
        {
            a[0]=x;
            last=0;
            if(first == -1){
               first=0;
            }
        
        }else {
         a [++last]= x;
        }
        
      
    }
    private boolean grow(){
     return false;
    }
    public Object font()throws Exception{
     if (isEmpty())throw new Exception("the queue is empty");
     return a [first];

    }
    public Object dequeue()throws Exception{
     if (isEmpty())throw new Exception("the queue is empty");
     Object x = a [first];
     if (first==last){
     first = last = -1;
     }else if (first==max-1){
        first=0;
     }else{
       first++;
     }
     return x;
    }   
}