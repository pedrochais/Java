import java.util.Scanner;
import service.Maquina;

public class Main {
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        Maquina maquina = new Maquina();

        int operacao = -1;
        while(operacao != 0){
            
            System.out.print("\n1. Emitir ticket\n2. Verificar status do ticket\n3. Pagar ticket\n4. Consultar saldo das operações\n\n0. Sair\n~ ");
            operacao = input.nextInt();
            
            int numero;
            switch(operacao){
                
                case 1:
                    System.out.print("Valor do ticket: R$ ");
                    float valor = input.nextFloat();

                    maquina.emitir(valor);
                    break;
                case 2:
                    System.out.print("Número do ticket: ");
                    numero = input.nextInt();

                    maquina.status(numero);
                    break;
                case 3:
                    System.out.print("Número do ticket: ");
                    numero = input.nextInt();

                    maquina.pagar(numero);
                    break;
                case 4:
                    float saldo = maquina.saldo();
                    System.out.printf("[Saldo: R$ %.2f]\n", saldo);
                    break;
                case 0:
                    System.out.println("[Saindo do programa]");
                    break;
                default:
                    System.out.println("\n[Escolha uma opção]");
            }
        }
    }
}

/*


*/