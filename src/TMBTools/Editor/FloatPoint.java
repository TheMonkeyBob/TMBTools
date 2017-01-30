package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class FloatPoint extends DataPoint
{
    private float data;
    
    public FloatPoint()
    {
        super();
        this.data = 0;
    }
    
    public FloatPoint(float data)
    {
        super();
        this.data = data;
    }
    
    public FloatPoint(float data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public float getData()
    {
        return this.data;
    }
    
    public void setData(float data)
    {
        this.data = data;
    }
}
