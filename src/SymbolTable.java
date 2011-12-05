import java.util.HashMap;

/**
 * A simple symbol table class.
 * 
 * Internally uses a HashMap and provides name-address lookup.
 * The class was made instead of using HashMap directly so its easier to
 * change implementation if needed.
 */
public class SymbolTable {
	private HashMap<String,Integer> symbols;
	
	public SymbolTable() {
		this.symbols = new HashMap<String,Integer>();
	}
	
	public void add(String name, int address) {
		this.symbols.put(name, address);
	}
	
	public int getAddress(String name) {
		return this.symbols.get(name);
	}
	
	public String toString() {
		return symbols.toString();
	}
}
