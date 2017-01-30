package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class IntegerPoint extends DataPoint
{
    private int data;
    
    public IntegerPoint()
    {
        super();
        this.data = 0;
    }
    
    public IntegerPoint(int data)
    {
        super();
        this.data = data;
    }
    
    public IntegerPoint(int data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public int getData()
    {
        return this.data;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
}
