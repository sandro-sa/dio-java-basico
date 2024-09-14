package edu.dio.controledecandidatos.candidatura;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author SandroAmânciodeSá
 */
public class ProcessoSeletivo {
    
    private static ArrayList<String> candidatosSelecionados = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Inicio do processo seletivo"); 
        selecaoDeCandidatos();
        imprimirCandidatosSelecionados();
        ligarParaCandidatos();
    }
    
    static void selecaoDeCandidatos(){
        
        System.out.println("");
        System.out.println("Selecionado os candidatos");
        System.out.println("");
        
        String [] canditatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
     
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while( candidatosSelecionados.size() < 5 && candidatoAtual < canditatos.length){
            String candidato = canditatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato(a) "+candidato+" solicitou este valor de salário "+salarioPretendido);
            if(analisarCandidato(salarioPretendido)){
                System.out.println("O candito(a) "+candidato+" foi selecionado para a vaga");
                candidatosSelecionados.add(canditatos[candidatoAtual]);
            }
            candidatoAtual++;
        }  
    }
    
    static void imprimirCandidatosSelecionados(){
        System.out.println("");
        System.out.println("Listando os candidatos selecionados");
        System.out.println("");
        for(String candidato : candidatosSelecionados){
            System.out.println("O candidato(a) foi "+candidato);
        }
    }
    
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    
    static boolean analisarCandidato( double salarioPretendido){
        
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
             return false;
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o canditado com contra proposta.");
             return true;
        }else{
            System.out.println("Aguardar resultado dos demais candidatos.");
             return true;
        }
    }
    
    static boolean atender(){
       return new Random().nextInt(3) == 1; 
    }
    
    static void entrandoEmContato(String candidato){
        
        
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
     
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas ++;
            }else{
                System.out.println("Cotanto realizado com sucesso.");
            }
        }while(continuarTentando && tentativasRealizadas < 3);
        
        if(atendeu){
            System.out.println("Conseguimos contato com "+candidato+" na tentativa "+tentativasRealizadas);
        }else{
            System.out.println("Não conseguimos contato com "+candidato+ "em "+tentativasRealizadas+" realizadas");
        }
           
    }
    
    static void ligarParaCandidatos(){
        System.out.println("");
        System.out.println("Ligando para os candidatos selecionados");
        System.out.println("");
        if(!candidatosSelecionados.isEmpty()){
            for(String candidato: candidatosSelecionados){
               entrandoEmContato(candidato);
           }
        }else{
            System.out.println("Não há cadidatos para ligar");
        }
       
    }
}
