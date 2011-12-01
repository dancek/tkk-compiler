import fi.tkk.cs.tkkcc.SlxCompiler;
import fi.tkk.cs.tkkcc.slx.SlxProgram;

public class Compiler implements SlxCompiler {

	/* (non-Javadoc)
	 * @see fi.tkk.cs.tkkcc.SlxCompiler#isErrors()
	 */
	@Override
	public boolean isErrors() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fi.tkk.cs.tkkcc.SlxCompiler#compile(java.lang.String)
	 */
	@Override
	public SlxProgram compile(String sourceFilename) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A main method for testing.
	 * 
	 * @param args command-line parameters (first should be input)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(args[0]);
        Printer printer = new Printer(false);
		Parser parser = new Parser(scanner, printer);
		parser.Parse();
	}

}
