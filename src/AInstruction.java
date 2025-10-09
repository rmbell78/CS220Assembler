import java.sql.SQLOutput;

public class AInstruction extends Instruction{

    public AInstruction(String code){
        assemblyCode = code;
        machineCode = decimalToBinary(Integer.parseInt(code.substring(1)));
    }

    public String decimalToBinary(int address){
        StringBuilder output = new StringBuilder();
        while(address > 0){
            output.insert(0,address % 2);
            address /= 2;
        }
        while(output.length() < 16){
            output.insert(0,"0");
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return "A-Instruction: Assembly= " + assemblyCode + ", Machine= " + machineCode;
    }
}
