package edu.dio.contabanco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SandroAmânciodeSá
 */
public class ContaTerminal {
    
  
    public static void main(String[] args) {
        
        ContaTerminal teminal = new ContaTerminal();
        int numero;
        String agencia;
        String nomeDoCliente;
        float saldo;
        float deposito = 0;
        
        agencia = teminal.entDadosString("Por favor, digite o número da Agência !");
        numero = teminal.entDadosInt("Por favor, digite o número da conta !");
        nomeDoCliente = teminal.entDadosString("Por favor, digite o seu nome !");
        deposito = teminal.entDadosFloat("Por favor, digite seu deposito inicial!");
        ContaEmBanco conta = new ContaEmBanco(numero,agencia,nomeDoCliente);
        conta.depositar(deposito);
        
        System.out.println("Olá "+conta.getNome()+", obrigado por criar uma conta "
                + "em nosso banco, sua agência é "+conta.getAgencia()+", conta "+conta.getNumero()+" e seu saldo "+conta.getSaldo()+" já está disponível para saque");
        
      
     
    }
    
    public String entDadosString(String rotulo) {
        System.out.println(rotulo);

        BufferedReader digitado = new BufferedReader(new InputStreamReader(System.in));
        String textoDigitado = "";
        boolean cont = true;

        while(cont){
            try{
                textoDigitado = digitado.readLine();
                if (!textoDigitado.isEmpty()) {
                    cont = false;
                } else {
                    System.out.println("A deve conter ao menos uma letra.");
                }
            }
            catch(IOException e){
                System.out.println("Erro de entrada");
            }
        }

        return textoDigitado;
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
        
         public float entDadosFloat(String rotulo) {
       
        BufferedReader digitado = new BufferedReader(new InputStreamReader(System.in));
        String textoDigitado ;
        float resultado = 0;
        boolean cont = true;

        while(cont){
            System.out.println(rotulo);
            try{
                textoDigitado = digitado.readLine();
                resultado = Float.parseFloat(textoDigitado);
                cont = false;
            }
            catch(IOException e){
                System.out.println("Erro de entrada");
            }
            catch(NumberFormatException nfe){
                System.out.println("O valor deve ser um numerico");
            } 
        }

        return resultado;
    
    }
    
}
