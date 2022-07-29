import br.com.dio.desafio.dominio.*;
import br.com.dio.desafio.dominio.Conteudo;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Main {
     public static void main(String[] args){
         Curso curso1 = new Curso();
         curso1.setTitulo("Curso Java");
         curso1.setDescricao("Descrição do curso Java");
         curso1.setCargaHoraria(8);

         Curso curso2 = new Curso();
         curso2.setTitulo("Curso de Javascript");
         curso2.setDescricao("Descrição de curso javascript");
         curso2.setCargaHoraria(6);

         Mentoria mentoria = new Mentoria();
         mentoria.setTitulo("Mentoria de Java");
         mentoria.setDescricao("Descrição mentoria Java");
         mentoria.setData(LocalDate.now());



//         System.out.println(curso1);
//         System.out.println(curso2);
//         System.out.println(mentoria);

         Bootcamp bootcamp = new Bootcamp();
         bootcamp.setNome("Bootcal java developer");
         bootcamp.setDescricao("Descrição bootcamp java developer");
         bootcamp.getConteudos().add(curso1);
         bootcamp.getConteudos().add(curso2);
         bootcamp.getConteudos().add(mentoria);

         Dev  devAndre = new Dev();
         devAndre.setNome("André Pereira da Silva");
         devAndre.inscreverBootcap(bootcamp);
         System.out.println("Conteúdos inscritos " + devAndre.getConteudosinscritos());
         devAndre.progredir();
         System.out.println("Conteúdos inscritos " + devAndre.getConteudosinscritos());
         System.out.println("Conteúdos concluídos " + devAndre.getConteudosconcluidos());
         System.out.println("XP: " + devAndre.calcularTotalxp());


         Dev devJoao = new Dev();
         devJoao.setNome("João");
         devJoao.inscreverBootcap(bootcamp);
         System.out.println("Conteúdos inscritos " + devJoao.getConteudosinscritos());
         devJoao.progredir();
         System.out.println("Conteúdos inscritos " + devJoao.getConteudosinscritos());
         System.out.println("Conteúdos concluídos " + devJoao.getConteudosconcluidos());
         System.out.println("XP: " + devJoao.calcularTotalxp());


     }

}
