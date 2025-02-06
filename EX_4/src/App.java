import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Deque<Double> dequeSemJuros = new Deque<>();
        Deque<Double> dequeComJuros = new Deque<>();

        double inicial = 0;
        int mes = 0;
        String op = "";
        double total = 0;
        

        System.out.println("Qual valor do financiamento: ");
        System.out.print("R$ ");
        try{
            inicial = in.nextDouble();
        }catch(Exception ex){
            System.out.println("Valor invalido saindo do programa.");
            System.exit(0);
        }

        System.out.println("\nQuantos meses?");
        try {
            mes = in.nextInt();
        } catch (Exception e) {
            System.out.println("Valor invalido saindo do programa.");
            System.exit(0);
        }
        
        double valor = inicial/mes;
        for(int i = 1; i <= mes; ++i){
            dequeSemJuros.inserirInicio(valor);
            dequeComJuros.inserirFim( valor + (( valor * 0.01) * i));
        }

        while(!dequeSemJuros.isEmpty()){
            System.out.println("Pagar parcela atual ou final? (A) atual, (F) final");
            op = in.next();
            if(op.equals("A")){
                total += dequeComJuros.removeInicio();
                dequeSemJuros.removeFim();
            }else{
                if(op.equals("F")){
                    if(dequeComJuros.getTamanho() == 1){
                        total +=  dequeComJuros.removeInicio();
                        dequeSemJuros.removeFim();
                    }else{
                        total += dequeSemJuros.removeInicio();
                        dequeComJuros.removeFim();
                    }
                }else{
                    System.out.println("Operação invalida digite (A) para atual e (F) para final.");
                }
            }
        }

        System.out.println("Valor pago no total: " + total);
        
    }
}
