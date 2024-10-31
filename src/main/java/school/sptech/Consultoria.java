package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = desenvolvedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas != null && vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
            System.out.println("Desenvolvedor contratado!");
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor != null && desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
            System.out.println("Desenvolvedor contratado!");
        }
    }

    public Double getTotalSalarios(){
        Double total = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            total += desenvolvedor.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer total = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                total++;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> salarioMaiorQue = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                salarioMaiorQue.add(desenvolvedor);
            }
        }
        return salarioMaiorQue;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (menorSalario.calcularSalario() > desenvolvedor.calcularSalario()){
                menorSalario = desenvolvedor;
            }
        }
        return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> DevPorTec = new ArrayList<>();
            for (Desenvolvedor desenvolvedor : desenvolvedores){
                if (desenvolvedor.toString().contains(tecnologia)){
                    DevPorTec.add(desenvolvedor);
                }
            }
            return DevPorTec;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.toString().contains(tecnologia)){
                soma+= desenvolvedor.calcularSalario();
            }
        }
        return soma;
    }

}
