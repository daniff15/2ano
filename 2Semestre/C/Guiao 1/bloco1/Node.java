import java.util.Deque;

public class Node {
    
    String val;
    Node left, right;


    public String consume(Deque<String> dq){

        this.val = dq.removeFirst();
        System.out.println(this.val);

        String result;
        if (this.val.matches("[+*/-]")){ //operador
            this.left = new Node();
            result = this.left.consume(dq);

            //verificar se result é null ou n
            this.right = new Node();
            String temp = this.right.consume(dq);
            String operation = "(" + result + " " + this.val + " " + temp + ")";
            return operation;
        }
        return this.val;

        //verificar se tem length 2
        //se tiver 1 -> null
        //se tiver 2 -> s[1]
    }

    public String getNodeVal() {
        return this.val;
    }

    public void setNodeVal(String val){
        this.val = val;
    }

}