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
		//this.factoria=factoria;
	}

	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarUnaLinea(es.avalon.negocio.LineaFacturaPK)
	 */
	public LineaFactura buscarUnaLinea(LineaFacturaPK clave) {
		return repositorioLinea.buscarLinea(clave);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarLinea(es.avalon.negocio.LineaFactura)
	 */
	public void borrarLinea(LineaFactura LineaFactura) {
		repositorioLinea.borrar(LineaFactura);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertarLinea(es.avalon.negocio.LineaFactura)
	 */
	public void insertarLinea(LineaFactura LineaFactura) {
		repositorioLinea.insertar(LineaFactura);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarLinea(es.avalon.negocio.LineaFactura)
	 */
	public void actualizarLinea(LineaFactura LineaFactura) {
		repositorioLinea.actualizar(LineaFactura);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientes()
	 */
	public List<Cliente> buscarTodosClientes() {
		return repositorioCliente.buscarTodos();
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorNombre(java.lang.String)
	 */
	public List<Cliente> buscarTodosClientesPorNombre(String nombre) {
		return repositorioCliente.buscarPorNombre(nombre);
		
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorNombreApellidos(java.lang.String, java.lang.String)
	 */
	public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.buscarPorNombreYApellido(nombre, apellidos);
		
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarCliente(java.lang.String)
	 */
	public Cliente buscarCliente(String dni) {
		return repositorioCliente.buscarUno(dni);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarCliente(es.avalon.negocio.Cliente)
	 */
	public void borrarCliente(Cliente cliente) {
		repositorioCliente.borrar(cliente);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertarCliente(es.avalon.negocio.Cliente)
	 */
	public void insertarCliente(Cliente cliente) {
		repositorioCliente.insertar(cliente);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarCliente(es.avalon.negocio.Cliente)
	 */
	public void actualizarCliente(Cliente cliente) {
		repositorioCliente.actualizar(cliente);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#OrdenarClientesPor(java.lang.String)
	 */
	public List<Cliente> OrdenarClientesPor(String campo) {
		return repositorioCliente.buscarTodosPor(campo);
	}

	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorApellido(java.lang.String)
	 */
	public List<Cliente> buscarTodosClientesPorApellido(String apellido) {
		return repositorioCliente.buscarPorApellido(apellido);
	}

	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineas()
	 */
	public List<Factura> buscarTodosFacturasConLineas() {
		return repositorioFactura.buscarTodosConLineas();
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineasOrdenadas()
	 */
	public List<Factura> buscarTodosFacturasConLineasOrdenadas() {
		return repositorioFactura.buscarTodosConLineasOrdenadas();
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasPor(java.lang.String)
	 */
	public List<Factura> buscarTodosFacturasPor(String campo) {
		return repositorioFactura.buscarTodosPor(campo);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#filtrarFacturaPor(java.lang.String, java.lang.String)
	 */
	public List<Factura> filtrarFacturaPor(String tipo, String valor) {
		return repositorioFactura.filtrarPor(tipo, valor);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarUnaFactura(int)
	 */
	public Factura buscarUnaFactura(int numero) {
		return repositorioFactura.buscarUna(numero);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarFactura(es.avalon.negocio.Factura)
	 */
	public void borrarFactura(Factura factura) {
		repositorioFactura.borrar(factura);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertarFactura(es.avalon.negocio.Factura)
	 */
	public void insertarFactura(Factura factura) {
		repositorioFactura.insertar(factura);
	}
	
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarFactura(es.avalon.negocio.Factura)
	 */
	public void actualizarFactura(Factura factura) {
		repositorioFactura.actualizar(factura);
	}
	
	
}
