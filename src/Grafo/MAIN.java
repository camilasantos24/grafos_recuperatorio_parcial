package Grafo;

import java.util.ArrayList;
import java.util.List;

public class MAIN {

	public MAIN() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Nodo n1 = new Nodo("A");
		Nodo n2 = new Nodo("B");
		Nodo n3 = new Nodo("C");
		Nodo n4 = new Nodo("D");
		Nodo n5 = new Nodo("E");
		Nodo n6 = new Nodo("F");
		
		Grafo g = new Grafo();
		
		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);
		g.addNodo(n5);
		g.addNodo(n6);
		
		g.conectar(n1, n2);
		g.conectar(n2, n3);
		g.conectar(n3, n4);
		g.conectar(n4, n6);
		g.conectar(n1, n5);
		g.conectar(n5, n6);
		
		if(es_grafo_plano(g, n1)) {
			System.out.println("es plano");
		}else {
			System.out.println("No es plano");
		}
		
		
		
	}
	
	public static boolean es_grafo_plano (Grafo g, Nodo fuente) {
	
		int cantidad_fuentes =0;
		int cantidad_sumideros=0;
		
		Vertice v = new Vertice(fuente);
		
		for (int i =0; i<g.getVertices().size(); i++) {
			if(es_sumidero(g, (Vertice) g.getVertices().get(i))) {
				cantidad_sumideros +=1;
			}
			
			if(es_fuente(g, (Vertice) g.getVertices().get(i))) {
				cantidad_fuentes +=1;
			}
			
		}
		
		if(cantidad_fuentes == 1 && cantidad_sumideros == 1 && es_fuente(g,v)) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	public static boolean es_sumidero (Grafo g, Vertice v) {
		List<Vertice>ady = new ArrayList();
		ady = g.getNeighbourhood(v);
		
		int cantidad_entradas =0;

		for(int i = 0; i<g.getAristas().size(); i++) {
			Arista a = (Arista) g.getAristas().get(i);
			if(a.getEnd().equals(v) ) {
				cantidad_entradas +=1;
			}
		}
		
		if(ady.size()==0 && cantidad_entradas > 0) {
			return true;
		}else {return false;}
	
	}
	public static boolean es_fuente (Grafo g, Vertice v) {
		List<Vertice>ady = new ArrayList();
		ady = g.getNeighbourhood(v);
		
		int cantidad_entradas =0;
		
		
		for(int i = 0; i<g.getAristas().size(); i++) {
			Arista a = (Arista) g.getAristas().get(i);
			if(a.getEnd().equals(v)) {
				cantidad_entradas +=1;
			}
		}
		
		if(ady.size()>0 && cantidad_entradas == 0) {
			return true;
		}else {return false;}
	}
	
	
	

}
