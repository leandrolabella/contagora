package br.com.devleo.contagora.models.enums;

public enum PaymentStatus {

    WAITING_PAYMENT(1), //Aguardando pagamento
    PAYING(2), //Pagando
    PAID(3), //Pago
    CANCELED(4); //Cancelado

    private int code;

    private PaymentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PaymentStatus valueOf(int code) {
        for (PaymentStatus i : PaymentStatus.values()) {
            if (i.getCode() == code)
                return i;
        }
        throw new IllegalArgumentException("Argumento inválido.");
    }

}
