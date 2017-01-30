package TMBTools.Editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by TheMonkeyBob on 2016-12-26.
 */
public class FileReader extends RandomAccessFile
{
    private HashMap<Long, Byte> flagMap = new HashMap<>();
    
    public FileReader(File file) throws FileNotFoundException
    {
        super(file, "r");
    }
    
    public FileReader(String file) throws FileNotFoundException
    {
        super(file, "r");
    }
    
    public DataPoint readData(DataType type, long point, int[] params)
    {
        try
        {
            DataPoint dP = null;
            switch(type)
            {
                case BYTE:
                    seek(point);
                    dP = new BytePoint(readByte(), point);
                    break;
                case CHARACTER:
                    seek(point);
                    dP = new CharacterPoint(readChar(), point);
                    break;
                case DOUBLE:
                    seek(point);
                    dP = new DoublePoint(readDouble(), point);
                    break;
                case FLOAT:
                    seek(point);
                    dP = new FloatPoint(readFloat(), point);
                    break;
                case INTEGER:
                    seek(point);
                    dP = new IntegerPoint(readInt(), point);
                    break;
                case LONG:
                    seek(point);
                    dP = new LongPoint(readLong(), point);
                    break;
                case SHORT:
                    seek(point);
                    dP = new ShortPoint(readShort(), point);
                    break;
                case STRING:
                    seek(point);
                    dP = readString(params);
                    dP.setPoint(point);
                    break;
                case FLAG:
                    readFlag(point, params);
                    break;
            }
            return dP;
        }
        catch (IOException e)
        {
            return null;
        }
    }
    
    /**
     * [0]: string ending type
     * 0 = string by ending character
     * 1 = string by length
     * 2 = string by length and ending character
     * [1]: length of string
     * [2+]: ending characters
     */
    private DataPoint readString(int[] params) throws IOException
    {
        DataPoint dP = null;
        HashSet<Character> breakList;
        ArrayList<Character> charList = null;
        char tempChar;
        
        if (params[0] == 0)
        {
            if (params.length < 3)
            {
                return null;
            }
            breakList = new HashSet<>();
            charList = new ArrayList<>();
            for (int i = 2; i < params.length; i++)
            {
                breakList.add(new Character((char)params[i]));
            }
            while(true)
            {
                tempChar = readChar();
                if (breakList.contains(tempChar))
                {
                    break;
                }
                charList.add(tempChar);
            }
        }
        else if (params[0] == 1)
        {
            charList = new ArrayList<>();
            for (int i = 0; i < params[1]; i++)
            {
                charList.add(readChar());
            }
        }
        else if (params[0] == 2)
        {
            if (params.length < 3)
            {
                return null;
            }
            breakList = new HashSet<>();
            charList = new ArrayList<>();
            for (int i = 2; i < params.length; i++)
            {
                breakList.add(new Character((char)params[i]));
            }
            for (int i = 0; i < params[1]; i++)
            {
                tempChar = readChar();
                if (breakList.contains(tempChar))
                {
                    break;
                }
                charList.add(tempChar);
            }
        }
        
        if (charList != null)
        {
            String string = "";
            for (int i = 0; i < charList.size(); i++)
            {
                string += charList.get(i);
            }
    
            dP = new StringPoint(string);
        }
        
        return dP;
    }
    
    private DataPoint readFlag(long point, int[] params) throws IOException
    {
        DataPoint dP;
        byte flagset;
        if (!flagMap.containsKey(point))
        {
            seek(point);
            flagMap.put(point, readByte());
        }
        flagset = flagMap.get(point);
        int intFlagset = flagset;
        if (intFlagset < 0)
        {
            intFlagset = intFlagset*(-1)+127;
        }
        if ((intFlagset%Math.pow(2, params[0]))/Math.pow(2, params[0]) == 1)
        {
            dP = new FlagPoint(true, point);
        }
        else
        {
            dP = new FlagPoint(false, point);
        }
        
        return dP;
    }
    
    public void close() throws IOException
    {
        flagMap = null;
        super.close();
    }
}
