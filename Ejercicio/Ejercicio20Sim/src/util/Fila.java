package util;

import javafx.beans.property.SimpleStringProperty;

public class Fila {
    private final SimpleStringProperty dia;
    private final SimpleStringProperty semana;
    private final SimpleStringProperty random1;
    private final SimpleStringProperty demanda;
    private final SimpleStringProperty venta;
    private final SimpleStringProperty stockRemanente;
    private final SimpleStringProperty almacenamiento;
    private final SimpleStringProperty almacenamientoAcumulado;
    private final SimpleStringProperty pedido;
    private final SimpleStringProperty pedidoAcumulado;
    private final SimpleStringProperty agotamiento;
    private final SimpleStringProperty agotamientoAcumulado;
    private final SimpleStringProperty random2;
    private final SimpleStringProperty demora;
    private final SimpleStringProperty stockDisponible;
    private final SimpleStringProperty diaAgotamiento1;
    private final SimpleStringProperty diaAgotamiento2;
    private final SimpleStringProperty diaAgotamiento3;
    private final SimpleStringProperty diaAgotamiento4;
    private final SimpleStringProperty diaAgotamiento5;
    private final SimpleStringProperty diaAgotamiento6;
    private final SimpleStringProperty diaAgotamiento7;



    public Fila(String dia, String semana, String random1, String demanda, String venta, String stockRemanente,
                String almacenamiento,String almacenamientoAcumulado,
                String pedido,String pedidoAcumulado, String agotamiento,
                String agotamientoAcumulado, String random2, String demora, String stockDisponible, String diaAgotamiento1
            , String diaAgotamiento2, String diaAgotamiento3, String diaAgotamiento4, String diaAgotamiento5, String diaAgotamiento6
            , String diaAgotamiento7)
    {
        this.dia=new SimpleStringProperty(dia);
        this.semana=new SimpleStringProperty(semana);
        this.random1=new SimpleStringProperty(random1);
        this.demanda=new SimpleStringProperty(demanda);
        this.venta= new SimpleStringProperty(venta);
        this.stockRemanente= new SimpleStringProperty(stockRemanente);
        this.almacenamiento= new SimpleStringProperty(almacenamiento);
        this.almacenamientoAcumulado=new SimpleStringProperty(almacenamientoAcumulado);
        this.pedido= new SimpleStringProperty(pedido);
        this.pedidoAcumulado= new SimpleStringProperty(pedidoAcumulado);
        this.agotamiento= new SimpleStringProperty(agotamiento);
        this.agotamientoAcumulado = new SimpleStringProperty(agotamientoAcumulado);
        this.random2= new SimpleStringProperty(random2);
        this.demora= new SimpleStringProperty(demora);
        this.stockDisponible= new SimpleStringProperty(stockDisponible);
        this.diaAgotamiento1= new SimpleStringProperty(diaAgotamiento1);
        this.diaAgotamiento2= new SimpleStringProperty(diaAgotamiento2);
        this.diaAgotamiento3= new SimpleStringProperty(diaAgotamiento3);
        this.diaAgotamiento4= new SimpleStringProperty(diaAgotamiento4);
        this.diaAgotamiento5= new SimpleStringProperty(diaAgotamiento5);
        this.diaAgotamiento6= new SimpleStringProperty(diaAgotamiento6);
        this.diaAgotamiento7= new SimpleStringProperty(diaAgotamiento7);


    }

    public String getSemana() {
        return semana.get();
    }

