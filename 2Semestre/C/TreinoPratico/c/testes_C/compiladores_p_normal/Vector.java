import java.util.ArrayList;
import java.util.List;

public class Vector {

    private ArrayList<Double> numeros =  new ArrayList<>();
    
    public Vector(Double number) {
        numeros.add(number);
    }

    public void addToArray(Double number){
        numeros.add(number);
    }

    public Vector sum(Vector array){
        int lengthThis = this.numeros.size();
        int lengthArray = array.numeros.size(); 
        Vector arrayzinhoSums = null;

        if (lengthThis != lengthArray) {
            System.err.println("ERRO: Vector don't have the same size!");
            System.exit(1);
        }
        
        double soma = 0;
        for (int i = 0; i < lengthThis; i++) {
            soma = this.numeros.get(i) + array.numeros.get(i);
            if (i == 0) {
                arrayzinhoSums = new Vector(soma);
            }

            else{
                arrayzinhoSums.addToArray(soma);
            }
        }
 
        return arrayzinhoSums;

    }

    public Vector sub(Vector array){
        int lengthThis = this.numeros.size();
        int lengthArray = array.numeros.size(); 
        Vector arrayzinhoSums = null;

        if (lengthThis != lengthArray) {
            System.err.println("ERRO: Vector don't have the same size!");
            System.exit(1);
        }
        
        double sub = 0;
        for (int i = 0; i < lengthThis; i++) {
            sub = this.numeros.get(i) - array.numeros.get(i);
            if (i == 0) {
                arrayzinhoSums = new Vector(sub);
            }

            else{
                arrayzinhoSums.addToArray(sub);
            }
        }
 
        return arrayzinhoSums;

    }


    public Vector unario(){
        Vector result = null;
        for (int i = 0; i < this.numeros.size(); i++) {
            if (i == 0) {
                result = new Vector(this.numeros.get(i) * -1);
            }
            else{
                result.addToArray(this.numeros.get(i) * -1);
            }
        }

        return result;
    }

    public Vector internProdut(Vector array){

        if (this.numeros.size() != array.numeros.size()) {
            System.err.println("ERROR: Vector not the same size!!");
            System.exit(1);
        }

        double soma = 0;

        for (int i = 0; i < this.numeros.size(); i++) {
            soma += this.numeros.get(i) * array.numeros.get(i);
        }

        return new Vector(soma);


    }

    public Vector multi(Vector vec){
        Vector result = null;
        if (this.numeros.size() != 1) {
            System.err.println("ERROR: First number needs to be a Scalar");
            System.exit(1);
        }

        for (int i = 0; i < vec.numeros.size(); i++) {
            if (i == 0) {
                result = new Vector(vec.numeros.get(i) * this.numeros.get(0));
            }
            else {
                result.addToArray(vec.numeros.get(i) * this.numeros.get(0));
            }
        }

        return result;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numeros.size(); i++) {

            if (i != numeros.size() - 1) {
                sb.append(numeros.get(i) + ",");
            } else {
                sb.append(numeros.get(i));
            }
        }

        sb.append("]");

        return sb.toString();
    }

}
