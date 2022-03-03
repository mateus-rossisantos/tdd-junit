package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BunusServiceTest {

    @Test
    void bonusDeveriaSerZeroPraSalarioAcimaDeMil(){
        BonusService service = new BonusService();
       // Assertions.assertThrows(IllegalArgumentException.class,() -> service.calcularBonus(
        //        new Funcionario("Mateus",
         //               LocalDate.now(),
         //              new BigDecimal(25000))));

        try {
            service.calcularBonus(new Funcionario("Mateus", LocalDate.now(), new BigDecimal(25000)));
            Assertions.fail("Não deu a exception");
        }catch (Exception e){

        }

    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Mateus",
                        LocalDate.now(),
                        new BigDecimal(2500)));

        Assertions.assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void bonusDeMilReais(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Mateus",
                        LocalDate.now(),
                        new BigDecimal(10000)));

        Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
    }


}
