package application;

import entities.Reserva;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);

            System.out.println("Qual é o número do quarto?");
            int numeroDoQuarto = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente
            System.out.println("Qual é a data de check-in (dd/MM/yyyy)?");
            Date checkIn = sdf.parse(sc.nextLine());
            System.out.println("Qual é a data de check-out (dd/MM/yyyy)?");
            Date checkOut = sdf.parse(sc.nextLine());
            if (!checkOut.after(checkIn)) {
                System.out.println("Erro: A data de check-out deve ser posterior à data de check-in.");
            } else {
                Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
                System.out.println("Reserva criada: " + reserva);

                System.out.println();
                System.out.println("Qual é a data de check-in (dd/MM/yyyy)?");
                checkIn = sdf.parse(sc.nextLine());
                System.out.println("Qual é a data de check-out (dd/MM/yyyy)?");
                checkOut = sdf.parse(sc.nextLine());
                Date now = new Date();
                if (checkIn.before(now) || checkOut.before(now)) {
                    System.out.println("Erro: A data de check-in não pode ser anterior à data atual.");
                } else if (!checkOut.after(checkIn)){
                    System.out.println("Erro: A data de check-out deve ser posterior à data de check-in.");
                } else {
                    reserva.atualizarDatas(checkIn, checkOut);
                    System.out.println("Reserva criada: " + reserva);
                }
            }
            // Aqui você pode adicionar a lógica para ler os dados da reserva
        }

    }
