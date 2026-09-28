package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroDoQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public long duracao() {
        try {
            long duracao = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("Erro ao calcular a duração da reserva: " + e.getMessage());
            return 0;
        }
    }

    public void atualizarDatas(Date checkIn, Date checkOut) {
        try {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        catch (Exception e) {
            System.out.println("Erro ao atualizar as datas da reserva: " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return
                "numeroDoQuarto: " + numeroDoQuarto +
                ", checkIn: " + sdf.format(checkIn) +
                ", checkOut: " + sdf.format(checkOut) + "," + duracao() + " noites";
    }
}
