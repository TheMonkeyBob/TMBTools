package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class LongPoint extends DataPoint
{
    private long data;
    
    public LongPoint()
    {
        super();
        this.data = 0;
    }
    
    public LongPoint(long data)
    {
        super();
        this.data = data;
    }
    
    public LongPoint(long data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public long getData()
    {
        return this.data;
    }
    
    public void setData(long data)
    {
        this.data = data;
    }
}
