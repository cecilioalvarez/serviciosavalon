package es.avalon.servicios.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.LineaFactura;
import es.avalon.negocio.LineaFacturaPK;
import es.avalon.repositorios.ClienteRepositorio;
import es.avalon.repositorios.FacturaRepositorio;
import es.avalon.repositorios.LineaFacturaRepositorio;
import es.avalon.repositorios.jpa.ClienteRepositorioJPA;
import es.avalon.repositorios.jpa.FacturaRepositorioJPA;
import es.avalon.repositorios.jpa.LineaFacturaJPA;

public class ServicioFacturacionImpl implements ServivioFacturacion  {

	private FacturaRepositorio repositorioFactura;
	private LineaFacturaRepositorio repositorioLinea;
	private ClienteRepositorio repositorioCliente;
	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("UnidadFacturas");

	
	public ServicioFacturacionImpl() {
		super();
		this.repositorioFactura = new FacturaRepositorioJPA(factoria.createEntityManager());
		this.repositorioLinea = new LineaFacturaJPA(factoria.createEntityManager());
		this.repositorioCliente = new ClienteRepositorioJPA(factoria.createEntityManager());
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarUnaLinea(es.avalon.negocio.LineaFacturaPK)
	 */
	@Override
	public LineaFactura buscarUnaLinea(LineaFacturaPK clave) {
		return repositorioLinea.buscarUna(clave);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#borrarLinea(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void borrarLinea(LineaFactura LineaFactura) {
		repositorioLinea.borrar(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#insertar(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void insertar(LineaFactura LineaFactura) {
		repositorioLinea.insertar(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#actualizarLinea(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void actualizarLinea(LineaFactura LineaFactura) {
		repositorioLinea.actualizar(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarTodosClientes()
	 */
	@Override
	public List<Cliente> buscarTodosClientes() {
		return repositorioCliente.buscarTodos();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarTodosClientesPorNombre(java.lang.String)
	 */
	@Override
	public List<Cliente> buscarTodosClientesPorNombre(String campo) {
		return repositorioCliente.buscarTodosPor(campo);
	}
	/*public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.busc(nombre, apellidos);
	}*/
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarCliente(java.lang.String)
	 */
	@Override
	public Cliente buscarCliente(String dni) {
		return repositorioCliente.buscarUno(dni);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#borrarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void borrarCliente(Cliente cliente) {
		repositorioCliente.borrar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#insertarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void insertarCliente(Cliente cliente) {
		repositorioCliente.insertar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#actualizarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void actualizarCliente(Cliente cliente) {
		repositorioCliente.actualizar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarTodosFacturasConLineas()
	 */
	@Override
	public List<Factura> buscarTodosFacturasConLineas() {
		return repositorioFactura.buscarTodosConLineas();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarTodosFacturasConLineasOrdenadas()
	 */
	@Override
	public List<Factura> buscarTodosFacturasConLineasOrdenadas() {
		return repositorioFactura.buscarTodosLineasOrdenadas();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarTodosFacturasPor(java.lang.String)
	 */
	@Override
	public List<Factura> buscarTodosFacturasPor(String campo) {
		return repositorioFactura.buscarTodosPor(campo);
	}
	@Override
	public List<Factura> buscarTodosFacturas() {
		return repositorioFactura.buscarTodos();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#filtrarFacturaPor(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Factura> filtrarFacturaPor(String tipo, String valor) {
		return repositorioFactura.filtrarPor(tipo, valor);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#buscarUnaFactura(int)
	 */
	@Override
	public Factura buscarUnaFactura(int numero) {
		return repositorioFactura.buscarUna(numero);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#borrarFactura(es.avalon.negocio.Factura)
	 */
	@Override
	public void borrarFactura(Factura factura) {
		repositorioFactura.borrar(factura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#insertar(es.avalon.negocio.Factura)
	 */
	@Override
	public void insertar(Factura factura) {
		repositorioFactura.insertar(factura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServivioFacturacion#actualizarFactura(es.avalon.negocio.Factura)
	 */
	@Override
	public void actualizarFactura(Factura factura) {
		repositorioFactura.actualizar(factura);
	}
	
	
}
