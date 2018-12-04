package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.Fila;

public class Gestor {

    private ObservableList<Fila> data;
    private double vectorActual[];
    private double vectorAnterior[];
    private int dia;
    private int semana;
    private double randomVenta;
    private int venta;
    private int demanda;
    private int stockRemanente;
    private int almacenamiento;
    private int pedido;
    private int agotamiento;
    private double randomDemora;
    private int demora;
    private int stockDisponible;
    private boolean enCamino;
    private int almacenamientoAcumulado;
    private int pedidoAcumulado;
    private int agotamientoAcumulado;
    private int semanasAsimular;
    private int diaDesde;
    private int diaHasta;
    private int diaAgotamiento1;
    private int diaAgotamiento2;
    private int diaAgotamiento3;
    private int diaAgotamiento4;
    private int diaAgotamiento5;
    private int diaAgotamiento6;
    private int diaAgotamiento7;



    public Gestor( ) {
        this.data= FXCollections.observableArrayList();
        this.vectorActual=new double[16];
        this.vectorAnterior=null;
        this.dia = 0;
        this.semana = 0;
        this.randomVenta = 0;
        this.venta = 0;
        this.demanda = 0;
        this.stockRemanente = 0;
        this.almacenamiento = 0;
        this.almacenamientoAcumulado=0;
        this.pedido = 0;
        this.pedidoAcumulado=0;
        this.agotamiento = 0;
        this.agotamientoAcumulado=0;
        this.randomDemora = 0;
        this.demora = 0;
        this.stockDisponible = 0;
        this.semanasAsimular=16;
        this.diaAgotamiento1=0;
        this.diaAgotamiento2=0;
        this.diaAgotamiento3=0;
        this.diaAgotamiento4=0;
        this.diaAgotamiento5=0;
        this.diaAgotamiento6=0;
        this.diaAgotamiento7=0;
    }

    public double[] getVectorActual() {
        return vectorActual;
    }

    public void setVectorActual(double[] vectorActual) {
        this.vectorActual = vectorActual;
    }

    public double[] getVectorAnterior() {
        return vectorAnterior;
    }

    public void setVectorAnterior(double[] vectorAnterior) {
        this.vectorAnterior = vectorAnterior;
    }

    public void limpiarVectores()
    {
        this.vectorActual=new double[16];
        this.vectorAnterior = null;
    }



    public void newVectorActual()
    {
        if(getVectorAnterior()==null)
        {

            this.setSemana(0);
            this.setDia(0);
            this.setStockRemanente(12);

            vectorActual = new double[22];
            vectorActual[0]=getDia();
            vectorActual[1]=getSemana();
            vectorActual[2]=getRandomVenta();
            vectorActual[3]=getDemanda();
            vectorActual[4]=getVenta();
            vectorActual[5]=getStockRemanente();
            vectorActual[6]=getAlmacenamiento();
            vectorActual[7]=getPedido();
            vectorActual[8]=getAgotamiento();
            vectorActual[9]=getRandomDemora();
            vectorActual[10]=getDemora();
            vectorActual[11]=getStockDisponible();
            vectorActual[12]=getAlmacenamientoAcumulado();
            vectorActual[13]=getPedidoAcumulado();
            vectorActual[14]=getAgotamientoAcumulado();
            vectorActual[15]=getDiaAgotamiento1();
            vectorActual[16]=getDiaAgotamiento2();
            vectorActual[17]=getDiaAgotamiento3();
            vectorActual[18]=getDiaAgotamiento4();
            vectorActual[19]=getDiaAgotamiento5();
            vectorActual[20]=getDiaAgotamiento6();
            vectorActual[21]=getDiaAgotamiento7();

            vectorAnterior=vectorActual;

        }else{

            this.calcularSemana();
            this.calcularDia();
            this.calcularRandomVenta();
            this.calcularDemanda();
            this.calcularVenta();
            this.calcularStockRemanente();
            this.calcularRandomDemora();
            this.calcularDemora();
            this.calcularAlmacenamiento();
            this.calcularPedido();
            this.calcularDiasAgotamiento();
            this.calcularCostosAcumulados();


            vectorActual =new double[22];
            vectorActual[0]=getDia();
            vectorActual[1]=getSemana();
            vectorActual[2]=getRandomVenta();
            vectorActual[3]=getDemanda();
            vectorActual[4]=getVenta();
            vectorActual[5]=getStockRemanente();
            vectorActual[6]=getAlmacenamiento();
            vectorActual[7]=getPedido();
            vectorActual[8]=getAgotamiento();
            vectorActual[9]=getRandomDemora();
            vectorActual[10]=getDemora();
            vectorActual[11]=getStockDisponible();
            vectorActual[12]=getAlmacenamientoAcumulado();
            vectorActual[13]=getPedidoAcumulado();
            vectorActual[14]=getAgotamientoAcumulado();
            vectorActual[15]=getDiaAgotamiento1();
            vectorActual[16]=getDiaAgotamiento2();
            vectorActual[17]=getDiaAgotamiento3();
            vectorActual[18]=getDiaAgotamiento4();
            vectorActual[19]=getDiaAgotamiento5();
            vectorActual[20]=getDiaAgotamiento6();
            vectorActual[21]=getDiaAgotamiento7();




            vectorAnterior=vectorActual;
        }
        if(getDia()>= getDiaDesde() && getDia()<=getDiaHasta()){
            this.cargarFila();
        }

    }

