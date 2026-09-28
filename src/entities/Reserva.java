package entities;

import model.exceptions.DomainException;

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
        if (!checkOut.after(checkIn)){
            throw new DomainException("A data de check-out deve ser posterior à data de check-in.");
        }
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
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("As datas de check-in e check-out devem ser futuras.");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("A data de check-out deve ser posterior à data de check-in.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return
                "numeroDoQuarto: " + numeroDoQuarto +
                ", checkIn: " + sdf.format(checkIn) +
                ", checkOut: " + sdf.format(checkOut) + "," + duracao() + " noites";
    }
}
