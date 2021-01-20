public class IPhone extends Phone implements Ringable {

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super("Iphone"+versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public void displayInfo() {
		System.out.println(this.getVersionNumber());
		System.out.println(this.getBatteryPercentage());
		System.out.println(this.getCarrier());
		System.out.println(this.getRingTone());

	}

	@Override
    public String unlock() {
        return "Your IPhone has been unlocked.";
    }
    @Override
    public String ring() {
    	return this.getRingTone();
    	
    }
         

}
