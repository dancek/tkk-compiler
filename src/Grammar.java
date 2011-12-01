public class Grammar {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(args[0]);
        Printer printer = new Printer(false);
	Parser parser = new Parser(scanner, printer);
	parser.Parse();
	}
}
