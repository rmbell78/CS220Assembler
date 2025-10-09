import java.util.HashMap;

public class CInstruction extends Instruction{

    private String dest;
    private String comp;
    private String jump;

    private static final HashMap<String,String> destCodes;
    private static final HashMap<String,String> compCodes;
    private static final HashMap<String,String> jumpCodes;

    static {
        destCodes = new HashMap<>(8);
        compCodes = new HashMap<>(28);
        jumpCodes = new HashMap<>(8);

        destCodes.put(null, "000");
        destCodes.put("M",  "001");
        destCodes.put("D",  "010");
        destCodes.put("MD", "011");
        destCodes.put("A",  "100");
        destCodes.put("AM", "101");
        destCodes.put("AD", "110");
        destCodes.put("AMD","111");

        //Don't forget about the 'a' bit!
        compCodes.put("0",  "0101010");
        compCodes.put("1",  "0111111");
        compCodes.put("-1", "0111010");
        compCodes.put("D",  "0001100");
        compCodes.put("A",  "0110000");
        compCodes.put("!D", "0001101");
        compCodes.put("!A", "0110001");
        compCodes.put("-D", "0001111");
        compCodes.put("-A", "0110011");
        compCodes.put("D+1","0011111");
        compCodes.put("A+1","0110111");
        compCodes.put("D-1","0001110");
        compCodes.put("A-1","0110010");
        compCodes.put("D+A","0000010");
        compCodes.put("D-A","0010011");
        compCodes.put("A-D","0000111");
        compCodes.put("D&A","0000000");
        compCodes.put("D|A","0010101");
        compCodes.put("M",  "1110000");
        compCodes.put("!M", "1110001");
        compCodes.put("-M", "1110011");
        compCodes.put("M+1","1110111");
        compCodes.put("M-1","1110010");
        compCodes.put("D+M","1000010");
        compCodes.put("D-M","1010011");
        compCodes.put("M-D","1000111");
        compCodes.put("D&M","1000000");
        compCodes.put("D|M","1010101");

        jumpCodes.put(null,"000");
        jumpCodes.put("JGT","001");
        jumpCodes.put("JEQ","010");
        jumpCodes.put("JGE","011");
        jumpCodes.put("JLT","100");
        jumpCodes.put("JNE","101");
        jumpCodes.put("JLE","110");
        jumpCodes.put("JMP","111");




    }

    public CInstruction(String code){
        this.assemblyCode = code;
        parseCodeIntoParts();
        machineCode = "111" + compCodes.get(comp) + destCodes.get(dest) + jumpCodes.get(jump);
    }

    private void parseCodeIntoParts(){
        String code = assemblyCode;

        int equalIndex = code.indexOf("=");
        int jumpIndex = code.indexOf(";");

        if (jumpIndex != -1) {
            jump = code.substring(jumpIndex+1);
            code = code.substring(0, jumpIndex);
        }

        if (equalIndex != -1) {
            comp = code.substring(equalIndex+1);
            dest = code.substring(0, equalIndex);
        }
        else
            comp = code;
    }

    @Override
    public String toString(){
        return "C-Instruction [" +
                "Dest=" + dest +
                ", Comp=" + comp +
                ", Jump=" + jump +
                ", Machine" + machineCode + "]";
    }

}
