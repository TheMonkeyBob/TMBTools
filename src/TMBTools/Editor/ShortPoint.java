package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class ShortPoint extends DataPoint
{
    private short data;
    
    public ShortPoint()
    {
        super();
        this.data = 0;
    }
    
    public ShortPoint(short data)
    {
        super();
        this.data = data;
    }
    
    public ShortPoint(short data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public short getData()
    {
        return this.data;
    }
    
    public void setData(short data)
    {
        this.data = data;
    }
}
