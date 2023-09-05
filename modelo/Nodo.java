package modelo;

import manejador.ArbolBinario;


public class Nodo{
	
	protected String info;
    protected Nodo nodoSig;
    protected int valor;
    protected Nodo izq;
    protected Nodo der;
    
    

    public Nodo(String info){
	this.info = info;
    }
    public Nodo(int valor) {
    	this.valor=valor;
    }
	public Nodo() {
		
	}
    public void setNodoSig(Nodo nodo){
	this.nodoSig = nodo;
    }
    public Nodo getNodoSig(){
	return this.nodoSig;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return this.info;
    }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public Nodo getDer() {
		return der;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}    
	
	
	
}
	

	
	


