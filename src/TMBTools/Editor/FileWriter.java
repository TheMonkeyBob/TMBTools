package TMBTools.Editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class FileWriter extends RandomAccessFile
{
    private DataPoint[] list = null;
    private HashMap<Long, Byte> flagMap = null;
    private boolean dynamic = false;
    
    public FileWriter(File file) throws FileNotFoundException
    {
        super(file, "rw");
    }
    
    public FileWriter(DataPoint[] datalist, File file) throws FileNotFoundException
    {
        super(file, "rw");
        this.list = datalist;
    }
    
    public FileWriter(DataPoint[] datalist, File file, boolean dynamic) throws FileNotFoundException
    {
        super(file, "rw");
        this.list = datalist;
        this.dynamic = dynamic;
    }
    
    public FileWriter(String file) throws FileNotFoundException
    {
        this(new File(file));
    }
    
    public FileWriter(DataPoint[] datalist, String file) throws FileNotFoundException
    {
        this(datalist, new File(file));
    }
    
    public FileWriter(DataPoint[] datalist, String file, boolean dynamic) throws FileNotFoundException
    {
        this(datalist, new File(file), dynamic);
    }
    
    public boolean writeData(DataPoint[] datalist)
    {
        this.list = datalist;
        return writeData();
    }
    
    public boolean writeData()
    {
        try
        {
            for (DataPoint dP: this.list)
            {
                if (dP instanceof BytePoint){writeByte(dP);}
                else if (dP instanceof CharacterPoint){writeCharacter(dP);}
                else if (dP instanceof DoublePoint){writeDouble(dP);}
                else if (dP instanceof FlagPoint){addFlag(dP);}
                else if (dP instanceof FloatPoint){writeFloat(dP);}
                else if (dP instanceof IntegerPoint){writeInteger(dP);}
                else if (dP instanceof LongPoint){writeLong(dP);}
                else if (dP instanceof ShortPoint){writeShort(dP);}
                else if (dP instanceof StringPoint){writeString(dP);}
                else {return false;}
            }
            writeFlags();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    private void writeByte(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeByte(((BytePoint)dP).getData());
    }
    
    private void writeCharacter(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeChar(((CharacterPoint)dP).getData());
    }
    
    private void writeDouble(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeDouble(((DoublePoint)dP).getData());
    }
    
    private void writeFloat(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeFloat(((FloatPoint)dP).getData());
    }
    
    private void writeInteger(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeInt(((IntegerPoint)dP).getData());
    }
    
    private void writeLong(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeLong(((LongPoint)dP).getData());
    }
    
    private void writeShort(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeShort(((ShortPoint)dP).getData());
    }
    
    private void writeString(DataPoint dP) throws IOException
    {
        seek(dP.getPoint());
        super.writeUTF(((StringPoint)dP).getData());
    }
    
    private void addFlag(DataPoint dP) throws IOException
    {
        if (flagMap.containsKey(dP.getPoint()))
        {
            setFlag(flagMap.get(dP.getPoint()), (FlagPoint)dP);
        }
        else if (dynamic)
        {
            setFlag((byte)0, (FlagPoint)dP);
        }
        else //static
        {
            seek(dP.getPoint());
            setFlag(readByte(), (FlagPoint)dP);
        }
    }
    
    private void setFlag(byte value, FlagPoint dP)
    {
        int intValue = value;
        if (intValue < 0)
        {
            intValue = intValue*(-1)+127;
        }
        if ((intValue%Math.pow(2, dP.getFlagNumber()+1))/(Math.pow(2, dP.getFlagNumber()))==1)
        {
            if (!dP.getData())
            {
                flagMap.put(dP.getPoint(), (byte)(intValue - Math.pow(2, dP.getFlagNumber())));
            }
        }
        else
        {
            if (dP.getData())
            {
                flagMap.put(dP.getPoint(), (byte)(intValue + Math.pow(2, dP.getFlagNumber())));
            }
        }
    }
    
    private void writeFlags() throws IOException
    {
        for (Long key: flagMap.keySet())
        {
            seek(key);
            writeByte(flagMap.get(key));
        }
    }
}
