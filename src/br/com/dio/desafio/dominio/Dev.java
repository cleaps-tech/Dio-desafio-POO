package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosinscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosconcluidos = new LinkedHashSet<>();

    public void inscreverBootcap(Bootcamp bootcamp){
        this.conteudosinscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosinscritos.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosconcluidos.add(conteudo.get());
            this.conteudosinscritos.remove(conteudo.get());

        }else{
            System.err.println("Você não está matriculado em nenhum conteúdo");

        }
    }
    public double calcularTotalxp(){
        return this.conteudosconcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularxp())
                .sum();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosinscritos() {
        return conteudosinscritos;
    }

    public void setConteudosinscritos(Set<Conteudo> conteudosinscritos) {
        this.conteudosinscritos = conteudosinscritos;
    }

    public Set<Conteudo> getConteudosconcluidos() {
        return conteudosconcluidos;
    }

    public void setConteudosconcluidos(Set<Conteudo> conteudosconcluidos) {
        this.conteudosconcluidos = conteudosconcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosinscritos, dev.conteudosinscritos) && Objects.equals(conteudosconcluidos, dev.conteudosconcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosinscritos, conteudosconcluidos);
    }
}
