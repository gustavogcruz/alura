public class FluxoComTratamentoChecked {

	// throws não necessário, pois a exceção foi tratada pelo try/catch
    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
        metodo1();
        } catch (ArithmeticException | NullPointerException | MyException ex) {
        	String msg = ex.getMessage();
        	System.out.println("Exception " + msg);
        	ex.printStackTrace();
        }
        System.out.println("Fim do main");
    }

    private static void metodo1() throws MyException {
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MyException{
       System.out.println("Ini do metodo2");  
       //A
       //ArithmeticException exception = new ArithmeticException("deu errado");
       //throw exception;
       //B
       throw new MyException("deu muito errado");
       //System.out.println("Fim do metodo2");
    }
}
