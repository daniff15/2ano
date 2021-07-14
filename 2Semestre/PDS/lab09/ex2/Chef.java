package lab09.ex2;

public abstract class Chef{

    private Chef proximo = null;

    public void request(String plate){
        if(proximo != null){
            proximo.request(plate);
        }
        else{
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }   
    }

    protected boolean canHandlePlate(String plate , String format){
        return (plate == null) || ((plate.toLowerCase()).contains(format.toLowerCase()));
    }

    public Chef setProximo(Chef proximo) {
        this.proximo = proximo;
        return this;
    }

}