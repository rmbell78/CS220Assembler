import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssemblyFileParser {
    private List<String> cleanAssemblyCode;
    private Scanner fileReader;

    public AssemblyFileParser(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        fileReader = new Scanner(file);
        cleanAssemblyCode = new ArrayList<>();
        makeFirstPass();
    }

    private String clean(String rawLine){
        if(rawLine.contains("//")){
            rawLine = rawLine.substring(0,rawLine.indexOf("//"));
        }
        return rawLine.trim();
    }

    private void makeFirstPass(){
        String line;
        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            line = clean(line);
            if(!line.isBlank()) {
                cleanAssemblyCode.add(line);
            }
        }
        //For testing
        System.out.println(cleanAssemblyCode);
    }






}
