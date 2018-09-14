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
import es.avalon.repositorios.jpa.LineaFacturaRepositorioJPA;

public class ServicioFacturacionImpl implements ServicioFacturacion  {

	private FacturaRepositorio repositorioFactura;
	private LineaFacturaRepositorio repositorioLinea;
	private ClienteRepositorio repositorioCliente;
	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("UnidadFacturas");
	
	public ServicioFacturacionImpl() {
		super();
		this.repositorioFactura = new FacturaRepositorioJPA(factoria.createEntityManager());
		this.repositorioLinea = new LineaFacturaRepositorioJPA(factoria.createEntityManager());
		this.repositorioCliente = new ClienteRepositorioJPA(factoria.createEntityManager());
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarUnaLinea(es.avalon.negocio.LineaFacturaPK)
	 */
	@Override
	public LineaFactura buscarLineaFactura(LineaFacturaPK clave) {
		return repositorioLinea.buscarLineaFactura(clave);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarLinea(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void borrarLineaFactura(LineaFactura LineaFactura) {
		repositorioLinea.borrarLineaFactura(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertar(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void insertarLineaFactura(LineaFactura LineaFactura) {
		repositorioLinea.insertarLineaFactura(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarLinea(es.avalon.negocio.LineaFactura)
	 */
	@Override
	public void actualizarLineaFactura(LineaFactura LineaFactura) {
		repositorioLinea.actualizarLineaFactura(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientes()
	 */
	@Override
	public List<Cliente> buscarClientesTodos() {
		return repositorioCliente.buscarTodos();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorNombre(java.lang.String)
	 */
	@Override
	public List<Cliente> buscarClientesPorNombre(String nombre) {
		return repositorioCliente.buscarNombre(nombre);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorNombreApellidos(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Cliente> buscarClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.buscarNombreApellidos(nombre, apellidos);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarCliente(java.lang.String)
	 */
	@Override
	public Cliente buscarClienteDni(String dni) {
		return repositorioCliente.buscarDni(dni);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void borrarCliente(Cliente cliente) {
		repositorioCliente.borrar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void insertarCliente(Cliente cliente) {
		repositorioCliente.insertar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarCliente(es.avalon.negocio.Cliente)
	 */
	@Override
	public void actualizarCliente(Cliente cliente) {
		repositorioCliente.actualizar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineas()
	 */
	@Override
	public List<Factura> buscarFacturasConLineasTodas() {
		return repositorioFactura.buscarTodosConLineas();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineas()
	 */
	@Override
	public List<Factura> buscarFacturasTodas() {
		return repositorioFactura.buscarTodos();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineasOrdenadas()
	 */
	@Override
	public List<Factura> buscarFacturasConLineasOrdenadasTodas() {
		return repositorioFactura.buscarTodosConLineas();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasPor(java.lang.String)
	 */
	@Override
	public List<Factura> ordenarFacturas(String campo) {
		return repositorioFactura.ordenar(campo);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#filtrarFacturaPor(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Factura> filtrarFacturaPor(String tipo, String valor) {
		return repositorioFactura.filtrarPor(tipo, valor);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarUnaFactura(int)
	 */
	@Override
	public Factura buscarFactura(int numero) {
		return repositorioFactura.buscarUna(numero);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarFactura(es.avalon.negocio.Factura)
	 */
	@Override
	public void borrarFactura(Factura factura) {
		repositorioFactura.borrar(factura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertar(es.avalon.negocio.Factura)
	 */
	@Override
	public void insertarFactura(Factura factura) {
		repositorioFactura.insertar(factura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarFactura(es.avalon.negocio.Factura)
	 */
	@Override
	public void actualizarFactura(Factura factura) {
		repositorioFactura.actualizar(factura);
	}
	
	
}
