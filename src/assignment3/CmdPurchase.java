package assignment3;

public class CmdPurchase implements Command {
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		return v.buyProduct(cmdParts[1], v.countCoin());
	}
}
