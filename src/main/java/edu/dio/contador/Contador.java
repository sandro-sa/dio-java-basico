package edu.dio.contador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SandroAmânciodeSá
 */
public class Contador {
    
    public static void main(String[] args) {
        
        int parametroUm;
        int parametroDois;
        
        Contador contador = new Contador();
        
        parametroUm = contador.entDadosInt("Digite o primeiro parâmetro");
        parametroDois = contador.entDadosInt("Digite o primeiro parâmetro");
        
        try {
            //chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);

        }catch (ParametrosInvalidosException exception ) {
             exception.ParametrosInvalidosException();
                        
        }
		
    }
  
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if(parametroUm >= parametroDois){
                throw new ParametrosInvalidosException();
            }
        int contagem = parametroDois - parametroUm;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número "+i);
        }
      }
    
    public int entDadosInt(String rotulo) {
        
        BufferedReader digitado = new BufferedReader(new InputStreamReader(System.in));
        String textoDigitado;
        int resposta = 0;
        boolean cont = true;

        while(cont){
            System.out.println(rotulo);
            try{
                textoDigitado = digitado.readLine();
                resposta = Integer.parseInt(textoDigitado);
                cont = false;
            }
            catch(IOException e){
                System.out.println("Erro de entrada");
            }
            catch(NumberFormatException nfe){
                System.out.println("O valor deve ser um numero inteiro");
            } 
        }

        return resposta;
    }
}
