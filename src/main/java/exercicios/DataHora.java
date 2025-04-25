package exercicios;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataHora {
    public static void main(String[] args) {
        /*Instanciando um formato para data e hora
        pode ser usado como segundo parametro do parse*/
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*Data Agora*/
        LocalDate data01 = LocalDate.now();
        /*Data e Hora Agora*/
        LocalDateTime data02 = LocalDateTime.now();
        /*Data e Hora Global*/
        Instant data03 = Instant.now();
        /*Data com formatação*/
        LocalDate data04 = LocalDate.parse("01/02/2002", formato1);
        System.out.println("data04: " + data04);
        /*Data e Hora com Formatação*/
        LocalDateTime data05 = LocalDateTime.parse("01/02/2002 21:36", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("data05: " + data05);
        /*Instanciando data separadamente*/
        LocalDate data06 = LocalDate.of(2002, 2, 1);
        System.out.println("data06: " + data06);
        /*Instanciando data e hora separadamente*/
        LocalDateTime data07 = LocalDateTime.of(2002, 2, 1, 23, 30);
        System.out.println("data07: " + data07);


        System.out.println("data01" + data01);
        System.out.println("data02" + data02);
        /*-----------------------------------------------------------------------------------------------------------*/
        /*Transformando em String*/
        System.out.println("data06: " + data06.format(formato1));
        System.out.println("data05: " + formato1.format(data05));
        System.out.println("data05: " + data05.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        /*Formatando data e hora global*/
        /*withZone(ZoneId.systemDefault()) pega o fuso horario do computador do usuario*/
        DateTimeFormatter formatoGlobal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        System.out.println("data03: " + formatoGlobal.format(data03) );

        /*Instanciando horario global em qualquer horario*/
        Instant data09 = Instant.parse("2022-07-20T11:36:11Z");
        System.out.println("data09: " + formatoGlobal.format(data09));

        /*Convertendo Data Global para Local*/
        Instant data10 = Instant.parse("2022-07-20T11:36:11Z");
        LocalDateTime data10Conver = LocalDateTime.ofInstant(data10, ZoneId.systemDefault());
        System.out.println("data10Conver: " + data10Conver.format(formatoGlobal));

        /*Calculos com data*/
        LocalDate teste01 = LocalDate.parse("2022-07-20");
        LocalDateTime teste02 = LocalDateTime.parse("2022-07-20T11:36:11Z");
        Instant teste03 = Instant.parse("2022-07-20T11:36:11Z");

        LocalDate latSemana = teste01.minusDays(7);
        LocalDate proximaSemana = teste01.plusDays(7);
        LocalDate proximoAno = teste01.plusYears(10);
        LocalDateTime proximoMinuto = teste02.plusMinutes(1);

        Instant lastSemanaInstant = teste03.minus(7, ChronoUnit.DAYS);

        Duration t1 = Duration.between(proximaSemana.atStartOfDay(), teste01.atStartOfDay());
        System.out.println("t1: " + t1.toDays());

    }
}
