public class Main { 
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Empresa"); 
        Interface interf = new Interface(empresa); 
        interf.apresentarMenu(); 
    }
}