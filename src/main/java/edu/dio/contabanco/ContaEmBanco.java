
package edu.dio.contabanco;

/**
 *
 * @author SandroAmânciodeSá
 */
public class ContaEmBanco {
    
    private  int numero;
    private  String agencia;
    private  String nomeDoCliente;
    private  float saldo;

    public ContaEmBanco() {
       this.numero = 0;
       this.agencia = "";
       this.nomeDoCliente = "";    
       this.saldo = 0;
    }
    
    public ContaEmBanco(int numero, String agencia, String nome) {
       this.numero = numero;
       this.agencia = agencia;
       this.nomeDoCliente = nome;
    }
    
 
    public void depositar(float deposito){
        this.saldo = this.saldo + deposito;
    }
    
    public boolean sacar(float saque){
        if(this.saldo >= saque){
            this.saldo = this.saldo - saque;
        }else{
            return false;
        }
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nomeDoCliente;
    }

    public void setNome(String nome) {
        this.nomeDoCliente = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
