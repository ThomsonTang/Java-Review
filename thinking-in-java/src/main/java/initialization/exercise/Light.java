package initialization.exercise;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @version 8/8/14
 */
public class Light {
	private boolean on;

	Light(boolean on) {
		this.on = on;
	}

	void off() {
		this.on = false;
	}

	protected void finalize() throws Throwable {
		if (on)
			System.out.println("already turned on.");
		else
			System.out.println("turned off.");

		super.finalize();
	}

	public static void main(String[] args) {
		Light light = new Light(true);
		light.off();
		light = null;
//		new Light(true);

		Runtime.getRuntime().gc();

	}
}
