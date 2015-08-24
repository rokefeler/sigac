package net.rokefeler.sigac.controller;

import net.rokefeler.sigac.modelo.Persona;
import org.primefaces.context.RequestContext;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class SeleccionaPersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Persona personas;
	
	private String nombre;
	
	private List<Persona> personasFiltradas;

	public void pesquisar() {

		personasFiltradas = personas.  clientes.porNomeSemelhante(nome);
	}
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 450);
		
		RequestContext.getCurrentInstance().openDialog("SelecaoCliente", opcoes, null);
	}
	
	public void selecionar(Cliente cliente) {
		RequestContext.getCurrentInstance().closeDialog(cliente);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getClientesFiltrados() {
		return clientesFiltrados;
	}

}