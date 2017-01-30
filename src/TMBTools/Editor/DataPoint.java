package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class DataPoint
{
    private long point;
    
    protected DataPoint()
    {
        this.point = 0;
    }
    
    protected DataPoint(long point)
    {
        this.point = point;
    }
    
    public void setPoint(long point)
    {
        this.point = point;
    }
    
    public long getPoint()
    {
        return this.point;
    }
}
