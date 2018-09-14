package es.avalon.servicios.impl;

import java.util.List;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.LineaFactura;
import es.avalon.negocio.LineaFacturaPK;
import es.avalon.repositorios.ClienteRepositorio;
import es.avalon.repositorios.FacturaRepositorio;
import es.avalon.repositorios.LineaFacturaRepositorio;

public class ServicioFacturacionImpl  {

	private FacturaRepositorio repositorioFactura;
	private LineaFacturaRepositorio repositorioLinea;
	private ClienteRepositorio repositorioCliente;
	public LineaFactura buscarUnaLinea(LineaFacturaPK clave) {
		return repositorioLinea.buscarUna(clave);
	}
	public void borrarLinea(LineaFactura LineaFactura) {
		repositorioLinea.borrar(LineaFactura);
	}
	public void insertar(LineaFactura LineaFactura) {
		repositorioLinea.insertar(LineaFactura);
	}
	public void actualizarLinea(LineaFactura LineaFactura) {
		repositorioLinea.actualizar(LineaFactura);
	}
	public List<Cliente> buscarTodosClientes() {
		return repositorioCliente.buscarTodos();
	}
	public List<Cliente> buscarTodosClientesPorNombre(String nombre) {
		return repositorioCliente.buscarTodosPorNombre(nombre);
	}
	public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.buscarTodosPorNombreApellidos(nombre, apellidos);
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
		return repositorioFactura.filtrarPor(tipo, valor);
	}
	public Factura buscarUnaFactura(int numero) {
		return repositorioFactura.buscarUna(numero);
	}
	public void borrarFactura(Factura factura) {
		repositorioFactura.borrar(factura);
	}
	public void insertar(Factura factura) {
		repositorioFactura.insertar(factura);
	}
	public void actualizarFactura(Factura factura) {
		repositorioFactura.actualizar(factura);
	}
	
	
}
