import fi.tkk.cs.tkkcc.SlxCompiler;
import fi.tkk.cs.tkkcc.slx.Interpreter;
import fi.tkk.cs.tkkcc.slx.SlxProgram;

public class Compiler implements SlxCompiler {

	private boolean errors;
	
	/**
	 * Constructor
	 */
	public Compiler() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see fi.tkk.cs.tkkcc.SlxCompiler#isErrors()
	 */
	@Override
	public boolean isErrors() {
		return errors;
	}

	/* (non-Javadoc)
	 * @see fi.tkk.cs.tkkcc.SlxCompiler#compile(java.lang.String)
	 */
	@Override
	public SlxProgram compile(String sourceFilename) {
		return this.compile(sourceFilename, false);
	}
	
	/**
	 * Compile a program. Support printing all kinds of relevant info.
	 * 
	 * @param sourceFilename source code filename
	 * @param verbose print information about compilation
	 * @return compiled SlxProgram object
	 */
	public SlxProgram compile(String sourceFilename, boolean verbose) {
		Scanner scanner = new Scanner(sourceFilename);
        Printer printer = new Printer(!verbose);
        
        printer.print("## Compiling...");
		Parser parser = new Parser(scanner, printer);
		parser.Parse();

		printer.print("#### Error count: " + parser.errors.count);
		this.errors = parser.errors.count > 0;
		
		SlxProgram program = parser.getSlx();
		
		if (verbose) {
			printer.print("\n## SLX program code:");
			printer.print(program.toString());
			
			printer.print("\n#### Symbol table:");
			printer.print(parser.getSymbolTable().toString());
			
			printer.print("\n## Executing...");
			Interpreter i = new Interpreter(program, "debug");
			int[] input = {};
			i.execute(true, input);
			
			printer.print("#### Execution complete: " + i.isProgramExecuted());
		}
		return program;
	}

	/**
	 * A main method for testing.
	 * 
	 * @param args command-line parameters (first should be input)
	 */
	public static void main(String[] args) {
		Compiler c = new Compiler();
		c.compile(args[0], true);
	}

}
