package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class StringPoint extends DataPoint
{
    private String data;
    
    public StringPoint()
    {
        super();
        this.data = "";
    }
    
    public StringPoint(String data)
    {
        super();
        this.data = data;
    }
    
    public StringPoint(String data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public String getData()
    {
        return this.data;
    }
    
    public void setData(String data)
    {
        this.data = data;
    }
}
