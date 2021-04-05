import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/* POLISH NOTATION CALCULATOR
echo "- + 2 * 40 3 / 15 5" | java ex7
echo "+ 2 * 3 4" | java ex7
echo "+ 2 8" | java ex7
*/


public class G1E7 {

    public static void main(String args[]) throws ScriptException{

        Scanner sc = new Scanner(System.in);
        Deque<String> dq = new ArrayDeque<String>();
        while (sc.hasNext()) dq.add(sc.next());
        sc.close();
        Node nd = new Node();
        String str = nd.consume(dq);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(str);
        System.out.println(result);
    }
}