package ECO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {

    private ControllerGeral controleGeral;

     public Persistencia(ControllerGeral controleGeral) {
        this.controleGeral = controleGeral;
    }

    public void salvar() throws IOException {
        ObjectOutputStream arqObjectos = null;
        try{
            arqObjectos = new ObjectOutputStream(new FileOutputStream("arquivoEspecifico.dat"));
            arqObjectos.writeObject(this.controleGeral.getControlePessoas().getPessoas());
            arqObjectos.writeObject(this.controleGeral.getControleComissao().getMapaComissoes());
            arqObjectos.writeObject(this.controleGeral.getControllerPLS().getPropostasDeLeis());
            arqObjectos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limpar() {
        File arquivo = new File("arquivoEspecifico.dat");
        arquivo.delete();
    }

        public void carregar() throws IOException {

            ObjectInputStream arqObjectos = null;
            try{
                if (! new File("arquivoEspecifico.dat").exists()) {
                    FileOutputStream fos = new FileOutputStream("arquivoEspecifico.dat");
                    fos.close();
                }
                FileInputStream arqObjectos1 = new FileInputStream("arquivoEspecifico.dat");
                if (arqObjectos1.available() > 0) {
                    arqObjectos = new ObjectInputStream(arqObjectos1);
                    arqObjectos.readObject();
                }
                } catch (ClassNotFoundException e) {
                e.printStackTrace();
                } catch (FileNotFoundException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
                } finally{
                if(arqObjectos != null)
                    arqObjectos.close();
        }
    }
}