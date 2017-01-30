package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class BytePoint extends DataPoint
{
    private byte data;
    
    public BytePoint()
    {
        super();
        this.data = 0;
    }
    
    public BytePoint(byte data)
    {
        super();
        this.data = data;
    }
    
    public BytePoint(byte data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public byte getData()
    {
        return this.data;
    }
    
    public void setData(byte data)
    {
        this.data = data;
    }
}
