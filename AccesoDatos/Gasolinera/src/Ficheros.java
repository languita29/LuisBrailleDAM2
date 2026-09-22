public interface Ficheros {
    public Collection<PagosDeRepostajes> leerPagos();
    public Collection<Clientes> leerClientes();
    public boolean  guardarCliente(Clientes c1);
    public boolean guardarPagos(PagosDeRepostajes p1);

}
