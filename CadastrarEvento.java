import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CadastrarEvento {
    String path = "data/usuarios_cadastrados.txt";
    File cadastro_evento = new File(path);
    
    String selecao;
    String estado;
    String cidade;
    String evento;
    String data;

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEvento(String evento) {
        this.evento = evento;
    }
    public void setData(String data) {
        this.data = data;
    }

    public void SalvarArquivo() {
        //Criar arquivo caso não tenha
        try {
            if(cadastro_evento.createNewFile()){
                System.out.print("Arquivo Criado: "+ cadastro_evento.getName());}
            else{System.out.print("");}

        } catch (IOException e ){
            System.out.print("Um erro ocorreu!\n");
            e.printStackTrace();
        }

        //Escrever dados no arquivo
        try {
            FileWriter cadastro_escrever = new FileWriter(path, true);
            BufferedWriter br = new BufferedWriter(cadastro_escrever);
            
            br.write("O evento acontecera no dia: " + this.data + " ");
            br.write("Estado: " + this.estado + " ");
            br.write("Cidade: " + this.cidade + " ");
            br.write("Tipo de Evento : " + this.evento);
            br.newLine();

            br.close();
            System.out.println("Evento Cadastrado com Sucesso!\n");

        } catch(IOException e){
            System.out.print("Ocorreu um erro!\n");
            e.printStackTrace();
        }
    }

    public void LerEventosCadastrados() {
        try{
            BufferedReader lerArq = new BufferedReader(new FileReader(cadastro_evento));
            String linha = lerArq.readLine();
            int count = 0;
            
            while(linha != null) { 
                count += 1;
                System.out.printf("Evento " + count + ": " + "%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            lerArq.close();

        } catch(IOException e){
            System.out.println("Ocorreu um Erro!");
            e.printStackTrace();
        }    

    }
    public String Evento_Selecao(int evento_selecionado) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = null;
            int lineNumber = 0;
            HashMap<Integer, String> lines = new HashMap<Integer, String>();

            while ((line = bufferedReader.readLine()) != null) {
            lines.put(lineNumber, line);
            lineNumber++;
            }
            bufferedReader.close();
            selecao = lines.get(evento_selecionado-1);
        }catch(IOException e){
            System.out.println("Ocorreu um Erro!");
            e.printStackTrace();
        }
        return selecao;
    } 
}
