import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Uniforme> uniformes = new ArrayList<>();
        int tamanho = Integer.parseInt(br.readLine());

        //1-Leitura das entradas. Onde instancio a classe Uniforme que salva os valores
        //Cor, Tamanho e nomePessoa em lugares(variaveis) diferentes para poder sortear.
        while (true) {
            String temp = br.readLine();
            if (temp.equals("0")) {
                break;
            } else {
                String[] corTamanho = br.readLine().split(" ");
                uniformes.add(new Uniforme(corTamanho[0], corTamanho[1], temp));
            }
        }
        //Passo a Lista
        Collections.sort(uniformes, new comparando());
        uniformes.stream().forEach(System.out::println);
    }
}
/**
3-Crio a classe uso @override no metodo compare
Quando retorna 0 os valores são iguais se retornarem -1,1 sao diferentes
Então verifiquei onde se a cor for igual ele verifica o tamanho caso seja igual tambem quem fica responsavel pela
ordem é nome;
*/
class comparando implements Comparator<Uniforme> {

    @Override
    public int compare(Uniforme o1, Uniforme o2) {
        int cor = o1.getCor().compareTo(o2.getCor());
        int tamanho = o2.getTamanho().compareTo(o1.getTamanho());
        int nome = o1.getNome().compareTo(o2.getNome());

        return (cor == 0) ? ((tamanho == 0) ? nome : tamanho) : cor;
    }
}

/**
2-Criei a classe Uniforme passando os valores de entrada em variaveis diferentes
Fiz um @override no metodo toString para quando eu percorrer cada classe da lista 'Uniformes'
Mostrar as variaveis/msg do jeito que eu quero.
*/
 class Uniforme{
    private String cor;
    private String tamanho;
    private String nome;

    public Uniforme(String cor, String tamanho,String nome ){
        this.cor = cor;
        this.tamanho = tamanho;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return cor + " " + tamanho + " " + nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getNome() {
        return nome;
    }
}
