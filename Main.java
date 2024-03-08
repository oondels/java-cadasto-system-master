import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static String tempoEspera() {
        Scanner wait_Time = new Scanner(System.in);
        String espera = wait_Time.nextLine();
        return espera;
    }     
       
    public static void main(String[] args){
        
        Scanner leitura = new Scanner(System.in);
        boolean key = true;
        String estados[] = {"Bahia", "Pernambuco"};
        
        while (key == true) {
            CadastrarUsuario usuario = new CadastrarUsuario();
            CadastrarEvento new_evento = new CadastrarEvento();

            System.out.println("\t\tBem vindo ao aplicativo de entregas...\n");
            System.out.print("\t\tSelecione uma Opção:\n");
            System.out.print("1- Cadastrar Usuário.\n");
            System.out.print("2- Ver Estados disponíveis para entregas.\n");
            System.out.print("3- Ver usuarios Cadastrados.\n");
            System.out.print("4- Cadastrar evento.\n");
            System.out.print("5- Ver eventos cadastrados.\n");
            System.out.print("6- Editar.\n");
            System.out.print("7- Editar.\n");
            System.out.print("0- Sair do aplicativo.\n");
            String user_Select = leitura.nextLine();
            
            switch (user_Select) {
                case "1":
                    System.out.print("Nome:\n");
                    String nome = leitura.nextLine();
                    System.out.print("Email:\n");
                    String email = leitura.nextLine();
                    System.out.print("Idade:\n");
                    String idade = leitura.nextLine();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setIdade(idade);

                    usuario.SalvarArquivo();

                    tempoEspera();
                    break;
                
                case "2":
                    System.out.print("Os estados disponíveis atualmente são:\n");
                    for (int i = 0; i < estados.length; i++){
                        System.out.print(estados[i]+"\n");
                    }

                    tempoEspera();
                    break;
                
                case "3":
                    usuario.LerUsuariosCadastrados();
                    tempoEspera();
                    break;
                
                case "4":
                    System.out.println("\t\tCadastro de Eventos");

                    System.out.println("Evento: ");
                    String evento = leitura.nextLine();
                    System.out.println("Estado: ");
                    String estado = leitura.nextLine();
                    System.out.println("Cidade: ");
                    String cidade = leitura.nextLine(); 
                    System.out.println("Data: ");
                    String data = leitura.nextLine();

                    new_evento.setEvento(evento);
                    new_evento.setEstado(estado);
                    new_evento.setCidade(cidade);
                    new_evento.setData(data);
                    
                    new_evento.SalvarArquivo();
                    tempoEspera();
                    break;

                case "5":
                    System.out.println("\t\tEventos cadastrados.\n");
                    new_evento.LerEventosCadastrados();
                    tempoEspera();
                    break;

                case "0":
                    key = false;
                    break;

                default:
                    System.out.print("Selecione uma opção válida!\n");
                    break;
                }
            }
        }
}
