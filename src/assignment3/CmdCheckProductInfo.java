package assignment3;

public class CmdCheckProductInfo implements Command {
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		String name = cmdParts[1];
		int[] info = v.productInfo(name);
		return name + ": Price = " + info[0] + ", Quantity = " + info[1] + ".";
	}
}
