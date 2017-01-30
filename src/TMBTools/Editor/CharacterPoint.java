package TMBTools.Editor;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class CharacterPoint extends DataPoint
{
    private char data;
    
    public CharacterPoint()
    {
        super();
        this.data = 0;
    }
    
    public CharacterPoint(char data)
    {
        super();
        this.data = data;
    }
    
    public CharacterPoint(char data, long point)
    {
        super(point);
        this.data = data;
    }
    
    public char getData()
    {
        return this.data;
    }
    
    public void setData(char data)
    {
        this.data = data;
    }
}
