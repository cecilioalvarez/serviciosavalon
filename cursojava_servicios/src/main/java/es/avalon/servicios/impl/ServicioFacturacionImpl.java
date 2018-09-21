package es.avalon.servicios.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.Linea;

import es.avalon.negocio.LineaFacturaPK;
import es.avalon.repositorios.ClienteRepositorio;
import es.avalon.repositorios.FacturaRepositorio;
import es.avalon.repositorios.jpa.ClienteRepositorioJPA;
import es.avalon.repositorios.jpa.FacturaRepositorioJPA;
import es.avalon.repositorios.jpa.LineaRepositorioJPA;

public class ServicioFacturacionImpl implements ServicioFacturacion  {

	private FacturaRepositorio repositorioFactura;
	private LineaRepositorioJPA repositorioLinea;
	private ClienteRepositorio repositorioCliente;
	
	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("UnidadFacturas");
	
	
	public ServicioFacturacionImpl() {
		super();
		this.repositorioFactura = new FacturaRepositorioJPA(factoria.createEntityManager());
		this.repositorioLinea = new LineaRepositorioJPA(factoria.createEntityManager());
		this.repositorioCliente = new ClienteRepositorioJPA(factoria.createEntityManager());
	}
	
	public Linea buscarUnaLinea(LineaFacturaPK clave) {
		return repositorioLinea.buscarUnaLinea(clave);
	}
	public void borrarLinea(Linea LineaFactura) {
		repositorioLinea.borrar(LineaFactura);
	}
	public void insertar(Linea LineaFactura) {
		repositorioLinea.insertar(LineaFactura);
	}
	public void actualizarLinea(Linea LineaFactura) {
		repositorioLinea.actualizar(LineaFactura);
	}
	public List<Cliente> buscarTodosClientes() {
		return repositorioCliente.buscarTodos();
	}
	public List<Cliente> buscarTodosClientesPorNombre(String nombre) {
		return repositorioCliente.buscarPorNombre(nombre);
	}
	public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.buscarPorNombreApellido(nombre, apellidos);
	}
	public Cliente buscarCliente(String dni) {
		return repositorioCliente.buscarUna(dni);
	}
	public void borrarCliente(Cliente cliente) {
		repositorioCliente.borrar(cliente);
	}
	public void insertarCliente(Cliente cliente) {
		repositorioCliente.insertar(cliente);
	}
	public void actualizarCliente(Cliente cliente) {
		repositorioCliente.actualizar(cliente);
	}
	public List<Factura> buscarTodosFacturasConLineas() {
		return repositorioFactura.buscarTodosConLineas();
	}
	public List<Factura> buscarTodosFacturasConLineasOrdenadas() {
			
		return repositorioFactura.buscarTodosConLineasOrdenadas();
	}
	public List<Factura> buscarTodosFacturasPor(String campo) {
		return repositorioFactura.buscarTodosPor(campo);
	}
	public List<Factura> filtrarFacturaPor(String tipo, String valor) {
		
		EntityManager em = factoria.createEntityManager();
		
		em.getTransaction().begin();
		repositorioFactura = new FacturaRepositorioJPA(em);
		List<Factura> lista = repositorioFactura.filtrarPor(tipo, valor);
		em.getTransaction().commit();
		return lista;
	}
	public Factura buscarUnaFactura(int numero) {
		return repositorioFactura.buscarUna(numero);
	}
	public void borrarFactura(Factura factura) {
		
		EntityManager em = factoria.createEntityManager();
		
		em.getTransaction().begin();
		repositorioFactura = new FacturaRepositorioJPA(em);
		repositorioFactura.borrar(factura);
		em.getTransaction().commit();
		
	}
	public void insertar(Factura factura) {
		
		EntityManager em = factoria.createEntityManager();
		
		em.getTransaction().begin();
		repositorioFactura = new FacturaRepositorioJPA(em);
		repositorioFactura.insertar(factura);
		em.getTransaction().commit();
		
	}
	public void actualizarFactura(Factura factura) {
		repositorioFactura.actualizar(factura);
	}

	public List<Factura> buscarTodasFacturas() {
		// TODO Auto-generated method stub
		return repositorioFactura.buscarTodos();
	}
	
	
}
