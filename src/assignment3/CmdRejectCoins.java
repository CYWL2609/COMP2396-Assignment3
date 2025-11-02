package assignment3;

public class CmdRejectCoins implements Command {
	@Override
	public String execute(VendingMachine v, String[] cmdParts) {
		if (v.countCoin() == 0) {
			return "Rejected no coin!";
		} else {
			return v.rejectCoin();
		}
	}
}
