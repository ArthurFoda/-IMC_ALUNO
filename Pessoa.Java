package entidades;

public class Pessoa {
    private String nome;
    private String cpf;
    private double peso;
    private double altura;

    
    public Pessoa(String nome, String cpf, double peso, double altura) {
        this.nome = nome;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
    }

    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}

package entidades;

public class Aluno extends Pessoa {
    private double nota;
    private double percentualPresenca;

    
    public Aluno(String nome, String cpf, double peso, double altura, double nota, double percentualPresenca) {
        super(nome, cpf, peso, altura);
        this.nota = nota;
        this.percentualPresenca = percentualPresenca;
    }

    
    public double getNota() {
        return nota;
    }

    public double getPercentualPresenca() {
        return percentualPresenca;
    }
}

package utilidades;

import entidades.Aluno;

public class FuncoesUteis {

    
    public boolean verificarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    
    public double calcularIMC(double peso, double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        return peso / (altura * altura);
    }

    
    public boolean avaliarAluno(Aluno aluno) {
        return aluno.getNota() >= 5 && aluno.getPercentualPresenca() >= 75;
    }
}

package aplicacao;

import entidades.Aluno;
import utilidades.FuncoesUteis;

public class Main {

    public static void main(String[] args) {
        
        Aluno aluno = new Aluno("João", "12345678901", 70.0, 1.75, 8.0, 80.0);

        
        FuncoesUteis funcoes = new FuncoesUteis();

        
        System.out.println("CPF válido: " + funcoes.verificarCpf(aluno.getCpf()));

        
        double imc = funcoes.calcularIMC(aluno.getPeso(), aluno.getAltura());
        System.out.println("IMC do aluno: " + imc);

        
        boolean aprovado = funcoes.avaliarAluno(aluno);
        System.out.println("Aluno aprovado: " + aprovado);
    }
}


