import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Uniforme> uniformes = new ArrayList<>();
        int tamanho = Integer.parseInt(br.readLine());

        while (true) {
            String temp = br.readLine();
            if (temp.equals("0")) {
                break;
            } else {
                String[] corTamanho = br.readLine().split(" ");
                uniformes.add(new Uniforme(corTamanho[0], corTamanho[1], temp));
            }
        }
        Collections.sort(uniformes, new comparando());
        uniformes.stream().forEach(System.out::println);
    }
}

class comparando implements Comparator<Uniforme> {

    @Override
    public int compare(Uniforme o1, Uniforme o2) {
        int cor = o1.getCor().compareTo(o2.getCor());
        int tamanho = o2.getTamanho().compareTo(o1.getTamanho());
        int nome = o1.getNome().compareTo(o2.getNome());

        return (cor == 0) ? ((tamanho == 0) ? nome : tamanho) : cor;
    }
}

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