    public SimpleStringProperty semanaProperty() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana.set(semana);
    }

    public String getRandom1() {
        return random1.get();
    }

    public SimpleStringProperty random1Property() {
        return random1;
    }

    public void setRandom1(String random1) {
        this.random1.set(random1);
    }

    public String getDemanda() {
        return demanda.get();
    }

    public SimpleStringProperty demandaProperty() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda.set(demanda);
    }

    public String getVenta() {
        return venta.get();
    }

    public SimpleStringProperty ventaProperty() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta.set(venta);
    }

    public String getStockRemanente() {
        return stockRemanente.get();
    }

    public SimpleStringProperty stockRemanenteProperty() {
        return stockRemanente;
    }

    public void setStockRemanente(String stockRemanente) {
        this.stockRemanente.set(stockRemanente);
    }

    public String getAlmacenamiento() {
        return almacenamiento.get();
    }

    public SimpleStringProperty almacenamientoProperty() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento.set(almacenamiento);
    }

    public String getPedido() {
        return pedido.get();
    }

    public SimpleStringProperty pedidoProperty() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido.set(pedido);
    }

    public String getAgotamiento() {
        return agotamiento.get();
    }

    public SimpleStringProperty agotamientoProperty() {
        return agotamiento;
    }

    public void setAgotamiento(String agotamiento) {
        this.agotamiento.set(agotamiento);
    }

    public String getRandom2() {
        return random2.get();
    }

    public SimpleStringProperty random2Property() {
        return random2;
    }

    public void setRandom2(String random2) {
        this.random2.set(random2);
    }

    public String getDemora() {
        return demora.get();
    }

    public SimpleStringProperty demoraProperty() {
        return demora;
    }

    public void setDemora(String demora) {
        this.demora.set(demora);
    }

    public String getStockDisponible() {
        return stockDisponible.get();
    }

    public SimpleStringProperty stockDisponibleProperty() {
        return stockDisponible;
    }

    public void setStockDisponible(String stockDisponible) {
        this.stockDisponible.set(stockDisponible);
    }

    public String getDia() {
        return dia.get();
    }

    public SimpleStringProperty diaProperty() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }

    public String getAlmacenamientoAcumulado() {
        return almacenamientoAcumulado.get();
    }

    public SimpleStringProperty almacenamientoAcumuladoProperty() {
        return almacenamientoAcumulado;
    }

    public void setAlmacenamientoAcumulado(String almacenamientoAcumulado) {
        this.almacenamientoAcumulado.set(almacenamientoAcumulado);
    }

    public String getPedidoAcumulado() {
        return pedidoAcumulado.get();
    }

    public SimpleStringProperty pedidoAcumuladoProperty() {
        return pedidoAcumulado;
    }

    public void setPedidoAcumulado(String pedidoAcumulado) {
        this.pedidoAcumulado.set(pedidoAcumulado);
    }

    public String getAgotamientoAcumulado() {
        return agotamientoAcumulado.get();
    }

    public SimpleStringProperty agotamientoAcumuladoProperty() {
        return agotamientoAcumulado;
    }

    public void setAgotamientoAcumulado(String agotamientoAcumulado) {
        this.agotamientoAcumulado.set(agotamientoAcumulado);
    }

    public String getDiaAgotamiento1() {
        return diaAgotamiento1.get();
    }

    public SimpleStringProperty diaAgotamiento1Property() {
        return diaAgotamiento1;
    }

    public void setDiaAgotamiento1(String diaAgotamiento1) {
        this.diaAgotamiento1.set(diaAgotamiento1);
    }

    public String getDiaAgotamiento2() {
        return diaAgotamiento2.get();
    }

    public SimpleStringProperty diaAgotamiento2Property() {
        return diaAgotamiento2;
    }

    public void setDiaAgotamiento2(String diaAgotamiento2) {
        this.diaAgotamiento2.set(diaAgotamiento2);
    }

    public String getDiaAgotamiento3() {
        return diaAgotamiento3.get();
    }

    public SimpleStringProperty diaAgotamiento3Property() {
        return diaAgotamiento3;
    }

    public void setDiaAgotamiento3(String diaAgotamiento3) {
        this.diaAgotamiento3.set(diaAgotamiento3);
    }

    public String getDiaAgotamiento4() {
        return diaAgotamiento4.get();
    }

    public SimpleStringProperty diaAgotamiento4Property() {
        return diaAgotamiento4;
    }

    public void setDiaAgotamiento4(String diaAgotamiento4) {
        this.diaAgotamiento4.set(diaAgotamiento4);
    }

    public String getDiaAgotamiento5() {
        return diaAgotamiento5.get();
    }

    public SimpleStringProperty diaAgotamiento5Property() {
        return diaAgotamiento5;
    }

    public void setDiaAgotamiento5(String diaAgotamiento5) {
        this.diaAgotamiento5.set(diaAgotamiento5);
    }

    public String getDiaAgotamiento6() {
        return diaAgotamiento6.get();
    }

    public SimpleStringProperty diaAgotamiento6Property() {
        return diaAgotamiento6;
    }

    public void setDiaAgotamiento6(String diaAgotamiento6) {
        this.diaAgotamiento6.set(diaAgotamiento6);
    }

    public String getDiaAgotamiento7() {
        return diaAgotamiento7.get();
    }

    public SimpleStringProperty diaAgotamiento7Property() {
        return diaAgotamiento7;
    }

    public void setDiaAgotamiento7(String diaAgotamiento7) {
        this.diaAgotamiento7.set(diaAgotamiento7);
    }
}
