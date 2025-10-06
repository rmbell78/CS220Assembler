public class AInstruction extends Instruction{

    public AInstruction(String code){
        assemblyCode = code;
    }

    public String decimalToBinary(int address){

        return null;
    }

    @Override
    public String toString() {
        return "A-Instruction: Assembly= " + assemblyCode + ", Machine= " + machineCode;
    }
}
