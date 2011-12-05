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
	
	/**
	 * Add a symbol to the table.
	 * 
	 * @param name symbol name
	 * @param address address
	 */
	public void add(String name, int address) {
		this.symbols.put(name, address);
	}
	
	/**
	 * Check if a symbol exists in the table.
	 * 
	 * @param name symbol name
	 * @return true if the symbol already exists
	 */
	public boolean contains(String name) {
		return symbols.containsKey(name);
	}
	
	/**
	 * Get address of a symbol.
	 * 
	 * @param name symbol name
	 * @return symbol address
	 */
	public int getAddress(String name) {
		return this.symbols.get(name);
	}
	
	/**
	 * Return a string representation of the symbol table.
	 */
	public String toString() {
		return symbols.toString();
	}
}
