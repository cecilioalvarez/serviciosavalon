package es.avalon.servicios.impl;

import java.util.List;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.LineaFactura;
import es.avalon.negocio.LineaFacturaPK;

public interface ServivioFacturacion {

	LineaFactura buscarUnaLinea(LineaFacturaPK clave);

	void borrarLinea(LineaFactura LineaFactura);

	void insertar(LineaFactura LineaFactura);

	void actualizarLinea(LineaFactura LineaFactura);
	
	List<Factura> buscarTodosFacturas();


	List<Cliente> buscarTodosClientes();

	List<Cliente> buscarTodosClientesPorNombre(String campo);

	/*public List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos) {
		return repositorioCliente.busc(nombre, apellidos);
	}*/
	Cliente buscarCliente(String dni);

	void borrarCliente(Cliente cliente);

	void insertarCliente(Cliente cliente);

	void actualizarCliente(Cliente cliente);

	List<Factura> buscarTodosFacturasConLineas();

	List<Factura> buscarTodosFacturasConLineasOrdenadas();

	List<Factura> buscarTodosFacturasPor(String campo);

	List<Factura> filtrarFacturaPor(String tipo, String valor);

	Factura buscarUnaFactura(int numero);

	void borrarFactura(Factura factura);

	void insertar(Factura factura);

	void actualizarFactura(Factura factura);

}