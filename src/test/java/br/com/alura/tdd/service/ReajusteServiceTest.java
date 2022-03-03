package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        System.out.println("inicio");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Mateus", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de todos");
    }

    @Test
    public void reajusteTresPorCentoComDesempenhoADesejar(){

        service.reajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePorCentoComDesempenhoBom(){

        service.reajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteVintePorCentoComDesempenhoOtimo(){

        service.reajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
