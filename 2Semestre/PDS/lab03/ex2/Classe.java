package lab03.ex2;

public enum Classe {
    E, T;

    public static Classe getEnum(String string) {
        switch(string){
            case("T"):
            return T;
            default:
            return E;
        }
    }

    public static String getString(Classe classe){
        if (classe == Classe.T) 
            return "T";
        else
            return "E";
    }
}
