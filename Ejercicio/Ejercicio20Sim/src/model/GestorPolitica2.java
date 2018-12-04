package model;

public class GestorPolitica2 extends Gestor {



    public void calcularRandomDemora()
    {
        if(getStockRemanente()<= 5 && !isEnCamino() )
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

    public void calcularDemora()
    {
        if(getRandomDemora()==0 && isEnCamino())
        {
            if(getDemora()>0)
            {
                setDemora(getDemora()-1);
                if(getDemora()==0)
                {
                    setStockDisponible(15);
                    setEnCamino(false);
                }
            }
        }else if(getRandomDemora()<0.1 && getRandomDemora()>0 )
        {
            setDemora(0);
            setStockDisponible(15);
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


}