    public void inicio()
    {
        while(getDia()< getSemanasAsimular()*7)
        {
            this.newVectorActual();
        }
    }


    public void calcularDia()
    {
        setDia(getDia()+1);
    }

    public void calcularSemana()
    {
        setSemana(cambioDeSemana());
    }


    public void calcularRandomVenta()
    {
         setRandomVenta(Math.random());
    }

    public void calcularRandomDemora()
    {
        if(getDia() % 7 == 0 && !isEnCamino() )
        {
            setRandomDemora(Math.random());
            setEnCamino(true);
            calcularDemora();
        }else
        {
            setRandomDemora(0);
            setStockDisponible(0);
        }
    }

    public int cambioDeSemana()
    {
        return  (getDia() / 7)+1;
    }

    public void calcularDemanda()
    {
        if(getRandomVenta()<0.05)
        {
            setDemanda(0);
        }else if(getRandomVenta()<0.25)
        {
            setDemanda(1);
        }else if(getRandomVenta()<0.65)
        {
            setDemanda(2);
        }else if(getRandomVenta()<0.8)
        {
            setDemanda(3);
        }else if(getRandomVenta()<0.9)
        {
            setDemanda(4);
        }else if(getRandomVenta()<0.95)
        {
            setDemanda(5);
        }else if(getRandomVenta()<0.1)
        {
            setDemanda(6);
        }
    }

    public void calcularDemora()
    {
        if(getRandomDemora()==0 && isEnCamino())
        {
            if(getDemora()>0)
            {
                setDemora(getDemora()-1);
                if(getDemora()==0)
                {
                    setStockDisponible(20);
                    setEnCamino(false);
                }
            }
        }else if(getRandomDemora()<0.1 && getRandomDemora()>0 )
        {
            setDemora(0);
            setStockDisponible(20);
            setEnCamino(false);
        }else if(getRandomDemora()<0.3 && getRandomDemora()!=0)
        {
            setDemora(1);
        }else if(getRandomDemora()<0.6 && getRandomDemora()!=0)
        {
            setDemora(2);
        }else if(getRandomDemora()<0.9 && getRandomDemora()!=0)
        {
            setDemora(3);
        }else if(getRandomDemora()<0.95 && getRandomDemora()!=0)
        {
            setDemora(4);
        }else if(getRandomDemora()<1 && getRandomDemora()!=0)
        {
            setDemora(5);
        }
    }

