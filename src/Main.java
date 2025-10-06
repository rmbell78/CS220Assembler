public class Main {
    public static void main(String[] args) {
//        String code1 = "  0;JMP  //unconditional jump  ";
//        if(code1.contains("/")) {
//            code1 = code1.substring(0, code1.indexOf('/')).trim();
//        } else{
//            code1 = code1.trim();
//        }
//        System.out.println(code1);
//
//        String cleanLine = "0;JMP";
//
//        String jumpCommand = null;
//        if(cleanLine.contains(";")){
//            jumpCommand = cleanLine.substring(cleanLine.indexOf(';') + 1);
//        }
//        System.out.println(jumpCommand);
//
//        String code = "D=M;JGT";
//
//        String dest = null;
//        String comp = null;
//        String jmp = null;
//
//        if(code.contains("=") && code.contains(";")){
//            dest = code.substring(0,code.indexOf('='));
//            comp = code.substring(code.indexOf('=') + 1, code.indexOf(';'));
//            jmp = code.substring(code.indexOf(';') + 1);
//        }
//
//        System.out.println(dest);
//        System.out.println(comp);
//        System.out.println(jmp);

        try{
            AssemblyFileParser test = new AssemblyFileParser("Add.asm");
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}