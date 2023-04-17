package com.mavenproject.course.entities.enums;

public enum OrderStatus {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int cod;

    private OrderStatus(int cod){
        this.cod = cod;
    }

    public int getCod(){
        return cod;
    }

    public static OrderStatus valueOf(int cod){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCod() == cod){
                return value;
            }
        }
        throw new IllegalArgumentException("Código inválido!");
    }
}
