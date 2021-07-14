public class ICamperMode implements ICamper {

    private int lugares;
    private String descricao;
    private Estado estado;

    public ICamperMode(int lugares, String descricao) {
        this.lugares = lugares;
        this.descricao = descricao;
    }

    @Override
    public void setEstado(Estado e){
        estado = e;
    }

    @Override
	public Estado getEstado(){
        return estado;
    }

    @Override
	public int getMaxLugares(){
        return lugares;
    }

    @Override
	public String getDescricao(){
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + lugares;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ICamperMode other = (ICamperMode) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (lugares != other.lugares)
            return false;
        return true;
    }

}
