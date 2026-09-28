package application;

import entities.Reserva;
import model.exceptions.DomainException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);

        try {
            System.out.println("Qual é o número do quarto?");
            int numeroDoQuarto = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente
            System.out.println("Qual é a data de check-in (dd/MM/yyyy)?");
            Date checkIn = sdf.parse(sc.nextLine());
            System.out.println("Qual é a data de check-out (dd/MM/yyyy)?");
            Date checkOut = sdf.parse(sc.nextLine());

            Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
            System.out.println("Reserva criada: " + reserva);

            System.out.println();
            System.out.println("Qual é a data de check-in (dd/MM/yyyy)?");
            checkIn = sdf.parse(sc.nextLine());
            System.out.println("Qual é a data de check-out (dd/MM/yyyy)?");
            checkOut = sdf.parse(sc.nextLine());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Datas atualizadas: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Erro ao analisar a data: " + e.getMessage());
            // Aqui você pode adicionar a lógica para ler os dados da reserva
        }
        catch (DomainException e) {
            System.out.println("Erro ao atualizar as datas: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

    }
}

