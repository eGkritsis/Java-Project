public class Gaming extends Product {
    private final double discount = 0.10;
    private String type;
    private String cpu;
    private String gpu;
    private String sCard;
    private int memory;

    public Gaming(int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems, String type, String cpu, String gpu, String sCard, int memory) {
        super(serialNumber, modelName, modelYear, constructor, price, availableItems);
        this.type = type;
        this.cpu = cpu;
        this.gpu = gpu;
        this.sCard = sCard;
        this.memory = memory;
    }


    public double getDiscount() {
        return this.discount;
    }
	public String getType(){
		return this.type;
	}



    public String toString() {
        return super.toString() +
                "\nType: " + this.type +
                "\nCpu: " + this.cpu +
                "\nGraphics Card: " + this.gpu +
                "\nSound Card: " + this.sCard +
                "\nMemory: " + this.memory + "GB";
    }

}
