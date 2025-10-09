public class Main {
    public static void main(String[] args) {


        try{
            AssemblyFileParser afp = new AssemblyFileParser("Pong.asm");
            MachineCodeWriter.writeToBinaryFile("Pong.hack", afp.getParsedAssemblyInstructions());
        } catch(Exception e){
            System.err.println(e.getMessage());
        }


    }
}