    public void calcularCostosAcumulados()
    {
        setAlmacenamientoAcumulado(getAlmacenamiento()+getAlmacenamientoAcumulado());
        setAgotamientoAcumulado(getAgotamiento()+getAgotamientoAcumulado());
        setPedidoAcumulado(getPedido()+getPedidoAcumulado());

    }
    public void calcularVenta()
    {
        if(getDemanda()<= getStockDisponible()+ getStockRemanente())
        {
            setVenta(getDemanda());
        }else
        {
            setVenta(getStockDisponible()+ getStockRemanente());
        }
    }

    public void calcularDiasAgotamiento()
    {
        setDiaAgotamiento1(getDemanda()-getVenta());
        setDiaAgotamiento2((int)vectorAnterior[15]);
        setDiaAgotamiento3((int)vectorAnterior[16]);
        setDiaAgotamiento4((int)vectorAnterior[17]);
        setDiaAgotamiento5((int)vectorAnterior[18]);
        setDiaAgotamiento6((int)vectorAnterior[19]);
        setDiaAgotamiento7((int)vectorAnterior[20]);
        setAgotamiento(getDiaAgotamiento7()*60);


    }

    public void calcularStockRemanente()
    {
        int stock=getStockDisponible()+getStockRemanente()- getVenta();
        setStockRemanente(stock);
    }

    public void calcularAlmacenamiento()
    {
        int almacenamiento=getStockRemanente()*12;
        setAlmacenamiento(almacenamiento);
    }

    public void calcularPedido()
    {
        int stockDisponible= (getStockDisponible()==0 ? 0 : 220);
        setPedido(stockDisponible);
    }


    public void cargarFila()
    {
        String diaContent=String.valueOf((int)vectorActual[0]);
        String semanaContent=String.valueOf((int)vectorActual[1]);
        String random1Content=String.valueOf(vectorActual[2]);
        String demandaContent=String.valueOf((int)vectorActual[3]);
        String ventaContent =String.valueOf((int)vectorActual[4]);
        String stockRemanenteContent =String.valueOf((int)vectorActual[5]);
        String almacenamientoContent=String.valueOf((int)vectorActual[6]);
        String pedidoContent=String.valueOf((int)vectorActual[7]);
        String agotamientoContent=String.valueOf((int)vectorActual[8]);
        String random2Content=String.valueOf(vectorActual[9]);
        String demoraContent=String.valueOf((int)vectorActual[10]);
        String stockDisponibleContent=String.valueOf((int)vectorActual[11]);
        String almacenamientoAcumuladoContent= String.valueOf((int)vectorActual[12]);
        String pedidoAcumuladoContent= String.valueOf((int)vectorActual[13]);
        String agotamientoAcumuladoContent= String.valueOf((int)vectorActual[14]);
        String diaAgotamiento1Content= String.valueOf((int)vectorActual[15]);
        String diaAgotamiento2Content= String.valueOf((int)vectorActual[16]);
        String diaAgotamiento3Content= String.valueOf((int)vectorActual[17]);
        String diaAgotamiento4Content= String.valueOf((int)vectorActual[18]);
        String diaAgotamiento5Content= String.valueOf((int)vectorActual[19]);
        String diaAgotamiento6Content= String.valueOf((int)vectorActual[20]);
        String diaAgotamiento7Content= String.valueOf((int)vectorActual[21]);


        data.add(new Fila(diaContent,semanaContent,random1Content,demandaContent,
                ventaContent,stockRemanenteContent, almacenamientoContent,almacenamientoAcumuladoContent, pedidoContent,
                pedidoAcumuladoContent, agotamientoContent,agotamientoAcumuladoContent, random2Content, demoraContent,stockDisponibleContent,
                diaAgotamiento1Content, diaAgotamiento2Content, diaAgotamiento3Content, diaAgotamiento4Content,
                diaAgotamiento5Content, diaAgotamiento6Content, diaAgotamiento7Content));
    }
    public int getDemora() {
        return demora;
    }

