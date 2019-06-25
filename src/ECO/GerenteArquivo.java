package ECO;

import java.io.
        BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class GerenteArquivo {

    public static void salvar(String saida, String nomeArquivo) throws IOException{
        PrintWriter arquivo = null;
        BufferedWriter bw = null;
        FileWriter fw = null;

        try{
            fw = new FileWriter(new File(nomeArquivo));
            bw = new BufferedWriter(fw);
            arquivo = new PrintWriter(bw);
            arquivo.println(saida);
        } finally{
            if (arquivo != null) arquivo.close();
        }

    }

    public static void salvarAppend(String saida, String nomeArquivo) throws IOException{
        PrintWriter arquivo = null;
        BufferedWriter bw = null;
        FileWriter fw = null;

        try{
            fw = new FileWriter(new File(nomeArquivo), true);
            bw = new BufferedWriter(fw);
            arquivo = new PrintWriter(bw);
            arquivo.println(saida);
        }finally{
            if (arquivo != null) arquivo.close();
        }

    }
    public static String ler(String nomeArquivo)throws IOException{
        BufferedReader br = null;
        FileReader fr = null;
        String resultado = "";
        try{
            fr = new FileReader(nomeArquivo);
            br = new BufferedReader(fr);
            String linha;
            while((linha = br.readLine()) != null){
                resultado += linha + "\n";
            }
            return resultado;
        }finally{
            if (br != null) br.close();
        }
    }

    public static void salvarObjeto(Object objeto, String nomeArquivo) throws FileNotFoundException, IOException{
        ObjectOutputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            arqObjectos.writeObject(objeto);
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }

    public static Object lerObjetos(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectInputStream(new FileInputStream(nomeArquivo));
            return arqObjectos.readObject();
        }finally{
            if(arqObjectos != null)
                arqObjectos.close();
        }
    }
}
