package manejador;

import java.util.Vector;


import modelo.Nodo;


public class ListaSimple {
	protected Nodo nodoRaiz;
	public int cuantos;
	
	
	public ListaSimple() {
		this.nodoRaiz=null;
		
	}
	
	public ListaSimple(int cuantos) {
		this.nodoRaiz=null;
		this.cuantos=cuantos;
		
	}

	 public void setNodoRaiz(Nodo nodoRaiz) {
	        this.nodoRaiz = nodoRaiz;
	    }
	    public Nodo getNodoRaiz() {
	        return nodoRaiz;
	    }
	    
	    public void insertarFinal(Nodo nodo){
	        //Nodo nodoAuxiliar = getNodoRaiz(); 
	    	Nodo nodoAuxiliar = this.nodoRaiz;
	    	
	        while(nodoAuxiliar.getNodoSig() != null){
	        	
	            nodoAuxiliar = nodoAuxiliar.getNodoSig();
	        }
	        
	        nodoAuxiliar.setNodoSig(nodo);
	    }
	    public void insertarFinal2(Nodo nodo,Nodo raiz){
	        //Nodo nodoAuxiliar = getNodoRaiz(); 
	    	Nodo nodoAuxiliar = raiz;
	        while(nodoAuxiliar.getNodoSig() != null){
	        	
	            nodoAuxiliar = nodoAuxiliar.getNodoSig();
	        }
	        
	        nodoAuxiliar.setNodoSig(nodo);
	    }
	    
	    public void imprimirNodosAdyacentes(){
	        Nodo nodoAux = this.getNodoRaiz();
	        String [] vector;
	        vector=new String[19];
	        int i=0,aux;
	        vector[i]=nodoAux.getInfo();
	        i++;
	        String lista = ("Adyacentes del nodo " + getNodoRaiz().getInfo() + ": ");
	        nodoAux = nodoAux.getNodoSig();
	        while(nodoAux != null){
	        	
	        	vector[i]=nodoAux.getInfo();
		       lista += nodoAux.getInfo() + (" ");
	           nodoAux = nodoAux.getNodoSig();
	
	        }
	        /*for(int r=0;r<i;r++)
	        {
	        	for(int j=0;j<i;j++)
	        	{
	        		if(r!=j)
	        		{
	        			if(vector[r].compareTo(vector[j])==0)
	        			{
	        				vector[j]="NADA";
	        			}
	        		}
	        	}
	        }
	        System.out.print("Adyacentes del nodo: ");
	        for(int r=0;r<i;r++)
	        {
	        	if(vector[r].compareTo("NADA")!=0)
	        	{
	        		System.out.print(vector[r]);
	        	}
	        }*/
	        System.out.println(lista);
	    }
	
	
	
}
