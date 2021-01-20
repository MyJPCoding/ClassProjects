
public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super("Samsung"+versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	return this.getRingTone();
    }
    @Override
    public String unlock() {
    	return "Your IPhone has been unlocked.";
    } 
	@Override
	public void displayInfo() {
		System.out.println(this.getVersionNumber());
		System.out.println(this.getBatteryPercentage());
		System.out.println(this.getCarrier());
		System.out.println(this.getRingTone());
	}

}
