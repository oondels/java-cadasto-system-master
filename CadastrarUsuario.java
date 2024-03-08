import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class CadastrarUsuario {
    private String nomeusuario;
    private String email;
   	private String idade;

    String path = "G:/Meu Drive/Hendrius/1. Graduação/2.Unifacs Análise e Desenvolvimento de Sistemas/Programação de Soluções Computacionais/Atividades/Pratique 1/data/usuarios_cadastrados.txt";
    File cadastro = new File(path);

    public void setNome(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIdade(String idade) {
    	this.idade = idade;
    }

    public void SalvarArquivo() {
        try {
            if(cadastro.createNewFile()){
                System.out.print("File created: "+ cadastro.getName());}
            else{System.out.print("");}

        } catch (IOException e ){
            System.out.println("Um erro ocorreu!\n");
            e.printStackTrace();
        }

        try {
            FileWriter cadastro_escrever = new FileWriter(path, true);
            BufferedWriter br = new BufferedWriter(cadastro_escrever);
            
            br.write("Nome: " + this.nomeusuario + " ");
            br.write("Email: " + this.email + " ");
            br.write("Idade: " + this.idade);
            br.newLine();

            br.close();
            System.out.println("Usuário Cadastrado com Sucesso!\n");

        } catch(IOException e){
            System.out.print("Ocorreu um erro!\n");
            e.printStackTrace();
        }
    }
    
    public void LerUsuariosCadastrados() {
        try{
            BufferedReader lerArq = new BufferedReader(new FileReader(cadastro));
            String linha = lerArq.readLine();
            int count = 0;
            
            while(linha != null) { 
                count += 1;
                System.out.printf("Usuario " + count + ": " + "%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            lerArq.close();

        } catch(IOException e){
            System.out.println("Ocorreu um Erro!");
            e.printStackTrace();
        }
        
    }
}
