import java.util.HashMap;

/**
 * A simple symbol table class.
 * 
 * Internally uses a HashMap and provides name-address lookup.
 * The class was made instead of using HashMap directly so its easier to
 * change implementation if needed.
 */
public class SymbolTable {
	private HashMap<String,Symbol> symbols;
	
	/**
	 * A class that describes a symbol.
	 * 
	 * This was made basically because Java doesn't have a Pair<T,S>
	 * or similar that we could use as HashMap value type.
	 */
	private class Symbol {
		private String name;
		private int address;
		private int type;
		
		private Symbol(String name, int address, int type) {
			this.name = name;
			this.address = address;
			this.type = type;
		}
	}
	
	public SymbolTable() {
		this.symbols = new HashMap<String,Symbol>();
	}
	
	/**
	 * Add a symbol to the table.
	 * 
	 * @param name symbol name
	 * @param address address
	 * @param type symbol type
	 */
	public void add(String name, int address, int type) {
		Symbol sym = new Symbol(name, address, type);
		this.symbols.put(name, sym);
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
		return this.symbols.get(name).address;
	}
	
	/**
	 * Get type of a symbol.
	 * 
	 * @param name symbol name
	 * @return symbol type
	 */
	public int getType(String name) {
		return this.symbols.get(name).type;
	}
	
	/**
	 * Return a string representation of the symbol table.
	 */
	public String toString() {
		String s = "";
		s += String.format("%20s %7s %7s\n", "name", "address", "type");

		for (Symbol sym : this.symbols.values()) {
			s += String.format("%20s %7d %7d\n", sym.name, sym.address, sym.type);
		}
		return s;
	}
}
