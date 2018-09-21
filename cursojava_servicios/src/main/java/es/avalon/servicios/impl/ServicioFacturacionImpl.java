package es.avalon.servicios.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.Cliente;
import es.avalon.Factura;
import es.avalon.LineaFactura;
import es.avalon.LineaFacturaPK;
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

	
	
	//lineasFactura
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarUnaLinea(es.avalon.LineaFacturaPK)
	 */
	public LineaFactura buscarUnaLinea(LineaFacturaPK clave) {
		return repositorioLinea.buscarUna(clave);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarLinea(es.avalon.LineaFactura)
	 */
	public void borrarLinea(LineaFactura LineaFactura) {
		repositorioLinea.borrar(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertar(es.avalon.LineaFactura)
	 */
	public void insertar(LineaFactura LineaFactura) {
		repositorioLinea.insertar(LineaFactura);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarLinea(es.avalon.LineaFactura)
	 */
	public void actualizarLinea(LineaFactura LineaFactura) {
		repositorioLinea.actualizar(LineaFactura);
	}
	
	
	
	//clientes
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
		return repositorioCliente.buscarNombre(nombre);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosClientesPorNombreApellidos(java.lang.String, java.lang.String)
	 */
	public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.filtrarPorNombreApellido(nombre, apellidos);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarCliente(java.lang.String)
	 */
	public Cliente buscarCliente(String dni) {
		return repositorioCliente.buscarDni(dni);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarCliente(es.avalon.Cliente)
	 */
	public void borrarCliente(Cliente cliente) {
		repositorioCliente.borrar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertarCliente(es.avalon.Cliente)
	 */
	public void insertarCliente(Cliente cliente) {
		repositorioCliente.insertar(cliente);
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarCliente(es.avalon.Cliente)
	 */
	public void actualizarCliente(Cliente cliente) {
		repositorioCliente.actualizar(cliente);
	}
	
	
	
	//facturas
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineas()
	 */
	public List<Factura> buscarTodosFacturasConLineas() {
		return repositorioFactura.buscarTodosConLinea();
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#buscarTodosFacturasConLineasOrdenadas()
	 */
	public List<Factura> buscarTodosFacturasConLineasOrdenadas() {
		return repositorioFactura.buscarTodosConLineaOrdenadas();
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
	 * @see es.avalon.servicios.impl.ServicioFacturacion#borrarFactura(es.avalon.Factura)
	 */
	public void borrarFactura(Factura factura) {
		EntityManager em = factoria.createEntityManager();
		repositorioFactura= new FacturaRepositorioJPA(em);
		em.getTransaction().begin();
			
		repositorioFactura.borrar(factura);
		em.getTransaction().commit();
		
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#insertar(es.avalon.Factura)
	 */
	public void insertar(Factura factura) {
		
		EntityManager em = factoria.createEntityManager();
		repositorioFactura= new FacturaRepositorioJPA(em);
		em.getTransaction().begin();
		repositorioFactura.insertar(factura);
		em.getTransaction().commit();
		//em.close();
		
	}
	/* (non-Javadoc)
	 * @see es.avalon.servicios.impl.ServicioFacturacion#actualizarFactura(es.avalon.Factura)
	 */
	public void actualizarFactura(Factura factura) {
		
		
		
		EntityManager em = factoria.createEntityManager();
		repositorioFactura= new FacturaRepositorioJPA(em);
		em.getTransaction().begin();
		repositorioFactura.actualizar(factura);	
	
		em.getTransaction().commit();
		
	}

	public List<Factura> buscarTodos() {
		return repositorioFactura.buscarTodos();
		
	}
	
	
	
}
