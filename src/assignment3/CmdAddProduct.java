package assignment3;

public class CmdAddProduct implements Command {
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		String name = cmdParts[1];
		int quantity = Integer.valueOf(cmdParts[2]);
		v.stockProduct(name, quantity);
		return "Added " + name + " for " + quantity + " can(s).";
	}
}
