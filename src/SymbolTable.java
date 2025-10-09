import java.util.HashMap;

public class SymbolTable {

    //Variable names in assembly have rules.
    public static final String INITIAL_VALID_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ$_:.";
    public static final String ALL_VALID_CHARS = INITIAL_VALID_CHARS + "0123456789";

    private static HashMap<String,Integer> symbolTable;

    //Static variables are initizalized in a static block
    static {
        symbolTable = new HashMap<>();

        symbolTable.put("R0",0);
        symbolTable.put("R1",1);
        symbolTable.put("R2",2);
        symbolTable.put("R3",3);
        symbolTable.put("R4",4);
        symbolTable.put("R5",5);
        symbolTable.put("R6",6);
        symbolTable.put("R7",7);
        symbolTable.put("R8",8);
        symbolTable.put("R9",9);
        symbolTable.put("R10",10);
        symbolTable.put("R11",11);
        symbolTable.put("R12",12);
        symbolTable.put("R13",13);
        symbolTable.put("R14",14);
        symbolTable.put("R15",15);
        symbolTable.put("SCREEN",16384);
        symbolTable.put("KBD",24576);
        symbolTable.put("SP",0);
        symbolTable.put("LCL",1);
        symbolTable.put("ARG",2);
        symbolTable.put("THIS",3);
        symbolTable.put("THAT",4);

    }

    private static boolean isValidName(String symbol){
        String validChars = INITIAL_VALID_CHARS;
        for (int i = 0; i < symbol.length(); i++) {
            if(!validChars.contains(symbol.substring(i,i+1))){
                return false;
            }
            validChars = ALL_VALID_CHARS;
        }
        return true;
    }

    public static boolean add(String symbol, int address){
        if(isValidName(symbol) && !contains(symbol)){
            symbolTable.put(symbol, address);
            return true;
        }
        return false;
    }

    public static boolean contains(String key){
        return symbolTable.containsKey(key);
    }

    public static int getAddress(String symbol){
        return symbolTable.get(symbol);
    }


}
