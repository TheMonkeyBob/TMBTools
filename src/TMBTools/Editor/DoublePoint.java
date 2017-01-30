package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class DoublePoint extends DataPoint
{
    private double data;
    
    public DoublePoint()
    {
        super();
        this.data = 0;
    }
    
    public DoublePoint(double data)
    {
        super();
        this.data = data;
    }
    
    public DoublePoint(double data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public double getData()
    {
        return this.data;
    }
    
    public void setData(double data)
    {
        this.data = data;
    }
}
