import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class MachineCodeWriter {

    public static void writeToBinaryFile(String fileName, List<Instruction> parsedAssemblyInstructions) throws FileNotFoundException {
        PrintWriter fileWriter = new PrintWriter(fileName);

        for (int i = 0; i < parsedAssemblyInstructions.size() - 1; i++) {
            fileWriter.println(parsedAssemblyInstructions.get(i).getMachineCode());
        }

        if(parsedAssemblyInstructions.size() > 0){
            fileWriter.print(parsedAssemblyInstructions.getLast().getMachineCode());
        }
        fileWriter.close();
    }
}
