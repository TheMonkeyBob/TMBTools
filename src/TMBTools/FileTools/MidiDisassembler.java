package TMBTools.FileTools;

import java.io.*;

/**
 * Created by TheMonkeyBob on 2017-01-29.
 */
public class MidiDisassembler
{
    RandomAccessFile input;
    FileWriter output;
    File input_file;
    File output_file;

    public MidiDisassembler(String inputFile)
    {
        input_file = new File(inputFile);
        output_file = null;
    }

    public MidiDisassembler(String inputFile, String outputFile)
    {
        input_file = new File(inputFile);
        output_file = new File(outputFile);
    }

    public MidiDisassembler(File inputFile)
    {
        input_file = inputFile;
        output_file = null;
    }

    public MidiDisassembler(File inputFile, File outputFile)
    {
        input_file = inputFile;
        output_file = outputFile;
    }

    public MidiDisassembler(String inputFile, File outputFile)
    {
        input_file = new File(inputFile);
        output_file = outputFile;
    }

    public MidiDisassembler(File inputFile, String outputFile)
    {
        input_file = inputFile;
        output_file = new File(outputFile);
    }

    public boolean dissasemble()
    {
        return false;
    }

    public boolean dissasemble(String fileName)
    {
        return false;
    }

    public boolean dissasemble(File file)
    {
        return false;
    }

    private boolean dissasembleMidi(File inputFile, File outputFile) throws IOException
    {
        input = new RandomAccessFile(inputFile, "r");
        output = new FileWriter(outputFile);

        while (input.getFilePointer() < input.length())
        {
            stateMachine(input.read());
        }

        return false;
    }

    //the state machine
    private void stateMachine(int input)
    {

    }

    private void variableLengthValue()
    {

    }

    private void textBlock()
    {

    }

    private void dataBlock()
    {

    }
}