    public void setDemora(int demora) {
        this.demora = demora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public double getRandomVenta() {
        return randomVenta;
    }

    public void setRandomVenta(double randomVenta) {
        this.randomVenta = randomVenta;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    public int getStockRemanente() {
        return stockRemanente;
    }

    public void setStockRemanente(int stockRemanente) {
        this.stockRemanente = stockRemanente;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getAgotamiento() {
        return agotamiento;
    }

    public void setAgotamiento(int agotamiento) {
        this.agotamiento = agotamiento;
    }

    public double getRandomDemora() {
        return randomDemora;
    }

    public void setRandomDemora(double randomDemora) {
        this.randomDemora = randomDemora;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public ObservableList<Fila> getData() {
        return data;
    }

    public boolean isEnCamino() {
        return enCamino;
    }

    public void setEnCamino(boolean enCamino) {
        this.enCamino = enCamino;
    }

    public void setData(ObservableList<Fila> data) {
        this.data = data;
    }

    public int getAlmacenamientoAcumulado() {
        return almacenamientoAcumulado;
    }

    public void setAlmacenamientoAcumulado(int almacenamientoAcumulado) {
        this.almacenamientoAcumulado = almacenamientoAcumulado;
    }

    public int getPedidoAcumulado() {
        return pedidoAcumulado;
    }

    public void setPedidoAcumulado(int pedidoAcumulado) {
        this.pedidoAcumulado = pedidoAcumulado;
    }

    public int getAgotamientoAcumulado() {
        return agotamientoAcumulado;
    }

    public void setAgotamientoAcumulado(int agotamientoAcumulado) {
        this.agotamientoAcumulado = agotamientoAcumulado;
    }

    public int getSemanasAsimular() {
        return semanasAsimular;
    }

    public void setSemanasAsimular(int semanasAsimular) {
        this.semanasAsimular = semanasAsimular;
    }

    public int getDiaDesde() {
        return diaDesde;
    }

    public void setDiaDesde(int diaDesde) {
        this.diaDesde = diaDesde;
    }

    public int getDiaHasta() {
        return diaHasta;
    }

    public void setDiaHasta(int diaHasta) {
        this.diaHasta = diaHasta;
    }

    public int getDiaAgotamiento1() {
        return diaAgotamiento1;
    }

    public void setDiaAgotamiento1(int diaAgotamiento1) {
        this.diaAgotamiento1 = diaAgotamiento1;
    }

    public int getDiaAgotamiento2() {
        return diaAgotamiento2;
    }

    public void setDiaAgotamiento2(int diaAgotamiento2) {
        this.diaAgotamiento2 = diaAgotamiento2;
    }

    public int getDiaAgotamiento3() {
        return diaAgotamiento3;
    }

    public void setDiaAgotamiento3(int diaAgotamiento3) {
        this.diaAgotamiento3 = diaAgotamiento3;
    }

    public int getDiaAgotamiento4() {
        return diaAgotamiento4;
    }

    public void setDiaAgotamiento4(int diaAgotamiento4) {
        this.diaAgotamiento4 = diaAgotamiento4;
    }

    public int getDiaAgotamiento5() {
        return diaAgotamiento5;
    }

    public void setDiaAgotamiento5(int diaAgotamiento5) {
        this.diaAgotamiento5 = diaAgotamiento5;
    }

    public int getDiaAgotamiento6() {
        return diaAgotamiento6;
    }

    public void setDiaAgotamiento6(int diaAgotamiento6) {
        this.diaAgotamiento6 = diaAgotamiento6;
    }

    public int getDiaAgotamiento7() {
        return diaAgotamiento7;
    }

    public void setDiaAgotamiento7(int diaAgotamiento7) {
        this.diaAgotamiento7 = diaAgotamiento7;
    }
}
