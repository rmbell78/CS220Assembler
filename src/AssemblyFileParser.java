import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssemblyFileParser {
    private List<Instruction> parsedAssemblyInstructions;
    private List<String> cleanAssemblyCode;
    private Scanner fileReader;

    public AssemblyFileParser(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        fileReader = new Scanner(file);
        cleanAssemblyCode = new ArrayList<>();
        parsedAssemblyInstructions = new ArrayList<>();
        makeFirstPass();
        makeSecondPass();
    }

    private String clean(String rawLine){
        if(rawLine.contains("//")){
            rawLine = rawLine.substring(0,rawLine.indexOf("//"));
        }
        return rawLine.trim();
    }

    private void makeFirstPass(){
        String line;
        int instructions = 0;
        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            line = clean(line);
            if(!line.isBlank()) {
                //Check if the line is a label.
                if(line.startsWith("(") && line.endsWith(")")){
                    SymbolTable.add(line.substring(1,line.length() - 1),instructions);
                } else{
                    cleanAssemblyCode.add(line);
                    instructions++;
                    //Testing
//                    if(line.equals("@sys.init")){
//                        System.out.println(SymbolTable.getAddress("sys.init"));
//                    }
                }
            }
        }
        fileReader.close();
    }

    private void makeSecondPass(){
        //The first variable address begins @16
        int nextAddress = 16;
        String symbol;
        int address;
        for(String code : cleanAssemblyCode){
            if(code.startsWith("@")){
                symbol = code.substring(1);
                try{
                    address = Integer.parseInt(symbol);
                } catch (NumberFormatException e){
                    //Symbol was not an int, was a variable name.
                    if(SymbolTable.contains(symbol)){
                        address = SymbolTable.getAddress(symbol);
                    } else{
                        SymbolTable.add(symbol, nextAddress);
                        address = nextAddress;
                        nextAddress++;
                    }
                }
                parsedAssemblyInstructions.add(new AInstruction("@" + address));
            }else{
                parsedAssemblyInstructions.add(new CInstruction(code));
            }
        }
    }


    public List<Instruction> getParsedAssemblyInstructions() {
        return parsedAssemblyInstructions;
    }
}
