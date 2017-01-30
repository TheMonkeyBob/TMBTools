package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class FlagPoint extends DataPoint
{
    private boolean data;
    private byte flagNum;
    
    public FlagPoint()
    {
        super();
        this.data = false;
        this.flagNum = 0;
    }
    
    public FlagPoint(boolean data)
    {
        super();
        this.data = data;
        this.flagNum = 0;
    }
    
    public FlagPoint(boolean data, long point)
    {
        super(point);
        this.data = data;
        this.flagNum = 0;
    }
    
    public FlagPoint(boolean data, byte flagNum, long point)
    {
        super(point);
        this.data = data;
        this.flagNum = flagNum;
    }
    
    public boolean getData()
    {
        return this.data;
    }
    
    public void setData(boolean data)
    {
        this.data = data;
    }
    
    public byte getFlagNumber()
    {
        return this.flagNum;
    }
    
    public void setFlagNumber(byte flagNum)
    {
        this.flagNum = flagNum;
    }
}
