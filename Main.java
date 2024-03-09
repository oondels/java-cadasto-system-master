import java.util.ArrayList;
import java.util.List;
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
        List lista_eventos = new ArrayList();
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

                    System.out.println("Qual o tipo de evento?\n\t1. Festas\n\t2. Esportivo\n\t3. Show\n\t");
                    String evento = leitura.nextLine();

                    switch (evento) {
                        case "1":
                            evento = "Festas";
                            break;
                        case "2":
                            evento = "Esportivo";
                        case "3":
                            evento = "Show";
                        default:
                            break;
                    }    

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
                {
                    System.out.println("\t\tEventos cadastrados.\n");
                    new_evento.LerEventosCadastrados();

                    System.out.println("\nDeseja participar de algum?\n1. Sim\n2. Não");
                    int resposta_evento = leitura.nextInt();

                    if (resposta_evento == 1) {
                        System.out.println("Deseja participar de qualEvento?\nSelecione o número correspondente\n");
                        int evento_selecionado = leitura.nextInt();
                        
                        System.out.println(new_evento.Evento_Selecao(evento_selecionado));
                        lista_eventos.add(new_evento.Evento_Selecao(evento_selecionado));
                        System.out.println("Usuário cadastrado no evento con Sucesso!");
                        }
                        else{
                            System.out.println("Voltando ao Menu...\n");
                        }
                    }

                    tempoEspera();
                    break;
                
                case "6":
                    System.out.println("\tEvento(s) que você esta cadastrado:");
                    for(int i = 0; i < lista_eventos.size(); i++){
                        System.out.println(i + ": " + lista_eventos.get(i));
                    }

                    System.out.println("Deseja cancelar a presença em algum evento?\n1. Sim\n2. Nao");
                    int cancelar_evento = leitura.nextInt();
                    if (cancelar_evento == 1) {
                        System.out.println("Selecione o numero correspondente que deseja cancelar.");
                        int opcao_cancelar = leitura.nextInt();
                        lista_eventos.remove(opcao_cancelar);
                    }
                    else {
                        System.out.println("Voltando ao Menu...\n");
                    }
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
